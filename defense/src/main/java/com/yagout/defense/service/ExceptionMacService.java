package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.biz.bean.ExceptionMacBean;
import com.yagout.defense.dal.model.ExceptionMac;
import com.yagout.defense.util.CommonPage;

public interface ExceptionMacService  {
	public boolean save(List<ExceptionMac> exceptionMacs);
	public boolean save(ExceptionMac exceptionMac);
	public boolean delete(List<String> macs);
	public boolean delete(String mac);
	public boolean update(List<ExceptionMac> exceptionMacs);
	public boolean update(ExceptionMac exceptionMac);
	public List<Map<String, Object>> query(CommonPage commonPage);
	public ExceptionMac query(String mac);
	public List<ExceptionMacBean> queryList();
}
