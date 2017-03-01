package com.yagout.defense.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.UserLogAndTypeDao;
import com.yagout.defense.dal.model.UserLogAndType;
import com.yagout.defense.service.UserLogAndTypeService;

@Repository
public class UserLogAndTypeServiceImpl implements UserLogAndTypeService {

	@Autowired private UserLogAndTypeDao userLogAndTypeDao;
	
	@Override
	public List<UserLogAndType> getByMap(Map<String, Object> map) {
		return this.userLogAndTypeDao.getByMap(map);
	}
}
