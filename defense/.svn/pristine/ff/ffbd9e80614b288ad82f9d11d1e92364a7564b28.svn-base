package com.yagout.defense.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.AlarmRecordBiz;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.HistoryAlarmRecordBiz;
import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.DictionaryEnums;

@Controller
@RequestMapping("/alarm")
public class AlarmRecordController {

	  @Autowired  private AlarmRecordBiz arBiz;
	  @Autowired private DictionaryBiz dictionaryBiz;
	  @Autowired private HistoryAlarmRecordBiz harBiz;

	    @RequestMapping("/alarmtop")
	    public ModelAndView alarmList() {
	    	ModelAndView view = new ModelAndView("alarm/alarmtop");
	        return view;
	    }
	    @RequestMapping("/alarmrecordList")
	    public ModelAndView alarmrecordList() {
	    	ModelAndView view = new ModelAndView("alarm/alarmrecordList");
	    	view.addObject("readState", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.READ_STATE.getCode())));
	    	view.addObject("alarmState", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.ALARM_STATE.getCode())));
	    	view.addObject("readStateNum", JSONObject.toJSONString(DictionaryEnums.READ_STATE.getCode()));
	    	view.addObject("alarmStateNum", JSONObject.toJSONString(DictionaryEnums.READ_STATE.getCode()));
	    	
	        return view;
	    }
	    
	    @RequestMapping("/alarmrecordListData")
	    @ResponseBody
	    public String AlarmRecordListData(CommonPage commonPage) {
	    	
	    	arBiz.queryAlarmRecordPage(commonPage);
	        return commonPage.toShowPage();
	    }
	  
	    @RequestMapping("/getreadstate")
	    @ResponseBody
	    public Map  getReadState() {
	    	Map map=new HashMap();	
	    	int num=arBiz.getReadState();
	    	map.put("num", num);
	        return map;
	    }
	    
	    @RequestMapping("/updatear")
	    @ResponseBody
		public String updateReadState( @RequestParam("id[]") String id){
	    	CommonResult result=new CommonResult();
	    	AlarmRecord record = arBiz.queryById(Integer.valueOf(id));
	    		record.setReadState(1);
	    	 result=harBiz.insert(record);
			 result=arBiz.updateReadState(record);
			return JSONObject.toJSONString(result);
		}
}
