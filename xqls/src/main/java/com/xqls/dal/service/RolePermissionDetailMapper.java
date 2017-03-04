package com.xqls.dal.service;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.RolePermissionDetail;

public interface RolePermissionDetailMapper {
    List<RolePermissionDetail> getListByMap(Map<String,Object> map);
}
