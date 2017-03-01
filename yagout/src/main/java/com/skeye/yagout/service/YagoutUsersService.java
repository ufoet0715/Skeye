package com.skeye.yagout.service;

import com.skeye.yagout.dal.model.YagoutUsers;
import com.skeye.yagout.util.CommonPage;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface YagoutUsersService {
    public YagoutUsers getUserByName(String userName);

    public Set<String> getRolesByName(String userName);

    public Set<String> getPermissionsByUserName(String userName);

    public List<Map> queryUserByPage(CommonPage commonPage);

    public YagoutUsers getUserById(Integer userId);

    public boolean saveUser(YagoutUsers users);

    public boolean updatePwd(Integer id, String pwd);

    public boolean  userAddRole(Integer userId,Integer roleNo);

    public boolean deleteUsers(List<Integer> userIds);
}
