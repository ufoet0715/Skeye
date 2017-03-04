package com.xqls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dal.dao.PermissionDao;
import com.xqls.dal.model.Permission;
import com.xqls.dal.model.PermissionExample;
import com.xqls.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired private PermissionDao permissionDao;
	
	@Override
	public List<Permission> getList() {
		PermissionExample example=new PermissionExample();
		return this.permissionDao.getListByExample(example);
	}
}
