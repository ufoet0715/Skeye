package com.xqls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dal.dao.RolePermissionDao;
import com.xqls.dal.model.RolePermission;
import com.xqls.dal.model.RolePermissionKey;
import com.xqls.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired private RolePermissionDao rolePermissionDao;
	
	@Override
	public boolean insertByList(List<RolePermission> list) {
		return this.rolePermissionDao.insertByList(list);
	}

	@Override
	public boolean updateRecord(RolePermission rolePermission) {
		return this.rolePermissionDao.updateRecord(rolePermission);
	}

	@Override
	public boolean deleteByList(List<RolePermissionKey> list) {
		return this.rolePermissionDao.deleteByList(list);
	}
}
