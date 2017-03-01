package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.StationTrustDao;
import com.yagout.defense.dal.model.StationTrust;
import com.yagout.defense.service.StationTrustService;
import com.yagout.defense.util.CommonPage;
@Service
public class StationTrustServiceImpl implements StationTrustService {
	@Autowired
	private StationTrustDao stationTrustDao ;
	@Override
	public boolean save(List<StationTrust> stationTrusts) {
		int result=stationTrustDao.saveStationTrusts(stationTrusts);
		return stationTrusts.size()>=result&&result>0;
	}
	@Override
	public List<Map<String, Object>> query(CommonPage commonPage) {
		List<Map<String, Object>> list=stationTrustDao.getStationTrustByMap(commonPage.pageToMap());
		return list;
	}
	@Override
	public boolean delete(List<String> macs) {
		int result=stationTrustDao.deleteStationTrusts(macs);
		return macs.size()>=result&&result>0;
	}
	@Override
	public StationTrust query(String mac){
		return stationTrustDao.queryByMac(mac);
	}
	@Override
	public boolean update(List<StationTrust> stationTrusts) {
		int result=stationTrustDao.saveStationTrusts(stationTrusts);
		return stationTrusts.size()>=result&&result>0;
	}
	@Override
	public boolean save(StationTrust stationTrust) {
		
		return false;
	}
	@Override
	public boolean delete(String macs) {
		
		return false;
	}
	@Override
	public boolean update(StationTrust stationTrust) {
		
		return false;
	}
	
	@Override
	public List<StationTrust> query(){
		return stationTrustDao.selectList();
	}
	

}
