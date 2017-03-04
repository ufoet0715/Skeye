package com.xqls.dal.service;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.UserSet;

public interface UserSetMapper {
	List<UserSet> getListByMap(Map<String,Object> map);
}
