package com.yagout.defense.dal.service;

import com.yagout.defense.dal.model.StrategyExample;
import com.yagout.defense.dal.model.StrategyKey;

import java.util.List;
import java.util.Map;

public interface AlarmMapper {
    List<Map<String, Object>> selectAlarmsByMap(Map<String,Object> map);
    
    List<Map<String, Object>> selectStrategies(Integer invadeId);
    
    List<Map<String,Object>> selectDefaultStrategies(Integer invadeId);
    
    int updateFlagById(Map<String,Object> map);
    
    int deleteByExample(StrategyExample example);
    
    int insertStrategy(StrategyKey key);
    
    int deleteStrategyByInvade(Integer invadeId);

    int updateStrategy(Map<String,Object> map);
}