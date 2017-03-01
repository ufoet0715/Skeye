package com.skeye.yagout.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.AnalysisBiz;
import com.skeye.yagout.biz.YagoutRawaccountHandledBiz;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rawaccountHandled")
public class RawaccountHandledController {
    @Autowired
    private YagoutRawaccountHandledBiz yagoutRawaccountHandledBiz;
    @Autowired
    private AnalysisBiz analysisBiz;
    private static Logger logger = Logger.getLogger(RawaccountHandledController.class);
    @RequestMapping("/rawaccountHandledSelect")
    public String rawaccountHandledSelect() {
        return "rawaccountHandled/rawaccountHandledSelect";
    }

    @RequestMapping("/rawaccountHandledList")
    public String getRawaccountHandledList() {
        return "rawaccountHandled/rawaccountHandledList";
    }

    @RequestMapping("/rawaccountHandledListData")
    public ModelAndView getRawaccountHandledListByPage(CommonPage commonPage) {
        ModelAndView view = new ModelAndView("rawaccountHandled/rawaccountHandledListData");
        this.yagoutRawaccountHandledBiz.queryRawaccountHandledByPage(commonPage);
        if(commonPage.containParam("popUp")){
            view.addObject("popUp", true);
        }
        view.addObject("commonPage", commonPage);
        return view;
    }

    @RequestMapping("/deleteRawaccountHandledList")
    @RequiresRoles("1")
    @ResponseBody
    public String deleteRawaccountHandledByList(@RequestBody List<Integer> ids) {
        CommonResult commonResult = this.yagoutRawaccountHandledBiz.deleteRawaccountHandledByList(ids);
        return JSONObject.toJSONString(commonResult);
    }

    @RequestMapping("/searchAutoComplete")
    @ResponseBody
    public String searchAutoComplete(@RequestBody CommonPage commonPage) {
        CommonResult commonResult = this.yagoutRawaccountHandledBiz.queryAccountByGroup(commonPage.getParam("accountName"), commonPage.getParam("adslAccount"), commonPage.getRows());
        return JSONObject.toJSONString(commonResult);
    }

    @RequestMapping("/rawaccountHistogram")
    public String rawaccountHistogram() {
        return "rawaccountHandled/rawaccountHistogram";
    }

    @RequestMapping("/rawaccountHistogramData")
    @ResponseBody
    public String rawaccountHistogramData(  @RequestParam(value = "timeFmort", required = false) String timeFmort,@RequestParam(value = "accountName", required = false) String accountName, @RequestParam(value = "adslAccount", required = false) String adslAccount, @RequestParam(value = "beginTime", required = false) String beginTime, @RequestParam(value = "endTime", required = false) String endTime) {
        CommonResult result = new CommonResult();
        try {
        if(timeFmort==null){
            timeFmort="%Y-%m-%d";
        }
        result.setData(analysisBiz.timeAnalysis(beginTime, endTime, accountName, adslAccount, timeFmort));
        result.setIsSuccess(true);
        }catch (Exception e){
            logger.error("柱状图查询异常",e);
        }
        return JSONObject.toJSONString(result);
    }


}
