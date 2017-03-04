package com.xqls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dal.dao.RoleDao;
import com.xqls.dal.model.Role;
import com.xqls.dal.model.RoleExample;
import com.xqls.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired private RoleDao roleDao;
	
	@Override
	public List<Role> getList() {
		RoleExample example=new RoleExample();
		return this.roleDao.getListByExample(example);
	}
}
