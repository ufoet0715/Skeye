package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.LoginBiz;
import com.yagout.defense.dal.model.Login;
import com.yagout.defense.service.LoginService;
import com.yagout.defense.service.UserLogService;
import com.yagout.defense.util.LogTypeEnum;

@Service
public class LoginBizImpl implements LoginBiz {

	@Autowired private LoginService loginService;
	
	@Autowired private UserLogService userLogService;
	
	@Override
	public void loginOut(){
		Subject subject = SecurityUtils.getSubject();
		if(subject!=null)
		{
			if (subject.isAuthenticated()) {
				this.userLogService.insertUserLog(LogTypeEnum.TYPE_LOGOUT, true, "");
				subject.logout();
			}
			else
			{
				this.userLogService.insertUserLog(LogTypeEnum.TYPE_LOGOUT, false, "", "没有权限");
			}
		}
		else
		{
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_LOGOUT, false, "", "没有用户");
		}
	}
	
	@Override
	public List<Login> getLoginByMap(Map<String,Object> map) {
		return this.loginService.getLoginByMap(map);
	}
}
