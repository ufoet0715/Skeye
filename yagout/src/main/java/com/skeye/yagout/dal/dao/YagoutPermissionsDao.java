package com.skeye.yagout.dal.dao;

import java.util.List;
import java.util.Set;

import com.skeye.yagout.dal.model.YagoutPermissions;

public interface YagoutPermissionsDao {

	Set<String> getPermissionsByUserName(String userName);
	
	List<YagoutPermissions> getAllPermissions();
}
