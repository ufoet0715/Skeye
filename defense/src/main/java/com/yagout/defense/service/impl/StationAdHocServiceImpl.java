package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.StationAdHocDao;
import com.yagout.defense.service.StationAdHocService;

@Service
public class StationAdHocServiceImpl implements StationAdHocService{

	
	@Autowired private StationAdHocDao hocDao;
	
	public List<Map<String, Object>> queryByMap(Map<String, Object> map){
		return hocDao.queryByMap(map);
	}
}
