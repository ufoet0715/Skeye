package com.skeye.yagout.dal.dao;

import java.util.Set;

public interface YagoutRolesDao {
	Set<String> getRolesByName(String userName);
	boolean  userAddRole(Integer userId,Integer roleNo);
}
