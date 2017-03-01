package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.HistoryAlarmRecordDao;
import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.dal.service.HistoryAlarmRecordMapper;

@Repository
public class HistoryAlarmRecordDaoImpl implements HistoryAlarmRecordDao {
	 @Autowired
	private HistoryAlarmRecordMapper harMapper;
	@Override
	public List<Map<String, Object>> getHistoryAlarmRecordByMap(Map<String, Object> map) {
		return harMapper.getHistoryAlarmRecordByMap(map);		  
	}
	@Override
	public int getReadState() {
		// TODO Auto-generated method stub
		return harMapper.getReadState();
	}
	@Override
	public int updateReadState(Map map) {
		// TODO Auto-generated method stub
		return harMapper.updateReadState(map);
	}
	
	public int insert(AlarmRecord record){
		return harMapper.insertSelective(record);
	}

}
