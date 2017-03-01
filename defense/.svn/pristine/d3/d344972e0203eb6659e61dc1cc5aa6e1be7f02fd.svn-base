package com.yagout.defense.dal.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.util.CommonPage;

public interface AlarmRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlarmRecord record);

    int insertSelective(AlarmRecord record);

    AlarmRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlarmRecord record);
    
    List<Map<String,Object>>  getAlarmRecordByMap(Map<String, Object> map);

    int updateByPrimaryKey(AlarmRecord record);
    
    public int getReadState();
    
    public int updateReadState(Map map);
    
    public Map getAlarmRecordByMap();
}