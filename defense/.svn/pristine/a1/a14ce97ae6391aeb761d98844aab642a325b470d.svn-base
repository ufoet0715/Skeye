package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;


import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.ObjectUtil;
import com.yagout.defense.dal.dao.HistoryAlarmRecordDao;
import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.dal.model.HistoryAlarmRecord;
import com.yagout.defense.service.HistoryAlarmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HistoryAlarmRecordServiceImpl implements HistoryAlarmRecordService {
	@Autowired
	private HistoryAlarmRecordDao harDao;
	@Override
	public int getAlarmRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> queryHistoryAlarmRecordPage(CommonPage commonPage) {
		 return  harDao.getHistoryAlarmRecordByMap(commonPage.pageToMap());
	}

	@Override
	public int getReadState() {
		// TODO Auto-generated method stub
		return harDao.getReadState();
	}

	@Override
	public int updateReadState(Map map) {
		// TODO Auto-generated method stub
		return harDao.updateReadState(map);
	}
	
	public boolean insert(AlarmRecord record){
		return harDao.insert(record)>0;
	}

}
