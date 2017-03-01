package com.yagout.defense.controller;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.HistoryAlarmRecordBiz;
import com.yagout.defense.dal.model.HistoryAlarmRecord;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.DictionaryEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/*
 * 警告信息功能
 */

@Controller
@RequestMapping("/alarm")
public class HistoryAlarmRecordController {

    @Autowired  private HistoryAlarmRecordBiz hirBiz;
    @Autowired private DictionaryBiz dictionaryBiz;

    @RequestMapping("/hitory_alarmList")
    public ModelAndView userList() {
    	ModelAndView view = new ModelAndView("alarm/histor_alarmList");
    	view.addObject("alarmState", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.ALARM_STATE.getCode())));
    	view.addObject("readState", JSONObject.toJSONString(dictionaryBiz.queryDictionaryByParent(DictionaryEnums.READ_STATE.getCode())));
    	view.addObject("alarmStateNum", JSONObject.toJSONString(DictionaryEnums.ALARM_STATE.getCode()));
    	view.addObject("readStateNum", JSONObject.toJSONString(DictionaryEnums.READ_STATE.getCode()));
    	
        return view;
    }
    
    @RequestMapping("/hitory_alarmListData")
    @ResponseBody
    public String HistoryAlarmListData(HttpServletRequest request,CommonPage commonPage) {
    	
    	hirBiz.queryHistoryAlarmRecordPage(commonPage);
        return commonPage.toShowPage();
    }
    @RequestMapping("/update")
    @ResponseBody
	public Map updateHAR(HistoryAlarmRecord har){
		Map map=new HashMap();
		map.put("har", har);
		Map map1=new HashMap();
		int num=hirBiz.updateReadState(map);
		if(num==1){
			map1.put("msg", "修改成功");
		}else{
			map1.put("msg","修改失败");
		}
		return map;
		
	}
  
}

