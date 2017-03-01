package com.yagout.defense.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.RoleDao;
import com.yagout.defense.dal.model.Role;
import com.yagout.defense.dal.model.RoleExample;
import com.yagout.defense.dal.service.RoleMapper;

@Repository
public class RoleDaoImpl implements RoleDao{

	@Autowired private RoleMapper roleMapper;
	
	public List<Role> selectRoleList(RoleExample example){
		return roleMapper.selectByExample(example);
	}
}
