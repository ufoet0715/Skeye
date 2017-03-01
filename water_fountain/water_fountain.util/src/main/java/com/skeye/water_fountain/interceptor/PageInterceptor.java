package com.skeye.water_fountain.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.skeye.water_fountain.util.CommonPage;

@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }) })
public class PageInterceptor implements Interceptor {

	private String append(String[] properties) {
		StringBuffer sbf = new StringBuffer();
		for (String s : properties) {
			sbf.append(s).append(",");
		}
		return sbf.toString();
	}

	private CommonPage searchPageWithXpath(Object o, String... xpaths) {
		JXPathContext context = JXPathContext.newContext(o);
		Object result = null;
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

	private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql, String sql) {
		BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(),
				boundSql.getParameterObject());
		for (ParameterMapping parameterMapping : boundSql.getParameterMappings()) {
			String property = parameterMapping.getProperty();
			if (boundSql.hasAdditionalParameter(property)) {
				newBoundSql.setAdditionalParameter(property, boundSql.getAdditionalParameter(property));
			}
		}
		return newBoundSql;
	}

	private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
		Builder builder = new Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0)
			builder.keyProperty(append(ms.getKeyProperties()));
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());

		return builder.build();
	}

	private String getCountSql(String sql) {
		return "SELECT COUNT(*) FROM (" + sql + ") aliasForPage";
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Object parameter = invocation.getArgs()[1];
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		String originalSql = boundSql.getSql().trim();
		Object parameterObject = boundSql.getParameterObject();

		CommonPage commonPage = null;
		commonPage = searchPageWithXpath(boundSql, "." ,"commonPage" ,"*/commonPage");

		if (commonPage != null) {
			String countSql = getCountSql(originalSql);
			Connection connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(countSql);
			BoundSql countBS = copyFromBoundSql(mappedStatement, boundSql, countSql);
			DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject,
					countBS);
			parameterHandler.setParameters(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			int totalRecord = 0;
			if (rs.next()) {
				totalRecord = rs.getInt(1);
			}
			rs.close();
			preparedStatement.close();
			connection.close();

			commonPage.setTotalRecord(totalRecord);
			commonPage.setTotalPage(totalRecord % commonPage.getPageSize() == 0 ? totalRecord / commonPage.getPageSize()
					: totalRecord / commonPage.getPageSize() + 1);

			int offset = (commonPage.getPageIndex() - 1) * commonPage.getPageSize();
			StringBuffer sb = new StringBuffer();
			sb.append(originalSql).append(" limit ").append(offset).append(",").append(commonPage.getPageSize());
			BoundSql newBoundSql = copyFromBoundSql(mappedStatement, boundSql, sb.toString());
			MappedStatement newMappedStatement = copyFromMappedStatement(mappedStatement,
					new BoundSqlSqlSource(newBoundSql));
			invocation.getArgs()[0] = newMappedStatement;
		}

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

	public class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		@Override
		public BoundSql getBoundSql(Object parameterObject) {
			return this.boundSql;
		}
	}
}
