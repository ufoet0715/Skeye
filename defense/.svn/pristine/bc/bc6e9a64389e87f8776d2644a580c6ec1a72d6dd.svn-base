package com.yagout.defense.dal.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.Ap;

public interface StationMapper {
	
	int batchUpdate(Map<String,Ap> stationList);
	
	int batchInsert(Map<String,Ap> stationList);
	
	int deleteStations(Map<String, List<String>> map);
	
	List<Map<String,Object>> selectAll(Map<String,Object> map);
	
	Map<String, Object> selectByMap(Map<String, Object> map);
	
	Map<String, String> selectAllByMac(String mac);
}