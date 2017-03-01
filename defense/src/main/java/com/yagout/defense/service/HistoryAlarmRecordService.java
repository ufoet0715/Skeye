package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.dal.model.HistoryAlarmRecord;
import com.yagout.defense.util.CommonPage;

public interface HistoryAlarmRecordService {
	public int getAlarmRecord();
	public List<Map<String,Object>> queryHistoryAlarmRecordPage(CommonPage commonPage);
	public int getReadState();
	public int updateReadState(Map map);
	
	public boolean insert(AlarmRecord record);
}
