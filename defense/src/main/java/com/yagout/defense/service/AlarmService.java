package com.yagout.defense.service;
import com.yagout.defense.dal.model.StrategyKey;
import com.yagout.defense.util.CommonPage;

import java.util.List;
import java.util.Map;

public interface AlarmService {
  
    List<Map<String, Object>> queryAlarmsByPage(CommonPage commonPage);

    List<Map<String, Object>> queryStrategies(Integer invadeId);
    
    List<Map<String, Object>> queryDefaultStrategies(Integer invadeId);
    
    boolean updateFlagById(Map<String,Object> map);
	
	boolean deleteStrategies(List<Integer> StrategyIds);

	boolean insertStrategy(StrategyKey key);

	boolean deleteStrategiesByInvade(int invadeId);

    public boolean updateStrategy(Map<String,Object> map);
}
