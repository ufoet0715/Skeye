package com.yagout.defense.dal.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Skeyedu on 2017/2/9.
 */
public class BaseDao {
	public static final int DEFAULT_BATCH_COUNT=1000;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
    public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
	protected  boolean  getResultByInt(int rows){
        return rows>0?true:false;
    }
	public<V> Map<String,List<V>> listToMap(List<V> list,String keyName){
		Map<String,List<V>> map=new HashMap<String,List<V>>();
		map.put(keyName, list);
		return map;
	}
    public <V> int groupCommit(List<V> dataList,int groupSize,String methdName,String keyName){
    	int result = 1;
        SqlSession batchSqlSession = null;
        try {
            batchSqlSession = this.sqlSessionTemplate
                    .getSqlSessionFactory()
                    .openSession(ExecutorType.BATCH, false);// 获取批量方式的sqlsession
            int batchLastIndex = groupSize;// 每批最后一个的下标
            for (int index = 0; index < dataList.size();) {
                if (batchLastIndex >= dataList.size()) {
                    batchLastIndex = dataList.size();
                    result = result * batchSqlSession.insert(methdName,this.listToMap(dataList.subList(index, batchLastIndex),keyName));
                    batchSqlSession.commit();
                    //System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
                    break;// 数据插入完毕，退出循环
                } else {
                    result = result * batchSqlSession.insert(methdName,this.listToMap(dataList.subList(index, batchLastIndex),keyName));
                    batchSqlSession.commit();
                    System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
                    index = batchLastIndex;// 设置下一批下标
                    batchLastIndex = index + (groupSize - 1);
                }
            }
            batchSqlSession.commit();
            batchSqlSession.clearCache();
        }catch(Exception e){
        	//事物处理
        	//e.printStackTrace();
        	result = 0;
        } 
        finally {
            batchSqlSession.close();
        }
        return result;
    }
    
}
