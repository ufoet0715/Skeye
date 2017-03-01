package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.UserLogAndTypeDao;
import com.yagout.defense.dal.model.UserLogAndType;
import com.yagout.defense.dal.service.UserLogAndTypeMapper;

@Repository
public class UserLogAndTypeDaoImpl implements UserLogAndTypeDao {

	@Autowired private UserLogAndTypeMapper userLogAndTypeMapper;
	
	@Override
	public List<UserLogAndType> getByMap(Map<String, Object> map) {
		return this.userLogAndTypeMapper.getByMap(map);
	}
}
