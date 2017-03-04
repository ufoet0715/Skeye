package com.xqls.dal.dao;

import java.util.List;

import com.xqls.dal.model.User;
import com.xqls.dal.model.UserExample;

public interface UserDao {
    boolean insertUser(User user);
    
    boolean updateUser(User user);
    
    boolean deleteUser(String userId);
    
    List<User> getListByExample(UserExample example);
}
