package com.yagout.defense.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.UserLogEventTypeDao;
import com.yagout.defense.dal.model.UserLogEventType;
import com.yagout.defense.dal.model.UserLogEventTypeExample;
import com.yagout.defense.dal.model.UserLogEventTypeExample.Criteria;
import com.yagout.defense.service.UserLogEventTypeService;

@Service
public class UserLogEventTypeServiceImpl implements UserLogEventTypeService {

	@Autowired private UserLogEventTypeDao userLogEventTypeDao;
	
	@Override
	public boolean insertUserLogEventType(UserLogEventType userLogEventType) {
		return this.userLogEventTypeDao.insertUserLogEventType(userLogEventType);
	}

	@Override
	public List<UserLogEventType> getTypesByName(String typeName) {
		UserLogEventTypeExample example=new UserLogEventTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeNameEqualTo(typeName);
		
		return this.userLogEventTypeDao.getTypeByExample(example);
	}

	@Override
	public UserLogEventType getTypeByName(String typeName) {
		UserLogEventTypeExample example=new UserLogEventTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeNameEqualTo(typeName);
		
		return this.userLogEventTypeDao.getTypeByExample(example).get(0);
	}
	
	@Override
	public List<UserLogEventType> getUserLogEventType() {
		UserLogEventTypeExample example=new UserLogEventTypeExample();
		return this.userLogEventTypeDao.getTypeByExample(example);
	}
}
