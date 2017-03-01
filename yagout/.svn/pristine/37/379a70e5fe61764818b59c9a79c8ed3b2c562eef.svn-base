package com.skeye.yagout.dal.dao.mybatis;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.yagout.dal.dao.YagoutPermissionsDao;
import com.skeye.yagout.dal.model.YagoutPermissions;
import com.skeye.yagout.dal.service.YagoutPermissionsMapper;


@Repository
public class YagoutPermissionsDaoImpl implements YagoutPermissionsDao {
	@Autowired YagoutPermissionsMapper yagoutPermissionsMapper;
	@Override
	public Set<String> getPermissionsByUserName(String userName) {
		return yagoutPermissionsMapper.getPermissionsByUserName(userName);
	}

	@Override
	public List<YagoutPermissions> getAllPermissions() {
		return yagoutPermissionsMapper.selectByExample(null);
	}

}
