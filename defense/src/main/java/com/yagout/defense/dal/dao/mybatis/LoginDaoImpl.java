package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.LoginDao;
import com.yagout.defense.dal.model.Login;
import com.yagout.defense.dal.service.LoginMapper;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired private LoginMapper loginMapper;
	
	@Override
	public List<Login> getLoginByMap(Map<String,Object> map) {
		return this.loginMapper.getLoginByMap(map);
	}
}
