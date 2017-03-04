package com.xqls.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dal.dao.RolePermissionDetailDao;
import com.xqls.dal.model.RolePermissionDetail;
import com.xqls.service.RolePermissionDetailService;

@Service
public class RolePermissionDetailServiceImpl implements RolePermissionDetailService {

	@Autowired private RolePermissionDetailDao rolePermissionDetailDao;

	@Override
	public List<RolePermissionDetail> getListByMap(Map<String, Object> map) {
		return this.rolePermissionDetailDao.getListByMap(map);
	}
	
	
}
