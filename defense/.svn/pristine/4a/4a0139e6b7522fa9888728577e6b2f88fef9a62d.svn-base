package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.StationNeighborDao;
import com.yagout.defense.service.StationNeighborService;

@Service
public class StationNeighborServiceImpl implements StationNeighborService{
	
	
	@Autowired private StationNeighborDao neighborDao;
	
	public List<Map<String, Object>> queryByMap(Map<String, Object> map){
		return neighborDao.queryByMap(map);
	}
			
	

}
