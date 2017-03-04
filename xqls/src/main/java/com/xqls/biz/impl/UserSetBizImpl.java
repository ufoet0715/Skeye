package com.xqls.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.bean.UserRoleKeyBean;
import com.xqls.biz.UserSetBiz;
import com.xqls.dal.model.User;
import com.xqls.dal.model.UserRole;
import com.xqls.dal.model.UserRoleKey;
import com.xqls.dal.model.UserSet;
import com.xqls.service.UserRoleService;
import com.xqls.service.UserService;
import com.xqls.service.UserSetService;
import com.xqls.util.CommonPage;
import com.xqls.util.CommonResult;
import com.xqls.util.ObjectUtil;

@Service
public class UserSetBizImpl implements UserSetBiz {

	@Autowired private UserSetService userSetService;
	
    @Autowired private UserService userService;
	
	@Autowired private UserRoleService userRoleService;
	
	@Override
	public CommonResult insertUserSet(Map<String,Object> map) {
		CommonResult commonResult=new CommonResult();
		
		User user=new User();
		user.setUserId((String) map.get("userId"));
		user.setUserName((String) map.get("userName"));
		user.setPassword((String) map.get("password"));
		user.setName((String) map.get("name"));
		user.setTelephone((String) map.get("telephone"));
		user.setMsgAlertLevel((Integer) map.get("msgAlertLevel"));
		user.setTenantNo((String) map.get("tenantNo"));
		
		UserRole userRole=new UserRole();
		userRole.setRoleId((String) map.get("roleId"));
		userRole.setUserId((String) map.get("userId"));
		userRole.setTenantNo((String) map.get("tenantNo"));
		
		try {

			commonResult.setIsSuccess(this.userService.insertUser(user)&&
					this.userRoleService.insertDate(userRole));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return commonResult;
	}

	@Override
	public CommonResult updateUserSet(Map<String,Object> map) {
		CommonResult commonResult=new CommonResult();
		
		User user=new User();
		user.setUserId((String) map.get("userId"));
		user.setUserName((String) map.get("userName"));
		user.setPassword((String) map.get("password"));
		user.setName((String) map.get("name"));
		user.setTelephone((String) map.get("telephone"));
		user.setMsgAlertLevel((Integer) map.get("msgAlertLevel"));
		user.setTenantNo((String) map.get("tenantNo"));
		
		UserRole userRole=new UserRole();
		userRole.setRoleId((String) map.get("roleId"));
		userRole.setUserId((String) map.get("userId"));
		userRole.setTenantNo((String) map.get("tenantNo"));
		
		try {
			commonResult.setIsSuccess(this.userService.updateUser(user)&&
					this.userRoleService.updateData(userRole));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return commonResult;
	}

	@Override
	public CommonResult deleteUserSet(UserRoleKeyBean userRoleKeyBean) {
		CommonResult commonResult=new CommonResult();
		UserRoleKey userRoleKey=null;
		try {
			userRoleKey=(UserRoleKey) ObjectUtil.transfer(userRoleKeyBean, UserRoleKey.class);
			commonResult.setIsSuccess(this.userService.deleteUser(userRoleKeyBean.getUserId())&&
					this.userRoleService.deleteData(userRoleKey));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return commonResult;
	}

	
	@Override
	public void getListByPage(CommonPage commonPage) {
		List<UserSet> userSetList =null;
		try {
			userSetList = this.userSetService.getListByMap(commonPage.pageToMap());
			commonPage.setPageData(userSetList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
