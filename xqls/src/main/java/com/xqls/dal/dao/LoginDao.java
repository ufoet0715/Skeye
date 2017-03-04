package com.xqls.dal.dao;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.Login;

public interface LoginDao {
	List<Login> getLoginByMap(Map<String,Object> map);
}
