package com.yagout.defense.biz;

import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;

import java.util.Map;

public interface AlarmRecordBiz {
	public void queryAlarmRecordPage(CommonPage commonPage);

	public int getReadState();

	public CommonResult updateReadState(AlarmRecord record);

	public AlarmRecord queryById(Integer id);

	// public String queryAlarmRecordState();
}
