package com.skeye.water_fountain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skeye.water_fountain.biz.DeviceStateBiz;
import com.skeye.water_fountain.biz.bean.DeviceStateBean;
import com.skeye.water_fountain.util.CommonPage;
import com.skeye.water_fountain.util.CommonResult;

@Controller
@RequestMapping("/deviceStateController")
public class DeviceStateController {
	@Autowired private DeviceStateBiz deviceStateBiz;
	
	@RequestMapping("/insertDeviceState")
	public String toInsertState()
	{
		return "/views/deviceState/insertDeviceState";
	}
	
	@RequestMapping("/insertDeviceStateData")
	public ModelAndView insertDeviceState(DeviceStateBean deviceStateBean)
	{
		ModelAndView view=new ModelAndView();
		CommonResult commonResult = this.deviceStateBiz.saveDeviceState(deviceStateBean);
		if(commonResult.getIsSuccess())
		{
			view.setViewName("redirect:/deviceStateController/insertDeviceState");
		}
		else
		{
			view.setViewName("redirect:/deviceController/toInsertDevice");
		}
		view.addObject("commonResult", commonResult);
		return view;
	}
	
	@RequestMapping("/getDeviceStateListData")
	public ModelAndView getDeviceStateList(CommonPage commonPage)
	{
		ModelAndView view=new ModelAndView();
		this.deviceStateBiz.getDeviceStateList(commonPage);
		view.setViewName("/views/deviceState/deviceStateListData");
		view.addObject("commonPage", commonPage);
		return view;
	}
}
