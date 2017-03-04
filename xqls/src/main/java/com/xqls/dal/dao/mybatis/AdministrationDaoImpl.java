package com.xqls.dal.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.AdministrationDao;
import com.xqls.dal.model.Administration;
import com.xqls.dal.model.AdministrationExample;
import com.xqls.dal.service.AdministrationMapper;

@Repository
public class AdministrationDaoImpl implements AdministrationDao{
	
	
	@Autowired private AdministrationMapper administrationMapper;
	
	
	public List<Map<String, Object>> selectByMap(Map<String, Object> map){
		return administrationMapper.selectByMap(map);
		
	}
	
	public Administration  selectByTableno(String tableno){
		return administrationMapper.selectByPrimaryKey(tableno);
		
	}
	
	public boolean updateAdministration(Administration administration){
		return administrationMapper.updateByPrimaryKey(administration)>0;
	}
	
	public boolean addFile(String tablename,String filed, String type) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("tablename", tablename);
		map.put("filed", filed);
		map.put("type", type);
		return administrationMapper.addFiled(map)>0;
	}
	
	public List<Administration> selectByTablename(String tablename){
		AdministrationExample example=new AdministrationExample();
		example.createCriteria().andTablenameLike(tablename);
		 return administrationMapper.selectByExample(example);
	}
	

}
