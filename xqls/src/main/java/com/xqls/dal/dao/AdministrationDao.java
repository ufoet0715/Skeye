package com.xqls.dal.dao;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.Administration;

public interface AdministrationDao {
	
	
	public List<Map<String, Object>> selectByMap(Map<String, Object> map);
	public Administration  selectByTableno(String tableno);
	
	public boolean updateAdministration(Administration administration);
	
	public boolean addFile(String tablename,String filed, String type);
	
	
	public List<Administration> selectByTablename(String tablename);
	
	

}
