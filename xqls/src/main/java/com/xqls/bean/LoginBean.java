package com.xqls.bean;

import java.io.Serializable;

import com.xqls.dal.model.Permission;
import com.xqls.dal.model.Role;
import com.xqls.dal.model.User;

/**
 * 
 * @author SCJ
 * Login的序列化类
 */
@SuppressWarnings("serial")
public class LoginBean implements Serializable{

	private String rowId;
	private User user;
	private Role role;
	private Permission permission;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public LoginBean() {

	}

	/**
	 * 获得用户的证书凭证
	 * @return userName
	 */
	public String getCredentialsSalt(){
		return this.user.getUserName();
	}
}
