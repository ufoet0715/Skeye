package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.StationAdHocDao;
import com.yagout.defense.dal.service.StationAdHocMapper;
@Repository
public class StationAdHocDaoImpl implements StationAdHocDao{
	
	
	@Autowired private StationAdHocMapper hocMapper;
	
	public List<Map<String, Object>> queryByMap(Map<String, Object> map){
		return hocMapper.selectAll(map);
	}

}
