package com.yagout.defense.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.RoleBiz;
import com.yagout.defense.biz.bean.RoleBean;
import com.yagout.defense.dal.model.RoleExample;
import com.yagout.defense.service.RoleService;

@Service
public class RoleBizImpl implements RoleBiz{

	@Autowired private RoleService roleService;
	
	public List<RoleBean> queryRoleList(){
		RoleExample example = new RoleExample();
		return roleService.queryRoleList(example);
	}
}
