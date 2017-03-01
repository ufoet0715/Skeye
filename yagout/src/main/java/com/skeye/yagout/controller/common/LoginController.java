package com.skeye.yagout.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.bean.YagoutUsersBean;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.util.CommonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired  private LogService logService;
	@RequestMapping("/login")
	public ModelAndView login(){
		  Subject subject = SecurityUtils.getSubject();
        ModelAndView view = new ModelAndView();
		  if(subject.isAuthenticated()){
              view.setViewName("redirect:/index.html");
			  return view;// "index";
		  }
        view.setViewName("login");
		  return view;// "login";
	}

    @RequestMapping("/permNo")
    public String permNo(){
        return "permNo";// "login";
    }
    @RequestMapping("/loginout")
    public ModelAndView loginout(){
        Subject subject = SecurityUtils.getSubject();
        ModelAndView view = new ModelAndView();
        String userName=(String) subject.getPrincipal();
        if(subject.isAuthenticated()){
            subject.logout();
            logService.addLog(userName,"登出",true);
        }
        view.setViewName("redirect:/login.html");
        return view;
    }
	
	@RequestMapping(value = "/toLogin", produces = "text/html; charset=utf-8")
    @ResponseBody
	public String toLogin(@Valid YagoutUsersBean user,BindingResult result){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            return  JSONObject.toJSONString(new CommonResult(true));
        }
        CommonResult loginResult=new   CommonResult();
        if (result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            loginResult.setData(errorList.get(0));
            return  JSONObject.toJSONString(loginResult);
        }
          try {
              AuthenticationToken token=new UsernamePasswordToken(user.getUserName(),user.getPassword());
              subject.login(token);
              loginResult.setIsSuccess(true);
              logService.addLog(user.getUserName(),"登录",loginResult);
          }catch (Exception e){
              logger.error("登录异常",e);
              ObjectError objectError=new ObjectError("userName",e.getMessage());
              loginResult.setData(objectError);
          }
        return  JSONObject.toJSONString(loginResult);
	}
}
