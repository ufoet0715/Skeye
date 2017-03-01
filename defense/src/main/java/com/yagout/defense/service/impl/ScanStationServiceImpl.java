package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.bean.ScanStationBean;
import com.yagout.defense.dal.dao.ScanStationDao;
import com.yagout.defense.dal.model.ScanStation;
import com.yagout.defense.service.ScanStationService;
import com.yagout.defense.util.ObjectUtil;
@Service
public class ScanStationServiceImpl implements ScanStationService{
	@Autowired
	private ScanStationDao stationDao;

	@Override
	public List<Map<String, Object>> queryStation(Map<String, Object> map) {
		List<Map<String,Object>> stationByMap = stationDao.getStationByMap(map);
		return stationByMap;
	}
	
	
	public List<Map<String, Object>> getmacApisNullByMap() {
		List<Map<String,Object>> stationByMap = stationDao.getmacApisNullByMap();
		return stationByMap;
	}
	
	public List<ScanStation> getMacapIsNull(){
		return stationDao.getMacapIsNull();
	}
	@Override
	public List<ScanStation> queryStationList(){
		return stationDao.selectStationList();
	}
	
	@Override
	public ScanStationBean queryByKey(String mac){
		return (ScanStationBean) ObjectUtil.transfer(stationDao.selectByKey(mac), ScanStationBean.class);
	}
}
