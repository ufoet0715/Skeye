package com.yagout.defense.service.impl;

import com.yagout.defense.dal.dao.AlarmRecordDao;
import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.service.AlarmRecordService;
import com.yagout.defense.util.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AlarmRecordServiceImpl implements AlarmRecordService{
	@Autowired
	private AlarmRecordDao arDao;
	
	@Override
	public List<Map<String, Object>> queryAlarmRecordPage(CommonPage commonPage) {
		 return  arDao.getAlarmRecordByMap(commonPage.pageToMap());
	}
	
	@Override
	public int getReadState() {
		// TODO Auto-generated method stub
		return arDao.getReadState();
	}

	@Override
	public boolean updateReadState(AlarmRecord record) {
		// TODO Auto-generated method stub
		return arDao.updateReadState(record)>0;
	}

	@Override
	public Map getAlarmRecordByMap() {
		// TODO Auto-generated method stub
		return arDao.getAlarmRecordByMap();
	}
	
	public AlarmRecord queryById(Integer id){
		return arDao.queryById(id);
	}

	
}
