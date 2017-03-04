package com.xqls.service;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.RolePermissionDetail;

public interface RolePermissionDetailService {
	List<RolePermissionDetail> getListByMap(Map<String,Object> map);
}
