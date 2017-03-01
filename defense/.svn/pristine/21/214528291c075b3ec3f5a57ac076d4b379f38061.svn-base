package com.yagout.defense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.LoginCheckBiz;
import com.yagout.defense.biz.bean.LoginCheckBean;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;

/**
 * @author SCJ
 * 账户登录错误统计
 */
@Controller
@RequestMapping("/loginCheckController")
public class LoginCheckController {
    @Autowired private LoginCheckBiz loginCheckBiz;
    
    @RequestMapping("/toLoginCheckPage")
    public String toPage(){
    	return "login/loginCheckList";
    }

    @RequestMapping("/updateLoginCheck")
    @ResponseBody
    public String updateLoginCheck(@RequestParam LoginCheckBean recordBean){
    	CommonResult commonResult = this.loginCheckBiz.updateData(recordBean);
    	return JSONObject.toJSONString(commonResult);
    }
    
    @RequestMapping("/getLoginCheckListByMap")
    @ResponseBody
    public String getLoginCheckListByMap(CommonPage commonPage){
    	this.loginCheckBiz.getLoginCheckByMap(commonPage);
    	return commonPage.toShowPage();
    }
}
