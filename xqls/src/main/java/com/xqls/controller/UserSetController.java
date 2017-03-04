package com.xqls.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xqls.bean.UserRoleKeyBean;
import com.xqls.biz.RoleBiz;
import com.xqls.biz.UserSetBiz;
import com.xqls.util.CommonPage;
import com.xqls.util.CommonResult;

@Controller
@RequestMapping("/userSetController")
public class UserSetController {
	
	@Autowired private RoleBiz roleBiz;

	//@Autowired private BlockBiz blockBiz;
	
	@Autowired private UserSetBiz userSetBiz;
	
	@RequestMapping("/toPage")
	public ModelAndView toPage(){
		ModelAndView view =new ModelAndView("/userSet/userSetList");
		view.addObject("roleList", this.roleBiz.getList());
		return view;
	}
	
	@RequestMapping("/insertUserSet")
    @ResponseBody
    public String insertUser(Map<String,Object> map){
    	CommonResult commonResult = this.userSetBiz.insertUserSet(map);
    	return JSONObject.toJSONString(commonResult);
    }
    
    @RequestMapping("/updateUserSet")
    @ResponseBody
    public String updateUser(Map<String,Object> map){
    	CommonResult commonResult = this.userSetBiz.updateUserSet(map);
    	return JSONObject.toJSONString(commonResult);
    }
    
    @RequestMapping("/deleteUserSet")
    @ResponseBody
    public String deleteUser(UserRoleKeyBean userRoleKeyBean){
    	CommonResult commonResult = this.userSetBiz.deleteUserSet(userRoleKeyBean);
    	return JSONObject.toJSONString(commonResult);
    }
	
	@RequestMapping("/getListSet")
	public ModelAndView getList(CommonPage commonPage){
		ModelAndView view =new ModelAndView("/userSet/userSetListData");
		this.userSetBiz.getListByPage(commonPage);
		view.addObject("commonPage", commonPage);
		return view;
	}
}
