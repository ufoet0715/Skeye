package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.StationNeighborDao;
import com.yagout.defense.dal.service.StationNeighborMapper;

@Repository
public class StationNeighborDaoImpl implements StationNeighborDao{

	
	@Autowired private StationNeighborMapper mapper;
	
	public List<Map<String, Object>> queryByMap(
			Map<String, Object> map) {
		return mapper.selectAll(map);
	}
}
