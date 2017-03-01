package com.yagout.defense.service.impl;
//自组网AP
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.ApAdHocDao;
import com.yagout.defense.dal.model.ApAdHoc;
import com.yagout.defense.service.ApAdHocService;
import com.yagout.defense.util.CommonPage;
@Service
public class ApAdHocServiceImpl implements ApAdHocService {
	@Autowired
	private ApAdHocDao apAdHocDao ;
	@Override
	public boolean save(List<ApAdHoc> apAdHocs) {
		int result=apAdHocDao.saveApAdHocs(apAdHocs);
		return apAdHocs.size()>=result&&result>0;
	}
	@Override
	public List<Map<String, Object>> query(CommonPage commonPage) {
		List<Map<String, Object>> list=apAdHocDao.getApAdHocByMap(commonPage.pageToMap());
		return list;
	}
	@Override
	public boolean delete(List<String> macs) {
		int result=apAdHocDao.deleteApAdHocs(macs);
		return macs.size()>=result&&result>0;
	}
	@Override
	public ApAdHoc query(String mac){
		return apAdHocDao.queryByMac(mac);
	}
	@Override
	public boolean update(List<ApAdHoc> apAdHocs) {
		int result=apAdHocDao.saveApAdHocs(apAdHocs);
		return apAdHocs.size()>=result&&result>0;
	}
	@Override
	public boolean save(ApAdHoc apAdHoc) {
		
		return false;
	}
	@Override
	public boolean delete(String macs) {
		
		return false;
	}
	@Override
	public boolean update(ApAdHoc apAdHoc) {
		
		return false;
	}
	
	
	

}
