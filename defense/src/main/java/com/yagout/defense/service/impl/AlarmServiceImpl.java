package com.yagout.defense.service.impl;

import com.yagout.defense.dal.dao.AlarmDao;
import com.yagout.defense.dal.model.StrategyExample;
import com.yagout.defense.dal.model.StrategyKey;
import com.yagout.defense.service.AlarmService;
import com.yagout.defense.util.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmDao dao;
   
    /*
     * 查询所有事件
     */
	@Override
	public List<Map<String, Object>> queryAlarmsByPage(CommonPage commonPage) {
		return dao.queryAlarms(commonPage.pageToMap());
	}

	/*
	 * 根据事件id来更新字段flag（是否激活）
	 */
	@Override
	public boolean updateFlagById(Map<String, Object> map) {
		return dao.updateFlagById(map);
	}
	
	/*
	 * 根据事件id获得事件当前策略
	 */
	@Override
	public List<Map<String, Object>> queryStrategies(Integer invadeId){
		return dao.queryStrategies(invadeId);
	}
	
	/*
	 * 根据事件id获得事件所有策略
	 */
	@Override
	public List<Map<String,Object>> queryDefaultStrategies(Integer invadeId){
		return dao.queryDefaultStrategies(invadeId);
	}

	/*
	 * 批量删除策略
	 */
	@Override
	public boolean deleteStrategies(List<Integer> ids) {
		StrategyExample example=new StrategyExample();
        example.createCriteria().andDefenseIdIn(ids);
        int rows=dao.deleteStrategies(example);
        return ids.size()>=rows&&rows>0;
	}
	
	/*
	 * 新增策略
	 */
	@Override
	public boolean insertStrategy(StrategyKey key) {
		return dao.insertStrategy(key);
	}
	
	@Override
	public boolean deleteStrategiesByInvade(int invadeId){
		return dao.deleteStrategiesByInvade(invadeId);
	}


	public boolean updateStrategy(Map<String,Object> map){
		return dao.updateStrategy(map);
	}



}
