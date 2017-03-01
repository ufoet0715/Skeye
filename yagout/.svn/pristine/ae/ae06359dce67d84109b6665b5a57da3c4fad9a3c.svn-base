package com.skeye.yagout.controller;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.YagoutUsersBiz;
import com.skeye.yagout.biz.bean.YagoutUsersBean;
import com.skeye.yagout.util.CommonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Skeyedu on 2016/11/16.
 */
@Controller
public class IndexController {
    @Autowired
    private YagoutUsersBiz yagoutUsersBiz;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        return view;// "login";
    }


    @RequestMapping(value = "/checkUserName", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String checkUserName(@RequestParam("userName") String userName) {
        return JSONObject.toJSONString(yagoutUsersBiz.checkUserName(userName));
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




    @RequestMapping(value = "/updatePwd", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String updatePwd(YagoutUsersBean usersBean ) {
        Subject subject = SecurityUtils.getSubject();
        CommonResult result=yagoutUsersBiz.updateUser((String)subject.getPrincipal(),null,usersBean.getPassword(),usersBean.getNewPassword());
        return JSONObject.toJSONString(result);
    }

}
