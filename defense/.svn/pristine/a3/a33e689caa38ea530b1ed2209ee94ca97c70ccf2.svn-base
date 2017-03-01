package com.yagout.defense.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.UserBiz;
import com.yagout.defense.biz.bean.UserBean;
import com.yagout.defense.service.LoginService;
import com.yagout.defense.util.CommonResult;

/**
 * Created by Skeyedu on 2016/11/16.
 */
@Controller
public class IndexController {
    @Autowired
    private UserBiz userBiz;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userName", subject.getPrincipal());
            view.addObject("userName", subject.getPrincipal());
            view.addObject("loginList", loginService.getLoginByMap(map));
        }else {
            view.setViewName("redirect:/login");
        }

        return view;// "login";
    }


    @RequestMapping(value = "/checkUserName", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String checkUserName(@RequestParam("userName") String userName) {
        return JSONObject.toJSONString(userBiz.checkUserName(userName));
    }
    @RequestMapping(value = "/changePassword", produces = "text/html; charset=utf-8")
    public String changePassword() {
        return "changePassword";
    }

    @RequestMapping(value = "/setings", produces = "text/html; charset=utf-8")
    public String setings() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("1")){
            return "setingsSelect";
        }else {
           return "changePassword";
        }
    }

    @RequestMapping(value = "/building", produces = "text/html; charset=utf-8")
    public String building() {
        return "error/404";
    }

    @RequestMapping(value = "/error", produces = "text/html; charset=utf-8")
    public String error() {
        return "error/500";
    }




    @RequestMapping(value = "/updatePwd")
    @ResponseBody
    public CommonResult updatePwd(UserBean usersBean ) {
        Subject subject = SecurityUtils.getSubject();
        return  userBiz.updateUser((String)subject.getPrincipal(),null,usersBean.getUserPwd(),usersBean.getNewPassword());
    }


    @RequestMapping(value = "/update", produces = "text/html; charset=utf-8")
    public String update() {
        return "update/update";
    }


    @RequestMapping(value = "/doUpdate", produces = "text/html; charset=utf-8")
    public String doUpdate() {


        return "update/update";
    }


}
