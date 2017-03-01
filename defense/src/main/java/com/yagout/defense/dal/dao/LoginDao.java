package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.Login;

public interface LoginDao {
	List<Login> getLoginByMap(Map<String,Object> map);
}
