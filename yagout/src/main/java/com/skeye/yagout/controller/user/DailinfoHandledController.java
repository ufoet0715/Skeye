package com.skeye.yagout.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.YagoutDailinfoHandledBiz;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("dailinfoHandled")
public class DailinfoHandledController {
    @Autowired private YagoutDailinfoHandledBiz yagoutDailinfoHandledBiz;


    @RequestMapping("/dailinfoHandledList")
    public String getDailinfoHandledList()
    {
    	return "dailinfoHandled/dailinfoHandledList";
    }
    
    @RequestMapping("/dailinfoHandledListData")
    public ModelAndView getDailinfoHandledListData(CommonPage commonPage)
    {
    	ModelAndView view=new ModelAndView("dailinfoHandled/dailinfoHandledListData");
    	this.yagoutDailinfoHandledBiz.queryDailinfoHandledByPage(commonPage);
    	view.addObject("commonPage", commonPage);
    	return view;
    }
    
    @RequestMapping("/deleteDailinfoHandledList")
    @RequiresRoles("1")
    @ResponseBody
    public String deleteDailinfoHandledByList(@RequestBody List<Integer> ids)
    {
        CommonResult commonResult = yagoutDailinfoHandledBiz.deleteDailinfoHandledByList(ids);
        return JSONObject.toJSONString(commonResult);
    }
}
