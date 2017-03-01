package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

public interface StationNeighborDao {
	
	public List<Map<String, Object>> queryByMap(Map<String, Object> map);

}
