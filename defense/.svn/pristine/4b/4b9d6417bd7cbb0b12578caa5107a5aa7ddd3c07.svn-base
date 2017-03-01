package com.yagout.defense.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.bean.RoleBean;
import com.yagout.defense.dal.dao.RoleDao;
import com.yagout.defense.dal.model.RoleExample;
import com.yagout.defense.service.RoleService;
import com.yagout.defense.util.ObjectUtil;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired private RoleDao roleDao;
	
	@SuppressWarnings("unchecked")
	public List<RoleBean> queryRoleList(RoleExample example){
		return ObjectUtil.transferList(roleDao.selectRoleList(example), RoleBean.class);
	}
}
