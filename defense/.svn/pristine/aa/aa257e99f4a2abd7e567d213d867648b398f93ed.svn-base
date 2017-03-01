package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.Station;

public interface StationDao {
	public List<Map<String,Object>> getStationByMap(Map<String, Object> map);
	/**
	 * 传入需要删除的mac的list集合，以及表名
	 * @param map
	 * @return
	 */
	public int deleteStations(Map<String, List<String>> map);
	/**
	 * 传入参数实体类Ap，Ap中是tableName和list<map<String,Object>>
	 * @param ap
	 * @return
	 */
	public int saveStations(List<Station> station);
	
	public int saveStations(List<Station> station,int batchCount);
	/**
	 * 通过mac和tableName进行查询
	 * @param map
	 * @return
	 */
	public Map<String, Object> queryByMac(Map<String, Object> map);
	
	public int updateStations(List<Station> station);
	
	/**
	 * 根据mac查询所在表的表名
	 * @param mac
	 * @return
	 */
	public Map<String, String> selectAllByMac(String mac);
}
