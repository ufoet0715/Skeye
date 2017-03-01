package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.ScanStationBiz;
import com.yagout.defense.biz.bean.ScanStationBean;
import com.yagout.defense.dal.model.ScanStation;
import com.yagout.defense.service.ScanStationService;

@Service
public class ScanStationBizImpl implements ScanStationBiz{
	@Autowired
	private ScanStationService stationService;

	@Override
	public List<Map<String, Object>> queryStationByPage(Map<String, Object> map) {
		List<Map<String,Object>> queryStation = stationService.queryStation(map);
		return queryStation;
	}
	
	public List<Map<String, Object>> getmacApisNullByMap(){
		List<Map<String,Object>> queryStation = stationService.getmacApisNullByMap();
		return queryStation;
	}
	
	public List<ScanStation> getMacapIsNull(){
		try {
			return stationService.getMacapIsNull();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public List<ScanStation> queryStationList(){
		return stationService.queryStationList();
	}
	
	@Override
	public ScanStationBean queryByKey(String mac){
		return stationService.queryByKey(mac);
	}
}


