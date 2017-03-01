package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.StationVisitorDao;
import com.yagout.defense.service.StationVisitorService;

@Service
public class StationVisitorServiceImpl implements StationVisitorService{

	
	@Autowired private StationVisitorDao visitorDao;
	
	public List<Map<String, Object>> queryByMap(Map<String, Object> map){
		return visitorDao.queryByMap(map);
	}
}
