package com.yagout.defense.dal.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ScanStation;

public interface ScanStationMapper {
    int deleteByPrimaryKey(String mac);

    int insert(ScanStation record);

    int insertSelective(ScanStation record);

    ScanStation selectByPrimaryKey(String mac);

    int updateByPrimaryKeySelective(ScanStation record);

    int updateByPrimaryKey(ScanStation record);
    
    List<Map<String,Object>> getStationByMap(Map<String,Object> map);
    List<ScanStation> getmacApisNull();
    List<Map<String,Object>> getmacApisNullByMap();
    List<ScanStation> selectStationList();
}