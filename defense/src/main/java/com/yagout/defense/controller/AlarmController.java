package com.yagout.defense.controller;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.AlarmBiz;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.dal.model.StrategyKey;
import com.yagout.defense.service.UserLogService;
import com.yagout.defense.util.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/alarm")
public class AlarmController {
    private static Logger logger = Logger.getLogger(AlarmController.class);
    @Autowired
    private AlarmBiz alarmBiz;
    @Autowired
    private DictionaryBiz dictionaryBiz;
    
    @Autowired private UserLogService userLogService;

    @RequestMapping("/alarmList")
    public ModelAndView alarmList() {
    	ModelAndView view = new ModelAndView("alarm/alarmList");
    	int num = DictionaryEnums.INVADE_FLAG.getCode();
    	Map<Integer, String> invade = dictionaryBiz.queryDictionaryByParent(num);
    	view.addObject("invadeFlag",JSONObject.toJSONString(invade));
    	view.addObject("invadeNum", JSONObject.toJSONString(DictionaryEnums.INVADE_FLAG.getCode()));
        return view;
    }

    /*
     * 获得所有事件
     */
    @RequestMapping("/alarmListData")
    @ResponseBody
    public String alarmListData(CommonPage commonPage) {
    	alarmBiz.queryAlarmsByPage(commonPage);
        return commonPage.toShowPage();
    }

    /*
     * 获得当前事件所属策略
     */
    @RequestMapping("/strategyListData")
    @ResponseBody
    public String queryStrategyByAlarm(@RequestParam Integer id) {
    	List<Map<String,Object>> strategies=alarmBiz.queryStrategiesByAlarm(id);
        if (strategies!=null&&strategies.size()>0)
        return JSONObject.toJSONString(strategies);
        return null;
    }
    
    /*
     * 获得当前事件所有策略
     */
    @RequestMapping("/strategyDefaultListData")
    @ResponseBody
    public String queryDefaultStrategyByAlarm(@RequestParam Integer id) {
    	List<Map<String,Object>> defaultStrategies=alarmBiz.queryDefaultStrategiesByAlarm(id);
    	return JSONObject.toJSONString(defaultStrategies);
    }
    
    /*
     * 改变事件激活状态
     */
    @RequestMapping(value = "/alarmChangeState", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String alarmChangeState(@RequestParam Boolean flag,@RequestParam Integer id) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	if(flag){
    		map.put("invadeFlag",0);
    	}else{
    		map.put("invadeFlag",1);
    	}
    	map.put("invadeId",id);
        CommonResult result=alarmBiz.updateFlagById(map);
        return JSONObject.toJSONString(result);
    }
    
    /*
     * 策略的批量删除
     */
    @RequestMapping("/strategyDelete")
    @ResponseBody
    public String deleteStrategies(@RequestBody List<Integer> ids) {
        CommonResult result=alarmBiz.deleteStrategies(ids);
        return JSONObject.toJSONString(result);
    }
    
    /*
     * 策略的批量新增
     */
    @RequestMapping(value = "/strategyAdd", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String addStrategy(@RequestBody List<StrategyKey> strategies) {
        CommonResult result=alarmBiz.insertStrategy(strategies);
        return JSONObject.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping("/toShowStrategy")
    public Map<String,List<Map<String,Object>>> toShowStrategy(Integer invadeId){
    	List<Map<String,Object>> strategies=alarmBiz.queryStrategiesByAlarm(invadeId);
    	List<Map<String,Object>> defaultStrategies=alarmBiz.queryDefaultStrategiesByAlarm(invadeId);
    	    	
    	Map<String,List<Map<String,Object>>> objs=new HashMap<String,List<Map<String,Object>>>();
    	objs.put("strs",strategies);
    	objs.put("defs",defaultStrategies);
    	return objs;
    }
    
    @ResponseBody
    @RequestMapping(value = "/strategyUpdate")
    public CommonResult updateStrategy(@RequestBody Map<String,Object> map){
         return alarmBiz.updateStrategy(map);
    }



    @RequestMapping("/alarmReport")
    public ModelAndView alarmReport()throws Exception {
        ModelAndView   view=new  ModelAndView("alarm/alarmReport");
        alarmBiz.report(view);
        return view;

    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) {
    	ResponseEntity<byte[]> responseEntitys=null;
    	try {
    		HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            String filename = "周边安全报告.doc";
            //解决文件中文乱码
            String agent = request.getHeader("User-Agent").toLowerCase();

            //识别IE浏览器
            if (agent != null && (agent.indexOf("msie") != -1 ||
                    (agent.indexOf("rv") != -1 && agent.indexOf("firefox") == -1))) {
                filename = URLEncoder.encode(filename, "UTF-8");
            }//IE浏览器
               else {
                filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");}//firefox浏览器

            headers.setContentDispositionFormData("attachment",filename);  //解决文件名中文乱码问题
            responseEntitys=new ResponseEntity<byte[]>(alarmBiz.reportDown(), headers, HttpStatus.OK);

            this.userLogService.insertUserLog(LogTypeEnum.TYPE_DOWNLOAD_REPORT, true, ""); 
		} catch (Exception e) {
            logger.error("导出报告异常",e);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_DOWNLOAD_REPORT, false, e.getMessage());
		}
        return responseEntitys;
    }
}
