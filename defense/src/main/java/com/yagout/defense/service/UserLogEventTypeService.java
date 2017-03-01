package com.yagout.defense.service;

import java.util.List;

import com.yagout.defense.dal.model.UserLogEventType;

public interface UserLogEventTypeService {
	boolean insertUserLogEventType(UserLogEventType userLogEventType);
	
	List<UserLogEventType> getTypesByName(String typeName);
	
	UserLogEventType getTypeByName(String typeName);
	
	List<UserLogEventType> getUserLogEventType();
}
