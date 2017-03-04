package com.xqls.service;

import java.util.List;

import com.xqls.dal.model.User;

/**
 * Created by Skeyedu on 2017/1/19.
 */
public interface UserService {
	
    boolean insertUser(User user);
    
    boolean updateUser(User user);
    
    boolean deleteUser(String userId);
	
	List<User> getUserListByLogin(String userName,String password);
    
    List<User> getUserListForLogin(String tenantNo,String password);
}
