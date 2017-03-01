package com.yagout.defense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.UserLogAndTypeBiz;
import com.yagout.defense.biz.UserLogEventTypeBiz;
import com.yagout.defense.dal.model.UserLogEventType;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.DictionaryEnums;

@Controller
@RequestMapping("/userLogAndTypeController")
public class UserLogAndTypeController {
	
	@Autowired private UserLogEventTypeBiz userLogEventTypeBiz;
	
    @Autowired private UserLogAndTypeBiz userLogAndTypeBiz;
    
    @Autowired private DictionaryBiz dictionaryBiz;
    
    @RequestMapping("/toPage")
    public ModelAndView toPage(){
    	ModelAndView view=new ModelAndView("log/logList");
    	List<UserLogEventType> typeList = this.userLogEventTypeBiz.getUserLogEventType();
    	view.addObject("eventResult", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.EVENT_RESULT.getCode())));
    	view.addObject("eventResultNum", JSONObject.toJSONString(DictionaryEnums.EVENT_RESULT.getCode()));
    	view.addObject("typeList", typeList);
    	return view;
    }
    
    @RequestMapping("/getList")
    @ResponseBody
    public String getUserLogAndTypeBizByPage(CommonPage commonPage){
    	this.userLogAndTypeBiz.getUserLogAndTypeByPage(commonPage);
		return commonPage.toShowPage();
    }
}
