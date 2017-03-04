package com.xqls.service;

import com.xqls.dal.model.UserRole;
import com.xqls.dal.model.UserRoleKey;

public interface UserRoleService {
    boolean insertDate(UserRole useRole);
    
    boolean updateData(UserRole userRole);
    
    boolean deleteData(UserRoleKey userRoleKey);
}
