package com.yagout.defense.dal.dao;

import java.util.List;

import com.yagout.defense.dal.model.UserLog;

public interface UserLogDao {
    boolean insertUserLog(UserLog userLog);
    
    boolean insertUserLogByList(List<UserLog> list);
}
