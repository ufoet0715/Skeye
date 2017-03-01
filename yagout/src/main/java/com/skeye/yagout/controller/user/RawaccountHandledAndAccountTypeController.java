package com.skeye.yagout.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skeye.yagout.biz.YagoutRawaccountHandledAndAccountType;
import com.skeye.yagout.util.CommonPage;

@Controller
@RequestMapping("/rawaccountHandledAndAccountType")
public class RawaccountHandledAndAccountTypeController {
      private YagoutRawaccountHandledAndAccountType yagoutRawaccountHandledAndAccountType;
    
    @RequestMapping("/rawaccountHandledAndAccountTypeListByPage")
    public ModelAndView getYagoutRawaccountHandledAndAccountTypeListByPage(CommonPage commonPage)
    {
    	ModelAndView view=new ModelAndView("rawaccountHandledAndAccountType/rawaccountHandledAndAccountTypeListByPage");
    	this.yagoutRawaccountHandledAndAccountType.queryYagoutRawaccountHandledAndAccountTypeByPage(commonPage);
    	view.addObject("pageData", commonPage);
    	return view;
    }
    
}
 