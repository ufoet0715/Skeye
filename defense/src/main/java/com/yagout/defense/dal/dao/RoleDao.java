package com.yagout.defense.dal.dao;

import java.util.List;

import com.yagout.defense.dal.model.Role;
import com.yagout.defense.dal.model.RoleExample;

public interface RoleDao {

	public List<Role> selectRoleList(RoleExample example);
}
