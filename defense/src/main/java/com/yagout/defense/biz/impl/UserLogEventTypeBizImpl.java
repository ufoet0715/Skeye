package com.yagout.defense.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.UserLogEventTypeBiz;
import com.yagout.defense.dal.model.UserLogEventType;
import com.yagout.defense.service.UserLogEventTypeService;

@Service
public class UserLogEventTypeBizImpl implements UserLogEventTypeBiz {

	@Autowired private UserLogEventTypeService userLogEventTypeService;
	
	@Override
	public List<UserLogEventType> getUserLogEventType() {
		return this.userLogEventTypeService.getUserLogEventType();
	}
}
