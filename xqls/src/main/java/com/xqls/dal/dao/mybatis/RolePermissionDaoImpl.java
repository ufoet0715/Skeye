package com.xqls.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.RolePermissionDao;
import com.xqls.dal.model.RolePermission;
import com.xqls.dal.model.RolePermissionKey;
import com.xqls.dal.service.RolePermissionMapper;

@Repository
public class RolePermissionDaoImpl implements RolePermissionDao {

	@Autowired private RolePermissionMapper rolePermissionMapper;
	
	@Override
	public boolean insertByList(List<RolePermission> list) {
		boolean isResult=false;
		if(this.rolePermissionMapper.insertByList(list)>0)
		{
			isResult=true;
		}
		return isResult;
	}
	
	@Override
	public boolean updateRecord(RolePermission rolePermission) {
		boolean isResult=false;
		if(this.rolePermissionMapper.updateByPrimaryKey(rolePermission)>0)
		{
			isResult=true;
		}
		return isResult;
	}
	
	@Override
	public boolean deleteByList(List<RolePermissionKey> list) {
		boolean isResult=false;
		if(this.rolePermissionMapper.deleteByList(list)>0)
		{
			isResult=true;
		}
		return isResult;
	}
}
