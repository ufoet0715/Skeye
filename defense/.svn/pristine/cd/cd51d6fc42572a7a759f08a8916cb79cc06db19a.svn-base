package com.yagout.defense.biz.bean;

import java.io.Serializable;

import com.yagout.defense.dal.model.Menu;
import com.yagout.defense.dal.model.Role;
import com.yagout.defense.dal.model.User;

@SuppressWarnings("serial")
public class LoginBean implements Serializable{
	private int rowId;
	private User user;
	private Role role;
	private Menu menu;

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getCredentialsSalt()
	{
		return this.user.getUserName();
	}
	
	public LoginBean() {

	}
}
