package com.skeye.yagout.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.yagout.dal.dao.YagoutPermissionsDao;
import com.skeye.yagout.dal.model.YagoutPermissions;
import com.skeye.yagout.service.YagoutPermissionsService;

@Service
public class YagoutPermissionsServiceImpl implements YagoutPermissionsService {
	@Autowired
	private YagoutPermissionsDao permissionsDao;

	@Override
	public List<YagoutPermissions> getAllPermissions() {
		return permissionsDao.getAllPermissions();
	}

}
