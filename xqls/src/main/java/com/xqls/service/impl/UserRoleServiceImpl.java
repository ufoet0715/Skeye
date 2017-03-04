package com.xqls.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dal.dao.UserRoleDao;
import com.xqls.dal.model.UserRole;
import com.xqls.dal.model.UserRoleKey;
import com.xqls.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired private UserRoleDao userRoleDao; 
	
	@Override
	public boolean insertDate(UserRole useRole) {
		return this.userRoleDao.insertDate(useRole);
	}

	@Override
	public boolean updateData(UserRole userRole) {
		return this.userRoleDao.updateData(userRole);
	}

	@Override
	public boolean deleteData(UserRoleKey userRoleKey) {
		return this.userRoleDao.deleteData(userRoleKey);
	}
}
