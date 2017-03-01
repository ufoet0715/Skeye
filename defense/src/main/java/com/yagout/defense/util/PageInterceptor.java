package com.yagout.defense.util;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PageInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {

        //当前环境 MappedStatement，BoundSql，及sql取得
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String originalSql = boundSql.getSql().trim();
        Object parameterObject = boundSql.getParameterObject();

        //Page对象获取，“信使”到达拦截器！
        CommonPage page = null;

        try {
            page = searchPageWithXpath(boundSql.getParameterObject(), ".", "page", "*/page");
        } catch (Exception e) {
        }

        if (page != null) {
            String  tableAglistName=page.getTableAglisName();
            String tableFiled=page.getTableFiled();
            String tableName=page.getTableName();
            String whereSql =originalSql.indexOf("where")>0? originalSql.substring(originalSql.indexOf("where")):"";
            //Page对象存在的场合，开始分页处理
            String countSql;
            if (StringUtils.isNotEmpty(tableFiled)) {
                countSql = getCountSql(whereSql,tableAglistName,tableName);
            }else {
                countSql = getCountSql(originalSql);
            }
            Connection connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
            PreparedStatement countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = copyFromBoundSql(mappedStatement, boundSql, countSql);
            DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, countBS);
            parameterHandler.setParameters(countStmt);
            ResultSet rs = countStmt.executeQuery();
            int totRecord = 0;
            if (rs.next()) {
                totRecord = rs.getInt(1);
            }
            rs.close();
            countStmt.close();
            connection.close();

            //分页计算
            page.setiTotalRecords(totRecord);
           // page.setTotalPage(totRecord % page.getiDisplayLength() == 0 ? totRecord / page.getiDisplayLength() : totRecord / page.getiDisplayLength() + 1);

            //对原始Sql追加limit
            int offset = (page.getiDisplayStart()- 1) * page.getiDisplayLength();
            StringBuffer sb = new StringBuffer();
            if (StringUtils.isNotEmpty(tableFiled)) {
                String tableSql = originalSql.substring(0, originalSql.indexOf("where"));
                sb.append(tableSql).append(" join (").append(getLimitSql(whereSql,tableAglistName,tableFiled,tableName)).append(" limit ").append(offset).append(",").append(page.getiDisplayLength()).append(") tl on ").append(tableAglistName).append(".").append(tableFiled).append("=tl.").append(tableFiled);
            } else {
                sb.append(originalSql).append(" limit ").append(offset).append(",").append(page.getiDisplayLength());
            }

            BoundSql newBoundSql = copyFromBoundSql(mappedStatement, boundSql, sb.toString());
            MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));
            invocation.getArgs()[0] = newMs;
        }
        return invocation.proceed();

    }

    /**
     * 根据给定的xpath查询Page对象
     */
    private CommonPage searchPageWithXpath(Object o, String... xpaths) {
        JXPathContext context = JXPathContext.newContext(o);
        Object result;
        for (String xpath : xpaths) {
            try {
                result = context.selectSingleNode(xpath);
            } catch (JXPathNotFoundException e) {
                continue;
            }
            if (result instanceof CommonPage) {
                return (CommonPage) result;
            }
        }
        return null;
    }

    /**
     * 复制MappedStatement对象
     */
    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        Builder builder = new Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0)
            builder.keyProperty(append(ms.getKeyProperties()));//(String.join(",", ms.getKeyProperties()));
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());

        return builder.build();
    }

    private String append(String[] properties) {
        StringBuffer sbf = new StringBuffer();
        for (String s : properties) {
            sbf.append(s).append(",");
        }
        return sbf.toString();
    }

    /**
     * 复制BoundSql对象
     */
    private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql, String sql) {
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
            String prop = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(prop)) {
                newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
            }
        }
        return newBoundSql;
    }


    private String getLimitSql(String whereSql,String tableAglistName,String tableFiled,String tableName){
        StringBuffer sb = new StringBuffer();
        sb.append(" select ").append(tableAglistName).append(".").append(tableFiled).append(" from ").append(tableName).append(" ").append(tableAglistName).append(" ")
                .append(whereSql);
        return sb.toString();
    }

    /**
     * 根据原Sql语句获取对应的查询总记录数的Sql语句
     */
    private String getCountSql(String sql) {
        return "SELECT COUNT(1) FROM (" + sql + ") aliasForPage";
    }

    /**
     * 根据原Sql语句获取对应的查询总记录数的Sql语句
     */
    private String getCountSql(String whereSql,String tableAglistName,String tableName) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select count(1) from ").append(tableName).append(" ").append(tableAglistName).append(" ")
                .append(whereSql);
        return sb.toString();
    }

    public class BoundSqlSqlSource implements SqlSource {
        BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }

    public Object plugin(Object arg0) {
        return Plugin.wrap(arg0, this);
    }

    public void setProperties(Properties arg0) {
    }

    public static void main(String[] args) {
        int a = 9;
        int pageSize = 10;

    }
}  