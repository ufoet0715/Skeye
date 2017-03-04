package com.xqls.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.bean.RolePermissionDetailBean;
import com.xqls.bean.RolePermissionKeyBean;
import com.xqls.biz.RolePermissionDetailBiz;
import com.xqls.dal.model.RolePermissionDetail;
import com.xqls.service.RolePermissionDetailService;
import com.xqls.util.CommonPage;
import com.xqls.util.ObjectUtil;

@Service
public class RolePermissionDetailBizImpl implements RolePermissionDetailBiz {

	@Autowired private RolePermissionDetailService rolePermissionDetailService;
	
	@Override
	public void getListByPage(CommonPage commonPage) {
		List<RolePermissionDetail> list =null;
	
		try {
			list = this.rolePermissionDetailService.getListByMap(commonPage.pageToMap());
		    commonPage.setPageData(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public RolePermissionDetailBean getBeanByKey(RolePermissionKeyBean beanKey) {
		
		RolePermissionDetail detail=null;
		RolePermissionDetailBean bean=null;
		List<RolePermissionDetail> list =null;
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("roleId", beanKey.getRoleId());
		map.put("permId", beanKey.getPermId());
		
		try {
			list = this.rolePermissionDetailService.getListByMap(map);
			if(!list.isEmpty())
			{
				detail=list.get(0);
				bean=(RolePermissionDetailBean) ObjectUtil.transfer(detail, RolePermissionDetailBean.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
}
