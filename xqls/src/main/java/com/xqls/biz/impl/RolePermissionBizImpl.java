package com.xqls.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.bean.RolePermissionBean;
import com.xqls.bean.RolePermissionKeyBean;
import com.xqls.biz.RolePermissionBiz;
import com.xqls.dal.dao.RolePermissionDao;
import com.xqls.dal.model.RolePermission;
import com.xqls.dal.model.RolePermissionKey;
import com.xqls.util.CommonResult;
import com.xqls.util.ObjectUtil;

@Service
public class RolePermissionBizImpl implements RolePermissionBiz {

	@Autowired private RolePermissionDao rolePermissionDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public CommonResult insertByList(List<RolePermissionBean> beanList) {
		CommonResult commonResult=new CommonResult();
		List<RolePermission> list=null;
		try {
			list= ObjectUtil.transferList(beanList, RolePermission.class);
			commonResult.setIsSuccess(this.rolePermissionDao.insertByList(list));
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return commonResult;
	}

	@Override
	public CommonResult updateRecord(RolePermissionBean rolePermissionBean) {
		CommonResult commonResult=new CommonResult();
		RolePermission rolePermission=null;
		try {
			rolePermission=(RolePermission) ObjectUtil.transfer(rolePermissionBean, RolePermission.class);
			commonResult.setIsSuccess(this.rolePermissionDao.updateRecord(rolePermission));
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return commonResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CommonResult deleteByList(List<RolePermissionKeyBean> beanList) {
		CommonResult commonResult=new CommonResult();
		List<RolePermissionKey> list=null;
		try {
			list=ObjectUtil.transferList(beanList, RolePermissionKey.class);
			commonResult.setIsSuccess(this.rolePermissionDao.deleteByList(list));
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return commonResult;
	}

}
