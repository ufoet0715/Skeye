package com.xqls.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.RoleDao;
import com.xqls.dal.model.Role;
import com.xqls.dal.model.RoleExample;
import com.xqls.dal.service.RoleMapper;

@Repository 
public class RoleDaoImpl implements RoleDao{
    @Autowired private RoleMapper roleMapper;

	@Override
	public List<Role> getListByExample(RoleExample example) {
		return this.roleMapper.selectByExample(example);
	}
}
