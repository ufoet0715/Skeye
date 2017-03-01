package com.yagout.defense.service.impl;

import com.yagout.defense.biz.bean.ScanApBean;
import com.yagout.defense.dal.dao.ScanApDao;
import com.yagout.defense.dal.model.ScanAp;
import com.yagout.defense.service.ScanApService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ScanApServiceImpl implements ScanApService{
	@Autowired
	private ScanApDao apDao;


	@Override
	public List<Map<String, Object>> queryApByPage(CommonPage commonPage) {
		return apDao.getApByMap(commonPage.pageToMap());
	}

	@Override
	public List<ScanAp> queryApList(){
		return apDao.selectApList();
	}

	@Override
	public ScanApBean queryByKey(String mac){
		return (ScanApBean) ObjectUtil.transfer(apDao.selectByKey(mac), ScanApBean.class);
	}

	@Override
	public List<Map<String, Object>> queryApMapList() {
		return apDao.getApByMap(new HashMap<String,Object>());
	}
}
