package com.xqls.biz;

import java.util.List;

import com.xqls.bean.RolePermissionBean;
import com.xqls.bean.RolePermissionKeyBean;
import com.xqls.util.CommonResult;

public interface RolePermissionBiz {
    CommonResult insertByList(List<RolePermissionBean> beanList);
    
    CommonResult updateRecord(RolePermissionBean rolePermissionBean);
    
    CommonResult deleteByList(List<RolePermissionKeyBean> beanList);
}
