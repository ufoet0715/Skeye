package com.xqls.service;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.Login;

public interface LoginService {
	List<Login> getLoginByMap(Map<String,Object> map);
}
