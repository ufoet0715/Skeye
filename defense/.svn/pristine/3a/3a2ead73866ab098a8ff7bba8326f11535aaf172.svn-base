package com.yagout.defense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.StationDao;
import com.yagout.defense.dal.model.Station;
import com.yagout.defense.service.StationService;
import com.yagout.defense.util.CommonPage;
@Service
public class StationServiceImpl implements StationService{

	@Autowired
	private StationDao stationDao;
	@Override
	public boolean save(List<Station> station) {
		int result = stationDao.saveStations(station);
		return station.size()>=result&&result!=0;
	}

	@Override
	public boolean save(Station station) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Map<String, List<String>> map) {
		int result=stationDao.deleteStations(map);
		return map.size()>=result&&result!=0;
	}

	@Override
	public boolean delete(String macs, String tableName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(List<Station> station) {
		int result=stationDao.updateStations(station);
		return station.size()>=result&&result!=0;
	}

	@Override
	public boolean update(Station station) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Map<String, Object>> query(CommonPage commonPage) {
		List<Map<String, Object>> list=stationDao.getStationByMap(commonPage.pageToMap());
		return list;
	}

	@Override
	public Map<String, Object> query(String mac, String tableName,Map<String, Object> alias) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mac", mac);
		map.put("tableName", tableName);
		map.put("alias", alias);
		return stationDao.queryByMac(map);
	}
	
	@Override
	public Map<String, String> queryAllByMac(String mac){
		return stationDao.selectAllByMac(mac);
	}

}
