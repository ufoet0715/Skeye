package com.yagout.defense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.exceptionMacBiz;
import com.yagout.defense.service.ApService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.DictionaryEnums;

@Controller
@RequestMapping("/exception")
public class exceptionMacController {
	@Value("${defaultPwd}")
	@Autowired
	private String defaultPwd;
	@Autowired private exceptionMacBiz macBiz;
	@Autowired private ApService apService;
	@Autowired private DictionaryBiz dictionaryBiz;
	
		@RequestMapping("/exceptionList")
	    public ModelAndView userList() {
			ModelAndView view = new ModelAndView("exception/exceptionList");
			view.addObject("excpState", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.EXCP_STATE.getCode())));
			view.addObject("excpStateNum", JSONObject.toJSONString(DictionaryEnums.EXCP_STATE.getCode()));
	        return view;
	    }
		
		@RequestMapping(value="/exceptionListData")
		@ResponseBody
	    public String scan_apListData(CommonPage commonPage) {
			macBiz.queryByMap(commonPage);
			return commonPage.toShowPage();
			
	    }
		
		@RequestMapping(value="/exceptionEdit")
		@ResponseBody
		public String  delete(String mac){
			CommonResult result=macBiz.delete(mac);
		
			return JSONObject.toJSONString(result);
		}
		
		@RequestMapping(value = "/{url}/edit")
		public ModelAndView editFrom(@RequestParam(value = "mac")String mac,@PathVariable(value = "url")String url){
			ModelAndView view = new ModelAndView("exception/exceptionEdit");
			view.addObject("dataBean", apService.query(mac, "exception_mac"));
			view.addObject("urlName", url);
			view.addObject("oper", "'edit'");
			return view;
		}
		
		
}
