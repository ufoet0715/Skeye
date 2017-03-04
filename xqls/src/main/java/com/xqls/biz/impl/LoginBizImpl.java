package com.xqls.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.biz.LoginBiz;
import com.xqls.dal.model.Login;
import com.xqls.service.LoginService;

@Service
public class LoginBizImpl implements LoginBiz {

	@Autowired private LoginService loginService;
	
	@Override
	public List<Login> getLoginByMap(Map<String, Object> map) {
		List<Login> loginList=null;
		try {
			loginList=this.loginService.getLoginByMap(map);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return loginList;
	}

}
