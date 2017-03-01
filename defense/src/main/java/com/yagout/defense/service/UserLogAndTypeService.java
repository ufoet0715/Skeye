package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.UserLogAndType;

public interface UserLogAndTypeService {
	List<UserLogAndType> getByMap(Map<String,Object> map);
}
