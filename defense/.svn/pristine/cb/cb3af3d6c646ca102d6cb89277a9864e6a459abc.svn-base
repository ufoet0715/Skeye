package com.yagout.defense.service.impl;
//邻居AP
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.ApNeighborDao;
import com.yagout.defense.dal.model.ApNeighbor;
import com.yagout.defense.service.ApNeighborService;
import com.yagout.defense.util.CommonPage;
@Service
public class ApNeighborServiceImpl implements ApNeighborService {
	@Autowired
	private ApNeighborDao apNeighborDao ;
	@Override
	public boolean save(List<ApNeighbor> apNeighbors) {
		int result=apNeighborDao.saveApNeighbors(apNeighbors);
		return apNeighbors.size()>=result&&result>0;
	}
	@Override
	public List<Map<String, Object>> query(CommonPage commonPage) {
		List<Map<String, Object>> list=apNeighborDao.getApNeighborByMap(commonPage.pageToMap());
		return list;
	}
	@Override
	public boolean delete(List<String> macs) {
		int result=apNeighborDao.deleteApNeighbors(macs);
		return macs.size()>=result&&result>0;
	}
	@Override
	public ApNeighbor query(String mac){
		return apNeighborDao.queryByMac(mac);
	}
	@Override
	public boolean update(List<ApNeighbor> apNeighbors) {
		int result=apNeighborDao.saveApNeighbors(apNeighbors);
		return apNeighbors.size()>=result&&result>0;
	}
	@Override
	public boolean save(ApNeighbor apNeighbor) {
		
		return false;
	}
	@Override
	public boolean delete(String macs) {
		
		return false;
	}
	@Override
	public boolean update(ApNeighbor apNeighbor) {
		
		return false;
	}
	
	
	

}
