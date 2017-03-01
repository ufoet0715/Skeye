package com.yagout.defense.biz.bean;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;


public class UserBean implements Serializable {

    private Integer userId;
    @NotEmpty(message = "登录名不能为空")
    private String userName;

    @NotEmpty(message = "登录密码不能为空")
    private String userPwd;

    private String remarks;

    private Date createTime;
    private Integer roleId;
    private String rePeatPassword;

    private String newPassword;

    private String roleName;
    
    private boolean isDefaultPwd;


	public boolean isDefaultPwd() {
		return isDefaultPwd;
	}

	public void setDefaultPwd(boolean isDefaultPwd) {
		this.isDefaultPwd = isDefaultPwd;
	}

	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRePeatPassword() {
        return rePeatPassword;
    }

    public void setRePeatPassword(String rePeatPassword) {
        this.rePeatPassword = rePeatPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getCredentialsSalt() {
        return userName ;
    }
}
