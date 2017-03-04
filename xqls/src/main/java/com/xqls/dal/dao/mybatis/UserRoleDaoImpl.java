package com.xqls.dal.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.UserRoleDao;
import com.xqls.dal.model.UserRole;
import com.xqls.dal.model.UserRoleKey;
import com.xqls.dal.service.UserRoleMapper;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired private UserRoleMapper userRoleMapper; 
	
	@Override
	public boolean insertDate(UserRole useRole) {
		boolean result=false;
		if(this.userRoleMapper.insert(useRole)>0)
		{
			result=true;
		}
		return result;
	}

	@Override
	public boolean updateData(UserRole userRole) {
		boolean result=false;
		if(this.userRoleMapper.updateByPrimaryKey(userRole)>0)
		{
			result=true;
		}
		return result;
	}

	@Override
	public boolean deleteData(UserRoleKey userRoleKey) {
		boolean result=false;
		if(this.userRoleMapper.deleteByPrimaryKey(userRoleKey)>0)
		{
			result=true;
		}
		return result;
	}

}
