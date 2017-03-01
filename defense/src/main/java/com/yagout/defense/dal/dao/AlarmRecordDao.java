package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.AlarmRecord;

public interface AlarmRecordDao {
	public List<Map<String,Object>> getAlarmRecordByMap(Map<String, Object> map);
	public int getReadState();
	public int updateReadState(AlarmRecord record);
	public Map getAlarmRecordByMap(); 
	
	public AlarmRecord  queryById (Integer id);
}
