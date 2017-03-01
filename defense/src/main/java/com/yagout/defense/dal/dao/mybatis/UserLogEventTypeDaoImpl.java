package com.yagout.defense.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.UserLogEventTypeDao;
import com.yagout.defense.dal.model.UserLogEventType;
import com.yagout.defense.dal.model.UserLogEventTypeExample;
import com.yagout.defense.dal.service.UserLogEventTypeMapper;

@Repository
public class UserLogEventTypeDaoImpl implements UserLogEventTypeDao {

	@Autowired private UserLogEventTypeMapper userLogEventTypeMapper;
	
	@Override
	public boolean insertUserLogEventType(UserLogEventType userLogEventType) {
		boolean isInserted=false;
        int n = this.userLogEventTypeMapper.insert(userLogEventType);
        if(n>0)
        {
        	isInserted=true;
        }
		return isInserted;
	}

	@Override
	public List<UserLogEventType> getTypeByExample(UserLogEventTypeExample example) {
		return this.userLogEventTypeMapper.selectByExample(example);
	}
}
