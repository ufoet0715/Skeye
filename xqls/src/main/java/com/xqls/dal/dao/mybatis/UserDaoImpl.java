package com.xqls.dal.dao.mybatis;

import com.xqls.dal.dao.UserDao;
import com.xqls.dal.model.User;
import com.xqls.dal.model.UserExample;
import com.xqls.dal.service.UserMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired private UserMapper userMapper;

	@Override
	public boolean insertUser(User user) {
		boolean result=false;
		if(this.userMapper.insert(user)>0)
		{
			result=true;
		}
		return result;
	}

	@Override
	public boolean updateUser(User user) {
		boolean result=false;
		if(this.userMapper.updateByPrimaryKey(user)>0)
		{
			result=true;
		}
		return result;
	}

	@Override
	public boolean deleteUser(String userId) {
		boolean result=false;
		if(this.userMapper.deleteByPrimaryKey(userId)>0)
		{
			result=true;
		}
		return result;
	}

	@Override
	public List<User> getListByExample(UserExample example) {
		return this.userMapper.selectByExample(example);
	}

}
