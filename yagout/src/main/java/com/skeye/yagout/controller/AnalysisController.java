package com.skeye.yagout.controller;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.AnalysisBiz;
import com.skeye.yagout.biz.enumpackage.AnalysisTypeEnum;
import com.skeye.yagout.util.CommonResult;
import com.skeye.yagout.util.VelocityUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Skeyedu on 2016/11/18.
 */
@Controller
public class AnalysisController {
    private static Logger logger = Logger.getLogger(AnalysisController.class);

   @Autowired private AnalysisBiz analysisBiz;
    @RequestMapping("/analysisIndex")
    public String analysisIndex(){
        return "analysis/analysisIndex";
    }

    @RequestMapping(value = "/analysis", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String analysis(@RequestParam("type") Integer type,@RequestParam(value = "beginTime",required = false)String beginTime,@RequestParam(value = "endTime",required = false)String endTime) {
        CommonResult result=new CommonResult();
        Long bTime=null;
        Long eTime=null;
        try {
            if(StringUtils.isNotEmpty(beginTime)){
                bTime= VelocityUtil.getDateTool().toDate("yyyy-M-d H:m",beginTime).getTime()/1000;
            }
            if(StringUtils.isNotEmpty(endTime)){
                eTime= VelocityUtil.getDateTool().toDate("yyyy-M-d H:m",endTime).getTime()/1000;
            }
            if(AnalysisTypeEnum.ACCOUNT_TYPE.getCode().intValue()==type){
                result.setData(analysisBiz.accountType(bTime,eTime));
                result.setIsSuccess(true);
            }else {
                result.setData(analysisBiz.accountOther(bTime,eTime,type));
                result.setIsSuccess(true);
            }
        }catch (Exception e){
            logger.error("账户分析异常",e);
        }
        return JSONObject.toJSONString(result);
    }


}
