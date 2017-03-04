package com.xqls.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.PermissionDao;
import com.xqls.dal.model.Permission;
import com.xqls.dal.model.PermissionExample;
import com.xqls.dal.service.PermissionMapper;

@Repository
public class PermissionDaoImpl implements PermissionDao {

	@Autowired private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> getListByExample(PermissionExample example) {
		return this.permissionMapper.selectByExample(example);
	}
}
