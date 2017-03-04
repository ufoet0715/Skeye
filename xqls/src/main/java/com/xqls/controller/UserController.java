package com.xqls.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xqls.biz.UserBiz;
import com.xqls.dal.model.User;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired private UserBiz userBiz;
    
    @RequestMapping("checkUser/{tenantNo}/{password}")
    public ModelAndView checkLogin(@PathVariable String tenantNo,@PathVariable String password){
        ModelAndView view =new ModelAndView();
    	User user = this.userBiz.checkUserForLogin(tenantNo, password);
    	Subject subject=SecurityUtils.getSubject();
    	if(user!=null)
    	{
    	    if(!subject.isAuthenticated())
    	    {
    	    	AuthenticationToken token=new UsernamePasswordToken(tenantNo, password);
    	    	subject.login(token);
    	    }
    		view.setViewName("/index");
    	}
    	else
    	{
    		view.setViewName("/login");
    		view.addObject("isLogin", false);
    	}
    	return view;
    }
}
