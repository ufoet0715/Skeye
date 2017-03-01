package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.bean.ExceptionMacBean;
import com.yagout.defense.dal.dao.ExceptionMacDao;
import com.yagout.defense.dal.model.ExceptionMac;
import com.yagout.defense.service.ExceptionMacService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.ObjectUtil;
@Service
public class ExceptionMacServiceImpl implements ExceptionMacService {
	@Autowired
	private ExceptionMacDao exceptionMacDao ;
	@Override
	public boolean save(List<ExceptionMac> exceptionMacs) {
		int result=exceptionMacDao.saveExceptionMacs(exceptionMacs);
		return exceptionMacs.size()>=result&&result>0;
	}
	@Override
	public List<Map<String, Object>> query(CommonPage commonPage) {
		List<Map<String, Object>> list=exceptionMacDao.getExceptionMacByMap(commonPage.pageToMap());
		return list;
	}
	@Override
	public boolean delete(List<String> macs) {
		int result=exceptionMacDao.deleteExceptionMacs(macs);
		return macs.size()>=result&&result>0;
	}
	@Override
	public ExceptionMac query(String mac){
		return exceptionMacDao.queryByMac(mac);
	}
	@Override
	public boolean update(List<ExceptionMac> exceptionMacs) {
		int result=exceptionMacDao.saveExceptionMacs(exceptionMacs);
		return exceptionMacs.size()>=result&&result>0;
	}
	@Override
	public boolean save(ExceptionMac exceptionMac) {
		
		return false;
	}
	@Override
	public boolean delete(String mac) {
		
		return exceptionMacDao.deleteByMac(mac)>0;
	}
	@Override
	public boolean update(ExceptionMac exceptionMac) {
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExceptionMacBean> queryList(){
		return ObjectUtil.transferList(exceptionMacDao.queryList(), ExceptionMacBean.class);
	}
	

}
