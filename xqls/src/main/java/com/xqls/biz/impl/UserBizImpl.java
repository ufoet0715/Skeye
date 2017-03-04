package com.xqls.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.biz.UserBiz;
import com.xqls.dal.model.User;

import com.xqls.service.UserService;

@Service
public class UserBizImpl implements UserBiz{

	@Autowired private UserService userService;
	
	@Override
	public User checkUserForLogin(String tenantNo, String password) {
		User user=null;
		List<User> userList = null;
		try {
			userList = this.userService.getUserListForLogin(tenantNo, password);
			if(!userList.isEmpty())
			{
				user=userList.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return user;
	}

}
