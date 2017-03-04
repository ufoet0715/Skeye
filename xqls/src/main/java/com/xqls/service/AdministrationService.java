package com.xqls.service;

import java.util.List;
import java.util.Map;

import com.xqls.bean.AdministrationBean;
import com.xqls.dal.model.Administration;

public interface AdministrationService {
	
	
	public List<Map<String, Object>> selectByMap(Map<String, Object> map);
	
	public AdministrationBean  selectByTableno(String tableno);
	
	public boolean updateAdministration(AdministrationBean administrationBean);
	
	public boolean addFiled(String tablename,String filed, String type);
	
	public List<Administration> selectByTablename(String tablename);
}
