package com.xqls.dal.dao;

import java.util.List;

import com.xqls.dal.model.Role;
import com.xqls.dal.model.RoleExample;

public interface RoleDao {
    List<Role> getListByExample(RoleExample example);
}
