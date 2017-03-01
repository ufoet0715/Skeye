package com.yagout.defense.dal.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ScanAp;

public interface ScanApMapper {
    int deleteByPrimaryKey(String mac);

    int insert(ScanAp record);

    int insertSelective(ScanAp record);

    ScanAp selectByPrimaryKey(String mac);

    int updateByPrimaryKeySelective(ScanAp record);

    int updateByPrimaryKey(ScanAp record);
    
    List<Map<String,Object>> getApByMap(Map<String,Object> map);
    
    List<ScanAp> selectApList();
}