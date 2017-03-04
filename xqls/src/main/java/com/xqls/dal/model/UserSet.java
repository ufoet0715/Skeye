package com.xqls.dal.model;

public class UserSet {
	private String userId;
	private String userName;
	private String password;
	private String name;
	private String telephone;
	private String tenantNo;
	private Integer msgAlertLevel;
	private String roleId;
	private String roleName;
	private Integer blockId;
	private String blockName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTenantNo() {
		return tenantNo;
	}

	public void setTenantNo(String tenantNo) {
		this.tenantNo = tenantNo;
	}

	public Integer getMsgAlertLevel() {
		return msgAlertLevel;
	}

	public void setMsgAlertLevel(Integer msgAlertLevel) {
		this.msgAlertLevel = msgAlertLevel;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
}
