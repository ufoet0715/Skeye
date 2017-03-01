package com.yagout.defense.controller;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.DeviceMonitorBiz;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.bean.DeviceMonitorBean;
import com.yagout.defense.dal.model.DeviceMonitor;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.DictionaryEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/demt")
public class DeviceMonitorController {
	@Autowired
	private DeviceMonitorBiz demtBiz;
	@Autowired
	DictionaryBiz dictionaryBiz;

	@RequestMapping("/list")
	@ResponseBody
	public ModelAndView List() {
		ModelAndView view = new ModelAndView("demt/list");
		List<DeviceMonitorBean> list = demtBiz.queryAllDeviceMonitor();
		view.addObject("online",
				JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.ONLINE.getCode())));
		view.addObject("onlineNum", JSONObject.toJSONString(DictionaryEnums.ONLINE.getCode()));
		view.addObject("demtList", list);

		return view;
	}

	@RequestMapping(value="/edit")
	@ResponseBody
	public ModelAndView deviceMonitorEdit(String deviceSerial) {
		ModelAndView view = new ModelAndView("demt/edit");
		DeviceMonitor demt = demtBiz.getDeviceMonitorById(deviceSerial);
			if (demt != null) {
				view.addObject("online", JSONObject
						.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.ONLINE.getCode())));
				view.addObject("onlineNum", JSONObject.toJSONString(DictionaryEnums.ONLINE.getCode()));
				view.addObject("demt", demt);
			}else{
				view.addObject("demt", null);
			}
		return view;
	}

	@RequestMapping("/save")
	@ResponseBody
	public CommonResult Save(DeviceMonitorBean demt) {
		CommonResult result = demtBiz.updateDeviceMonitor(demt);
		return result;
	}
}
