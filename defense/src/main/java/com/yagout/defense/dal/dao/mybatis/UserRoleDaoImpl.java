package com.yagout.defense.dal.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.UserRoleDao;
import com.yagout.defense.dal.model.UserRoleExample;
import com.yagout.defense.dal.model.UserRoleKey;
import com.yagout.defense.dal.service.UserRoleMapper;

@Repository
public class UserRoleDaoImpl implements UserRoleDao{

	@Autowired private UserRoleMapper userRoleMapper;
	
	public boolean insertUserRole(Integer userId,Integer roleId){
		UserRoleKey key = new UserRoleKey();
		key.setUserId(userId);
		key.setRoleId(roleId);
		int result =  userRoleMapper.insertSelective(key);
		return result>0;
	}
	
	public boolean updateRole(Integer userId,Integer roleId){
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		UserRoleKey key = new UserRoleKey();
		key.setRoleId(roleId);
		return userRoleMapper.updateByExampleSelective(key, example)>0;
	}
}
