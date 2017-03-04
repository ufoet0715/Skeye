package com.xqls.biz;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.Login;

public interface LoginBiz {
	List<Login> getLoginByMap(Map<String,Object> map);
}
