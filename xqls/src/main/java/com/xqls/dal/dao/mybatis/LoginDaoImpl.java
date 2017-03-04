package com.xqls.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.LoginDao;
import com.xqls.dal.model.Login;
import com.xqls.dal.service.LoginMapper;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired private LoginMapper loginMapper;
	
	@Override
	public List<Login> getLoginByMap(Map<String,Object> map) {
		return this.loginMapper.getLoginByMap(map);
	}
}
