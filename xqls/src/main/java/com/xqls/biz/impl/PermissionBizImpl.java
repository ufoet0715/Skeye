package com.xqls.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.biz.PermissionBiz;
import com.xqls.dal.model.Permission;
import com.xqls.service.PermissionService;

@Service
public class PermissionBizImpl implements PermissionBiz {

	@Autowired private PermissionService permissionService;

	@Override
	public List<Permission> getList() {
		List<Permission> permissionList=null;
		try {
			permissionList=this.permissionService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return permissionList;
	}
}
