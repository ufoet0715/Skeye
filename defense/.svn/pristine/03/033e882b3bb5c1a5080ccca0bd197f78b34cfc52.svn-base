package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.ScanApDao;
import com.yagout.defense.dal.model.ScanAp;
import com.yagout.defense.dal.service.ScanApMapper;

@Repository
public class ScanApDaoImpl implements ScanApDao{
	@Autowired
	private ScanApMapper apMapper;
	
	@Override
	public List<Map<String, Object>> getApByMap(Map<String, Object> map) {
		return apMapper.getApByMap(map);
	}
	
	@Override
	public List<ScanAp> selectApList(){
		return apMapper.selectApList();
	}
	
	@Override
	public ScanAp selectByKey(String mac){
		return apMapper.selectByPrimaryKey(mac);
	}
	
}
