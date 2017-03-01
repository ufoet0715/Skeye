package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.AlarmDao;
import com.yagout.defense.dal.model.StrategyExample;
import com.yagout.defense.dal.model.StrategyKey;
import com.yagout.defense.dal.service.AlarmMapper;

@Repository
public class AlarmDaoImpl implements AlarmDao {
	@Autowired 
	AlarmMapper mapper;
	
	@Override
	public List<Map<String,Object>> queryAlarms(Map<String, Object> map) {
		return mapper.selectAlarmsByMap(map);
	}

	@Override
	public List<Map<String, Object>> queryStrategies(Integer invadeId) {
		return mapper.selectStrategies(invadeId);
	}
	
	@Override
	public List<Map<String, Object>> queryDefaultStrategies(Integer invadeId) {
		return mapper.selectDefaultStrategies(invadeId);
	}
	
	@Override
	public boolean updateFlagById(Map<String, Object> map) {
		return mapper.updateFlagById(map)>0;
	}

	@Override
	public boolean insertStrategy(StrategyKey key) {
		return mapper.insertStrategy(key)>0;
	}
	
	@Override
	public int deleteStrategies(StrategyExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public boolean deleteStrategiesByInvade(int invadeId){
		return mapper.deleteStrategyByInvade(invadeId)>0;
	}

	public boolean updateStrategy(Map<String,Object> map){
		mapper.updateStrategy(map);
		return true;
	}
}
