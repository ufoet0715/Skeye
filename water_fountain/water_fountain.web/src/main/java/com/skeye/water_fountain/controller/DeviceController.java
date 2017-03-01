package com.skeye.water_fountain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.skeye.water_fountain.biz.DeviceBiz;
import com.skeye.water_fountain.biz.bean.AccountToDeviceBean;
import com.skeye.water_fountain.biz.bean.DeviceBean;
import com.skeye.water_fountain.util.CommonPage;
import com.skeye.water_fountain.util.CommonResult;

@Controller
@RequestMapping("/deviceController")
public class DeviceController {
	
	@Autowired private DeviceBiz deviceBiz;
	
	@RequestMapping("/toInsertDevice")
	public String toInsertDevice()
	{
		return "/views/device/insertDevice";
	}
	
	@RequestMapping("/deviceList")
	public String toShowDevice()
	{
		return "/views/device/deviceList";
	}
	
	@RequestMapping("/countDevice")
	public String toCountDevice()
	{
		return "/views/device/countDevice";
	}
	
	@RequestMapping("/insertDevice")
	public ModelAndView insertDevice(DeviceBean deviceBean)
	{
		ModelAndView view=new ModelAndView();
		CommonResult commonResult = this.deviceBiz.insertDevice(deviceBean);
		view.setViewName("/views/device/insertDevice");
		view.addObject("commonResult", commonResult);
		return view;
	}
	
	@RequestMapping("/getDevice")
	@ResponseBody
	public String getDevice(CommonPage commonPage)
	{
		DeviceBean deviceBean = this.deviceBiz.getDevice(commonPage);
		return JSONObject.toJSONString(deviceBean);
	}
	
	@RequestMapping("/getDeviceListByMap")
	public ModelAndView getDeviceListByMap(CommonPage commonPage)
	{
		ModelAndView view=new ModelAndView();
		this.deviceBiz.getDeviceListByMap(commonPage);
		view.setViewName("/views/device/deviceListData");
		view.addObject("commonPage", commonPage);
		return view;
	}
	
	@RequestMapping("/getCountByMap")
	@ResponseBody
	public String getCountByMap(AccountToDeviceBean accountToDeviceBean)
	{
		return JSONObject.toJSONString(this.deviceBiz.getCountByMap(accountToDeviceBean));
	}
}
