package com.yagout.defense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.ApDao;
import com.yagout.defense.dal.model.Ap;
import com.yagout.defense.service.ApService;
import com.yagout.defense.util.CommonPage;
@Service
public class ApServiceImpl implements ApService{

	@Autowired
	private ApDao apDao;
	@Override
	public boolean save(List<Ap> ap) {
		int result = apDao.saveAps(ap);
		return ap.size()>=result&&result>0;
	}

	@Override
	public boolean save(Ap ap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Map<String, List<String>> map) {
		int result=apDao.deleteAps(map);
		return map.size()>=result&&result>0;
	}

	@Override
	public boolean delete(String macs, String tableName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(List<Ap> ap) {
		int result=apDao.updateAps(ap);
		return ap.size()>=result&&result>0;
	}

	@Override
	public boolean update(Ap ap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Map<String, Object>> query(CommonPage commonPage) {
		List<Map<String, Object>> list=apDao.getApByMap(commonPage.pageToMap());
		return list;
	}

	@Override
	public Map<String, Object> query(String mac, String tableName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mac", mac);
		map.put("tableName", tableName);
		return apDao.queryByMac(map);
	}

}
