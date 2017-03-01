package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.Ap;

public interface ApDao {
	public List<Map<String,Object>> getApByMap(Map<String, Object> map);
	/**
	 * 传入需要删除的mac的list集合，以及表名
	 * @param map
	 * @return
	 */
	public int deleteAps(Map<String, List<String>> map);
	/**
	 * 传入参数实体类Ap，Ap中是tableName和list<map<String,Object>>
	 * @param ap
	 * @return
	 */
	public int saveAps(List<Ap> ap);
	
	public int saveAps(List<Ap> ap,int batchCount);
	/**
	 * 通过mac和tableName进行查询
	 * @param map
	 * @return
	 */
	public Map<String, Object> queryByMac(Map<String, Object> map);
	
	public int updateAps(List<Ap> ap);
}
