package com.skeye.yagout.dal.dao;

import com.skeye.yagout.dal.model.YagoutUsers;
import com.skeye.yagout.dal.model.YagoutUsersExample;

import java.util.List;
import java.util.Map;

public interface YagoutUsersDao {
    public YagoutUsers getUserByName(String userName);

    public YagoutUsers getUserById(Integer userId);

    public List<Map> getUserByMap(Map<String, Object> map);

    public List<YagoutUsers> getUserByExamle(YagoutUsersExample example);

    public boolean saveUser(YagoutUsers users);

    public boolean updatePwd(YagoutUsers users);

    public int deleteUsers(YagoutUsersExample example);

}
