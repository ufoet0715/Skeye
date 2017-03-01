package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.util.CommonPage;

public interface AlarmRecordService {
	public List<Map<String, Object>> queryAlarmRecordPage(CommonPage commonPage);

	public int getReadState();

	public boolean updateReadState(AlarmRecord record);

	public Map getAlarmRecordByMap();

	public AlarmRecord queryById(Integer id);
}
