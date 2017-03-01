package com.yagout.defense.service;

import java.util.List;

import com.yagout.defense.dal.model.DefenseType;
import com.yagout.defense.dal.model.UserLog;
import com.yagout.defense.util.LogTypeEnum;

public interface UserLogService {
    boolean insertUserLog(UserLog userLog);
    
    void insertUserLog(LogTypeEnum logTypeEnum,boolean isSuccess,String userName,String exception);
    
    void insertUserLog(LogTypeEnum logTypeEnum,boolean isSuccess,String exception);
    
    void insertUserLogByDefenseTypeList(boolean isSuccess,List<DefenseType> defenseTypesList,String exception);
}
