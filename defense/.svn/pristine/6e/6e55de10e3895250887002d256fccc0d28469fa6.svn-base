package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.StationVisitorDao;
import com.yagout.defense.dal.service.StationVisitorMapper;

@Repository
public class StationVisitorDaoImpl implements StationVisitorDao{
	
	@Autowired StationVisitorMapper mapper;
	
	
	public List<Map<String, Object>> queryByMap(
			Map<String, Object> map) {
		return mapper.selectAll(map);
	}

}
