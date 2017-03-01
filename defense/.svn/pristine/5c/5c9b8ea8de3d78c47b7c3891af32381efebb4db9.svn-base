package com.yagout.defense.service.impl;
//访客AP
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.ApVisitorDao;
import com.yagout.defense.dal.model.ApVisitor;
import com.yagout.defense.service.ApVisitorService;
import com.yagout.defense.util.CommonPage;
@Service
public class ApVisitorServiceImpl implements ApVisitorService {
	@Autowired
	private ApVisitorDao apVisitorDao ;
	@Override
	public boolean save(List<ApVisitor> apVisitors) {
		int result=apVisitorDao.saveApVisitors(apVisitors);
		return apVisitors.size()>=result&&result>0;
	}
	@Override
	public List<Map<String, Object>> query(CommonPage commonPage) {
		List<Map<String, Object>> list=apVisitorDao.getApVisitorByMap(commonPage.pageToMap());
		return list;
	}
	@Override
	public boolean delete(List<String> macs) {
		int result=apVisitorDao.deleteApVisitors(macs);
		return macs.size()>=result&&result>0;
	}
	@Override
	public ApVisitor query(String mac){
		return apVisitorDao.queryByMac(mac);
	}
	@Override
	public boolean update(List<ApVisitor> apVisitors) {
		int result=apVisitorDao.saveApVisitors(apVisitors);
		return apVisitors.size()>=result&&result>0;
	}
	@Override
	public boolean save(ApVisitor apVisitor) {
		
		return false;
	}
	@Override
	public boolean delete(String macs) {
		
		return false;
	}
	@Override
	public boolean update(ApVisitor apVisitor) {
		
		return false;
	}
	
	
	

}
