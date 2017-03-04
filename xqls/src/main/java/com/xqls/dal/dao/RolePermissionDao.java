package com.xqls.dal.dao;

import java.util.List;

import com.xqls.dal.model.RolePermission;
import com.xqls.dal.model.RolePermissionKey;

public interface RolePermissionDao {
	boolean insertByList(List<RolePermission> list);
    
    boolean updateRecord(RolePermission rolePermission);
    
    boolean deleteByList(List<RolePermissionKey> list);
}
