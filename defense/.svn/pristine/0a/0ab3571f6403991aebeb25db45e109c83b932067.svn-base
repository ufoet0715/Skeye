package com.yagout.defense.dal.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.dal.model.HistoryAlarmRecord;
import org.apache.ibatis.annotations.Param;

public interface HistoryAlarmRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HistoryAlarmRecord record);

    int insertSelective(AlarmRecord record);

    //History_alarm_record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HistoryAlarmRecord record);

    int updateByPrimaryKey(HistoryAlarmRecord record);
    
    List<Map<String,Object>>  getHistoryAlarmRecordByMap(Map<String,Object> map);
    public int getReadState();
    public int updateReadState(Map map);
}