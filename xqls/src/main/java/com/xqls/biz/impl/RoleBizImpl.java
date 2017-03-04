package com.xqls.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.biz.RoleBiz;
import com.xqls.dal.model.Role;
import com.xqls.service.RoleService;

@Service
public class RoleBizImpl implements RoleBiz {
	@Autowired private RoleService roleService;
	
	@Override
	public List<Role> getList() {
		return this.roleService.getList();
	}
}
