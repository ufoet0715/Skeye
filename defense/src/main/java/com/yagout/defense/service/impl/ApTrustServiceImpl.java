package com.yagout.defense.service.impl;
//信任AP
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.ApTrustDao;
import com.yagout.defense.dal.model.ApTrust;
import com.yagout.defense.service.ApTrustService;
import com.yagout.defense.util.CommonPage;
@Service
public class ApTrustServiceImpl implements ApTrustService {
	@Autowired
	private ApTrustDao apTrustDao ;
	@Override
	public boolean save(List<ApTrust> apTrusts) {
		int result=apTrustDao.saveApTrusts(apTrusts);
		return apTrusts.size()>=result&&result>0;
	}
	@Override
	public List<Map<String, Object>> query(CommonPage commonPage) {
		List<Map<String, Object>> list=apTrustDao.getApTrustByMap(commonPage.pageToMap());
		return list;
	}
	@Override
	public boolean delete(List<String> macs) {
		int result=apTrustDao.deleteApTrusts(macs);
		return macs.size()>=result&&result>0;
	}
	@Override
	public ApTrust query(String mac){
		return apTrustDao.queryByMac(mac);
	}
	@Override
	public boolean update(List<ApTrust> apTrusts) {
		int result=apTrustDao.saveApTrusts(apTrusts);
		return apTrusts.size()>=result&&result>0;
	}
	@Override
	public boolean save(ApTrust apTrust) {
		
		return false;
	}
	@Override
	public boolean delete(String macs) {
		
		return false;
	}
	@Override
	public boolean update(ApTrust apTrust) {
		
		return false;
	}
	
	
	

}
