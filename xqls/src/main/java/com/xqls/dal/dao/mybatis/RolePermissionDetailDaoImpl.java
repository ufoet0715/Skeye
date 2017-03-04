package com.xqls.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.RolePermissionDetailDao;
import com.xqls.dal.model.RolePermissionDetail;
import com.xqls.dal.service.RolePermissionDetailMapper;

@Repository
public class RolePermissionDetailDaoImpl implements RolePermissionDetailDao {

	@Autowired private RolePermissionDetailMapper rolePermissionDetailMapper;

	@Override
	public List<RolePermissionDetail> getListByMap(Map<String, Object> map) {
		return this.rolePermissionDetailMapper.getListByMap(map);
	}
}
