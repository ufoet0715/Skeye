package com.skeye.yagout.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.YagoutAccountBiz;
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
@RequestMapping("/account")
public class AccountController {
    @Autowired private YagoutAccountBiz yagoutAccountBiz;
    
    @RequestMapping("/accountList")
    public String getAccountList()
    {
    	return "account/accountList";
    }
    
    @RequestMapping("/accountListData")
    public ModelAndView getAccountListByPage(CommonPage commonPage)
    {
    	ModelAndView view=new ModelAndView("account/accountListData");
    	this.yagoutAccountBiz.queryAccountByPage(commonPage);
    	view.addObject("commonPage", commonPage);
        if(commonPage.containParam("accountType")){
            view.setViewName("analysis/accountListData");
        }
		return view;
    }



    @RequestMapping("/searchAutoComplete")
    @ResponseBody
    public String searchAutoComplete(@RequestBody  CommonPage commonPage)
    {
        CommonResult commonResult = this.yagoutAccountBiz.queryAccountByList(commonPage.getParam("accountName") ,commonPage.getParam("adslAccount") , commonPage.getRows());
        return JSONObject.toJSONString(commonResult);
    }

    
    @RequestMapping("/deleteAccountList")
    @RequiresRoles("1")
    @ResponseBody
    public String deleteAccountListByList(@RequestBody List<Integer> ids)
    {
        CommonResult commonResult = this.yagoutAccountBiz.deleteAccountByList(ids);
        return JSONObject.toJSONString(commonResult);
    }
}
