package com.yagout.defense.controller;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.bean.DictionaryBean;
import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.redis.RedisCache;
import com.yagout.defense.service.DictionaryService;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.DictionaryEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static com.yagout.defense.biz.impl.DictionaryBizImpl.DICTION_TIMEOUT;

@Controller
@RequestMapping(value = "/loginset")
public class LoginSetController {
	
	@Autowired private DictionaryBiz dictionaryBiz;
	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private RedisCache<String, Object> redisCache;

	@RequestMapping(value = "/index")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("loginset/loginSet");
		List<Integer> keys=new ArrayList<Integer>();
		keys.add(DictionaryEnums.LOGIN_TIMEOUT.getCode());
		keys.add(DictionaryEnums.LOGIN_NUMBER_OUT.getCode());
		keys.add(DictionaryEnums.LOCK_TIME.getCode());
		List<Dictionary> dicList=dictionaryService.queryDictionaryByIds(keys);
		DictionaryEnums  dictionaryEnums;
		  for (Dictionary dictionary:dicList){
			  dictionaryEnums= DictionaryEnums.find(dictionary.getDictionaryKey());
			  if (dictionaryEnums!=null){
				  view.addObject(dictionaryEnums.name(),dictionary.getDictionaryValue());
			  }
		  }

		return view;
	}
	
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(Integer loginTimeOut,Integer loginNumberOut,String timeUnit,Integer lockTime){
		CommonResult result = new CommonResult();
		Boolean success = false;
		List<DictionaryBean> beeans=new ArrayList<DictionaryBean>();
	DictionaryBean dictionary = new DictionaryBean();
		dictionary.setDictionaryKey(DictionaryEnums.LOGIN_TIMEOUT.getCode());
		dictionary.setDictionaryValue(loginTimeOut.toString());
		beeans.add(dictionary);
		DictionaryBean bean = new DictionaryBean();
		bean.setDictionaryKey(DictionaryEnums.LOGIN_NUMBER_OUT.getCode());
		bean.setDictionaryValue(loginNumberOut.toString());
		beeans.add(bean);
		dictionary=new DictionaryBean();
		dictionary.setDictionaryKey(DictionaryEnums.LOCK_TIME.getCode());
		dictionary.setDictionaryValue(lockTime.toString());
		beeans.add(dictionary);
		success = dictionaryBiz.editDictionaryList(beeans);
		redisCache.remove(DICTION_TIMEOUT);
		result.setIsSuccess(success);
		return JSONObject.toJSONString(result);
	}
}
