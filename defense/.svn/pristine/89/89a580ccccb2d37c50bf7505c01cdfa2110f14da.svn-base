package com.yagout.defense.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.WindowsGetSpaceBiz;
import com.yagout.defense.biz.bean.DiskBean;
import com.yagout.defense.util.CommonResult;
@Controller
@RequestMapping("/windows")
public class WindowsGetSpaceController {
	
	@Autowired WindowsGetSpaceBiz getSpaceBiz;
	
	@RequestMapping("/getSpace")
	public @ResponseBody  String getSpace(){
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		CommonResult result=getSpaceBiz.disk();
		DiskBean bean=(DiskBean) result.getData();
		if(bean!=null){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", bean.getTotal());
			map.put("free", bean.getFree());
			map.put("use", bean.getUse());
			map.put("percent", bean.getPercent());
			listMap.add(map);
		}
		return JSONObject.toJSONString(listMap);
	}

}
