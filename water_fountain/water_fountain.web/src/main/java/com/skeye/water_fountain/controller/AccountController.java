package com.skeye.water_fountain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.skeye.water_fountain.biz.AccountBiz;
import com.skeye.water_fountain.biz.bean.AccountBean;
import com.skeye.water_fountain.util.CommonResult;

@Controller
@RequestMapping("/accountController")
public class AccountController {
	@Autowired private AccountBiz accountBiz;
	
	@RequestMapping("/registAccount")
	public String regist()
	{
		return "/views/account/regist";
	}
	
	@RequestMapping("/loginAccount")
	public String login()
	{
		return "/views/account/login";
	}

	@RequestMapping("/insertAccount")
    public ModelAndView insertAccount(AccountBean accountBean)
    {
		ModelAndView view=new ModelAndView();
		CommonResult commonResult=accountBiz.insertAccount(accountBean);
		if(commonResult.getIsSuccess())
		{
			view.setViewName("redirect:/accountController/loginAccount");
		}
		view.addObject("commonResult", commonResult);
		return view;
    }
	
	@RequestMapping("/checkAccount")
	@ResponseBody
	public String checkAccount(String accountNo,String password)
	{
		CommonResult commonResult = this.accountBiz.getAccount(accountNo, password);
		return JSONObject.toJSONString(commonResult);
	}
	
	@RequestMapping("/getAccount")
	public ModelAndView getAccount(String accountNo,String password) {
		ModelAndView view=new ModelAndView();
		CommonResult commonResult = this.accountBiz.getAccount(accountNo, password);
		if(commonResult.getIsSuccess())
		{
			view.setViewName("redirect:/mainController/toFront");
		}
		else
		{
			view.setViewName("redirect:/accountController/registAccount");
		}
		view.addObject("commonResult", commonResult);
		return view;
	}	
}
