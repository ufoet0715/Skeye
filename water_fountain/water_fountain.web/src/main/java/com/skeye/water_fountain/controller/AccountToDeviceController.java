package com.skeye.water_fountain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skeye.water_fountain.biz.AccountToDeviceBiz;
import com.skeye.water_fountain.util.CommonPage;

@Controller
@RequestMapping("/accountToDeviceController")
public class AccountToDeviceController {
    @Autowired private AccountToDeviceBiz accountToDeviceBiz;
	
    @RequestMapping("/getAccountList")
    public String getAccountList()
    {
    	return "/views/accountToDevice/accountList";
    }
    
    @RequestMapping("/getDeviceList")
    public String getDeviceList()
    {
    	return "/views/accountToDevice/deviceList";
    }
    
	@RequestMapping("/getAccountListByMap")
	public ModelAndView getAccountListByMap(CommonPage commonPage)
	{
		ModelAndView view=new ModelAndView();
		this.accountToDeviceBiz.getAccountListByMap(commonPage);
		view.setViewName("/views/accountToDevice/accountListData");
		view.addObject("commonPage", commonPage);
		return view;
	}
	
	@RequestMapping("/getDeviceListByMap")
	public ModelAndView getDeviceListByMap(CommonPage commonPage)
	{
		ModelAndView view=new ModelAndView();
		this.accountToDeviceBiz.getDeviceListByMap(commonPage);
		view.setViewName("/views/accountToDevice/deviceListData");
		view.addObject("commonPage", commonPage);
		return view;
	}
}
