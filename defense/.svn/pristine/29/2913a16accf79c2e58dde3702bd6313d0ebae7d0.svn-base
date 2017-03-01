package com.yagout.defense.dal.dao;

import com.yagout.defense.dal.model.StrategyExample;
import com.yagout.defense.dal.model.StrategyKey;

import java.util.List;
import java.util.Map;

public interface AlarmDao {
	List<Map<String,Object>> queryAlarms(Map<String,Object> map);
	
	List<Map<String,Object>> queryStrategies(Integer invadeId);
	
	List<Map<String,Object>> queryDefaultStrategies(Integer invadeId);

	boolean updateFlagById(Map<String,Object> map);
	
	int deleteStrategies(StrategyExample example);

	boolean insertStrategy(StrategyKey key);

	boolean deleteStrategiesByInvade(int invadeId);
	public boolean updateStrategy(Map<String,Object> map);
}
