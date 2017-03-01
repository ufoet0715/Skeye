package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.DefenseType;

public interface DefenseTypeDao {
    List<DefenseType> getDefenseTypeByMap(Map<String,Object> map);
}
