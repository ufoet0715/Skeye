package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.dal.model.HistoryAlarmRecord;

public interface HistoryAlarmRecordDao {
	public List<Map<String,Object>> getHistoryAlarmRecordByMap(Map<String, Object> map);
	public int getReadState();
	public int updateReadState(Map map);
	
	public int insert(AlarmRecord record);
}
