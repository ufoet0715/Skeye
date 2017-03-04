package com.xqls.biz;

import com.xqls.bean.RolePermissionDetailBean;
import com.xqls.bean.RolePermissionKeyBean;
import com.xqls.util.CommonPage;

public interface RolePermissionDetailBiz {
	void getListByPage(CommonPage commonPage);
	
	RolePermissionDetailBean getBeanByKey(RolePermissionKeyBean beanKey);
}
