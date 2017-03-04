package com.xqls.dal.model;

import java.util.List;

public class RolePermissionList {
	private List<Role> roleList;
	private List<Permission> permissionList;
	private List<RolePermissionOut> outList;

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public List<RolePermissionOut> getOutList() {
		return outList;
	}

	public void setOutList(List<RolePermissionOut> outList) {
		this.outList = outList;
	}

}
