package com.xqls.biz;

import com.xqls.dal.model.User;

public interface UserBiz {
   
    User checkUserForLogin(String tenantNo, String password);
}
