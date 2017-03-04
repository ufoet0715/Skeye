package com.xqls.dal.dao;

import com.xqls.dal.model.UserRole;
import com.xqls.dal.model.UserRoleKey;

public interface UserRoleDao {
    boolean insertDate(UserRole useRole);
    
    boolean updateData(UserRole userRole);
    
    boolean deleteData(UserRoleKey userRoleKey);
}
