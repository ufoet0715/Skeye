package com.xqls.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.biz.RolePermissionDetailBiz;
import com.xqls.dal.model.Permission;
import com.xqls.dal.model.Role;
import com.xqls.dal.model.RolePermissionDetail;
import com.xqls.dal.model.RolePermissionOut;
import com.xqls.service.RolePermissionDetailService;
import com.xqls.util.CommonPage;

@Service
public class RolePermissionDetailBizImpl implements RolePermissionDetailBiz {

	@Autowired private RolePermissionDetailService rolePermissionDetailService;
	
	@Override
	public void getListByPage(CommonPage commonPage) {
		String parentId=null;
		String parentName=null;
		
		RolePermissionOut out=null;
		
		List<RolePermissionDetail> list =null;
		List<RolePermissionOut> outList =new ArrayList<RolePermissionOut>();
		
		try {
			list = this.rolePermissionDetailService.getListByMap(commonPage.pageToMap());
		    for (RolePermissionDetail record : list) {
				if(!record.getParentId().equals(parentId))
				{
					parentId=record.getPermId();
					parentName=record.getPermName();
				}
				else
				{
					out=new RolePermissionOut();
					out.setRowId(record.getRowId());
					out.setRoleId(record.getRoleId());
					out.setRoleName(record.getRoleName());
					out.setParentId(parentId);
					out.setParentName(parentName);
					out.setPermId(record.getPermId());
					out.setPermName(record.getPermName());
					outList.add(out);
				}
			}
		    
		    commonPage.setPageData(outList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
