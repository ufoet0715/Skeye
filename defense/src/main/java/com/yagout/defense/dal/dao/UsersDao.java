package com.yagout.defense.dal.dao;


import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.User;
import com.yagout.defense.dal.model.UserExample;

/**
 * 用户dao
 */
public interface UsersDao {
    public User getUserByName(String userName);

    public User getUserById(Integer userId);

    public List<Map<String,Object>> getUserByMap(Map<String, Object> map);
    
    public List<User> queryUsersList(UserExample example);

    public boolean saveUser(User users);

    public boolean updatePwd(User users);
    
    public boolean updateById(User user);

    public boolean deleteUsers(Map<String, Object> map);
    
    List<User> getUserForLogin(UserExample example);
}
