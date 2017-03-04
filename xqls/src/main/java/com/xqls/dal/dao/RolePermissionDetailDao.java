package com.xqls.dal.dao;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.RolePermissionDetail;

public interface RolePermissionDetailDao {
	List<RolePermissionDetail> getListByMap(Map<String,Object> map);
}
