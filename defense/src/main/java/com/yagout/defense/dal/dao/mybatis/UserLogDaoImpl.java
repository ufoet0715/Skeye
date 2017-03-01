package com.yagout.defense.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.UserLogDao;
import com.yagout.defense.dal.model.UserLog;
import com.yagout.defense.dal.service.UserLogMapper;

@Repository
public class UserLogDaoImpl implements UserLogDao {

	@Autowired private UserLogMapper userLogMapper;
	
	@Override
	public boolean insertUserLog(UserLog userLog) {
        boolean isInserted=false;
        int n = this.userLogMapper.insert(userLog);
        if(n>0)
        {
        	isInserted=true;
        }
		return isInserted;
	}

	@Override
	public boolean insertUserLogByList(List<UserLog> list) {
		 boolean isInserted=false;
	        if(this.userLogMapper.insertByList(list)>0)
	        {
	        	isInserted=true;
	        }
			return isInserted;
	}
}
