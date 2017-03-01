package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.ScanStationDao;
import com.yagout.defense.dal.model.ScanStation;
import com.yagout.defense.dal.service.ScanStationMapper;
@Repository
public class ScanStationDaoImpl implements ScanStationDao{
	@Autowired
	private ScanStationMapper stationMapper;
	@Override
	public List<Map<String, Object>> getStationByMap(Map<String, Object> map) {
		List<Map<String,Object>> stationByMap = stationMapper.getStationByMap(map);
		return stationByMap;
	}
	public List<Map<String, Object>> getmacApisNullByMap() {
		List<Map<String,Object>> stationByMap = stationMapper.getmacApisNullByMap();
		return stationByMap;
	}
	

	public List<ScanStation> getMacapIsNull(){
		return stationMapper.getmacApisNull();
	}
	
	public ScanStation query(String mac){
		return stationMapper.selectByPrimaryKey(mac);
	}
	@Override
	public List<ScanStation> selectStationList(){
		return stationMapper.selectStationList();
	}
	
	@Override
	public ScanStation selectByKey(String mac){
		return stationMapper.selectByPrimaryKey(mac);
	}

}
