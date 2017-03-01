package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.LoginDao;
import com.yagout.defense.dal.model.Login;
import com.yagout.defense.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired private LoginDao loginDao;
	
	@Override
	public List<Login> getLoginByMap(Map<String,Object> map) {
		return this.loginDao.getLoginByMap(map);
	}
}
