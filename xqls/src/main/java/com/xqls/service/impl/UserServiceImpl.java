package com.xqls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.service.UserService;
import com.xqls.dal.dao.UserDao;
import com.xqls.dal.model.User;
import com.xqls.dal.model.UserExample;
import com.xqls.dal.model.UserExample.Criteria;

/**
 * Created by Skeyedu on 2017/2/28.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean insertUser(User user) {
		return this.userDao.insertUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return this.userDao.updateUser(user);
	}

	@Override
	public boolean deleteUser(String userId) {
		return this.userDao.deleteUser(userId);
	}
	
	@Override
	public List<User> getUserListByLogin(String userName, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andPasswordEqualTo(password);
		
		return this.userDao.getListByExample(example);
	}

	@Override
	public List<User> getUserListForLogin(String tenantNo, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andTenantNoEqualTo(tenantNo);
		criteria.andPasswordEqualTo(password);
		
		return this.userDao.getListByExample(example);
	}
}
