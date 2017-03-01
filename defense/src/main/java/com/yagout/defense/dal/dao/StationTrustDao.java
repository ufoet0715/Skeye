package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.StationTrust;

public interface StationTrustDao {
	public List<Map<String,Object>> getStationTrustByMap(Map<String, Object> map);
	
	public int deleteStationTrusts(List<String> macs);
	
	public int saveStationTrusts(List<StationTrust> stationTrustList);
	
	public int saveStationTrusts(List<StationTrust> stationTrustList,int batchCount);
	
	public StationTrust queryByMac(String mac);
	
	public int updateStationTrusts(List<StationTrust> stationTrustList);
	
	public List<StationTrust> selectList();
}
