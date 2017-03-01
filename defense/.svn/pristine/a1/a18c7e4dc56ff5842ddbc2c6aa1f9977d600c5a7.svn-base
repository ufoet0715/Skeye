package com.yagout.defense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.ApAdHocBiz;
import com.yagout.defense.biz.ApNeighborBiz;
import com.yagout.defense.biz.ApTrustBiz;
import com.yagout.defense.biz.ApVisitorBiz;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.DictionaryEnums;

@Controller
@RequestMapping("/allap")
public class AllApController {
	
	
	@Autowired private ApTrustBiz apTrustBiz;
	@Autowired private ApNeighborBiz apNeighborBiz;
	@Autowired private  ApVisitorBiz apVisitroBiz;
	@Autowired private ApAdHocBiz apAdHocBiz;
	@Autowired private DictionaryBiz dictionaryBiz;
	
	@RequestMapping("/allapList")
    public ModelAndView userList() {
		ModelAndView view = new ModelAndView("ap/allapList");
		view.addObject("privacy", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.PRIVACY.getCode())));
		view.addObject("privacyNum", JSONObject.toJSONString(DictionaryEnums.PRIVACY.getCode()));
        return view;
    }

	
	@RequestMapping(value="/{value}/allapListData")
	@ResponseBody
    public String scan_apListData(CommonPage commonPage,@PathVariable(value = "value")String value) {
		if(value.equals("apNeighbor")){
			apNeighborBiz.query(commonPage);
		}else if(value.equals("apTrust")){
			apTrustBiz.query(commonPage);
		}else if(value.equals("apVisitor")){
			apVisitroBiz.query(commonPage);
		}else if(value.equals("apAdHoc")){
			apAdHocBiz.query(commonPage);
		}else{
			
		}
		return commonPage.toShowPage();
    }
}
