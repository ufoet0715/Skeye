package com.xqls.dal.dao;

import java.util.List;

import com.xqls.dal.model.Permission;
import com.xqls.dal.model.PermissionExample;

public interface PermissionDao {
    List<Permission> getListByExample(PermissionExample example);
}
