package com.xqls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import com.xqls.bean.RolePermissionBean;
import com.xqls.bean.RolePermissionKeyBean;
import com.xqls.bean.RolePermissionKeyBeanList;
import com.xqls.biz.RolePermissionBiz;
import com.xqls.util.CommonResult;

@Controller
@RequestMapping("/rolePermissionController")
public class RolePermissionController {
	@Autowired private RolePermissionBiz rolePermissionBiz;

	@RequestMapping("/toPage")
	public String toPage() {
		return "/permission/permissionPage";
	}
	
	@RequestMapping("/insertList")
	@ResponseBody
	public String insertRecord(@RequestBody List<RolePermissionBean> beanList){
		CommonResult commonResult = this.rolePermissionBiz.insertByList(beanList);
		return JSONObject.toJSONString(commonResult);
	}

	@RequestMapping("/updatePermission")
	@ResponseBody
	public String updateRecord(RolePermissionBean rolePermissionBean) {
		CommonResult commonResult = this.rolePermissionBiz.updateRecord(rolePermissionBean);
		return JSONObject.toJSONString(commonResult);
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public String deleteList(@RequestBody List<RolePermissionKeyBean> beanList) {
		CommonResult commonResult = this.rolePermissionBiz.deleteByList(beanList);
		return JSONObject.toJSONString(commonResult);
	}
	
}
