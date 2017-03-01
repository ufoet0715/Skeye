package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.AlarmRecordDao;
import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.dal.service.AlarmRecordMapper;
@Repository
public class AlarmRecordDaoImpl implements AlarmRecordDao{
	 @Autowired
	private AlarmRecordMapper arMapper;
	 
	 @Override
		public List<Map<String, Object>> getAlarmRecordByMap(Map<String, Object> map) {
			return arMapper.getAlarmRecordByMap(map);		  
		}
	@Override
	public int getReadState() {
		// TODO Auto-generated method stub
		return arMapper.getReadState();
	}
	@Override
	public int updateReadState(AlarmRecord record) {
		
		return arMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public Map getAlarmRecordByMap() {
		// TODO Auto-generated method stub
		return arMapper.getAlarmRecordByMap();
	}
	
	public AlarmRecord  queryById (Integer id){
		return arMapper.selectByPrimaryKey(id);
	}
}
