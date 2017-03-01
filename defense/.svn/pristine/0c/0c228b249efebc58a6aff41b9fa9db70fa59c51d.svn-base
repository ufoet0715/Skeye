package com.yagout.defense.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.ScanApBiz;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.DictionaryEnums;

@Controller
@RequestMapping("/ap")
public class ScanApController {
	@Autowired
	private ScanApBiz apBiz;
	@Autowired
	private DictionaryBiz dictionaryBiz;
	
	@RequestMapping("/scanApList")
    public ModelAndView userList() {
		ModelAndView view = new ModelAndView("ap/scanApList");
		view.addObject("identityNum", JSONObject.toJSONString(DictionaryEnums.IDENTITY.getCode()));
		view.addObject("privacyNum", JSONObject.toJSONString(DictionaryEnums.PRIVACY.getCode()));
		view.addObject("encryptWayNum", JSONObject.toJSONString(DictionaryEnums.ENCRYPT_WAY.getCode()));
		view.addObject("authWayNum", JSONObject.toJSONString(DictionaryEnums.AUTH_WAY.getCode()));
		view.addObject("wpsNum", JSONObject.toJSONString(DictionaryEnums.WPS.getCode()));
		view.addObject("broadcastSsidNum", JSONObject.toJSONString(DictionaryEnums.BROADCAST_SSID.getCode()));
		view.addObject("identity", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.IDENTITY.getCode())));
		view.addObject("privacy", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.PRIVACY.getCode())));
		view.addObject("encryptWay", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.ENCRYPT_WAY.getCode())));
		view.addObject("authWay", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.AUTH_WAY.getCode())));
		view.addObject("wps", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.WPS.getCode())));
		view.addObject("broadcastSsid", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.BROADCAST_SSID.getCode())));
        return view;
    }
	
	@RequestMapping("/scanApListData")
	@ResponseBody
    public String scan_apListData(CommonPage commonPage) {
		apBiz.queryApByPage(commonPage);
		return commonPage.toShowPage();
    }
	
	@RequestMapping("/listData")
	@ResponseBody
    public String listData(String id) {
		return "";
    }
	
	
	
}
