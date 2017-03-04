package com.xqls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xqls.biz.PermissionBiz;
import com.xqls.biz.RoleBiz;
import com.xqls.biz.RolePermissionDetailBiz;
import com.xqls.util.CommonPage;

@Controller
@RequestMapping("/rolePermissionDetailController")
public class RolePermissionDetailController {

	@Autowired private RoleBiz roleBiz;
	
	@Autowired private PermissionBiz permissionBiz;
	
	@Autowired private RolePermissionDetailBiz rolePermissionDetailBiz;
	
	@RequestMapping("/toPage")
	public ModelAndView toPage(){
		ModelAndView view=new ModelAndView("/rolePermission/rolePermissionList");
		view.addObject("roleList", this.roleBiz.getList());
		view.addObject("permissionList", this.permissionBiz.getList());
		return view;
	}
	
	@RequestMapping("/toEditPage")
	public ModelAndView toEditPage()
	{
		ModelAndView view=new ModelAndView("/rolePermission/rolePermissionEdit");
		view.addObject("permissionList", this.permissionBiz.getList());
		return view;
	}
	
	@RequestMapping("/getList")
	public ModelAndView getList(CommonPage commonPage) {
		ModelAndView view=new ModelAndView("/rolePermission/rolePermissionListData");
		this.rolePermissionDetailBiz.getListByPage(commonPage);
		view.addObject("commonPage", commonPage);
		return view;
	}
}
