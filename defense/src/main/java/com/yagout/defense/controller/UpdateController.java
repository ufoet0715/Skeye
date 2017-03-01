package com.yagout.defense.controller;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.UpdateBiz;
import com.yagout.defense.biz.bean.UpdateBean;
import com.yagout.defense.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/update")
public class UpdateController {

	@Autowired
	private UpdateBiz updateBiz;

	@RequestMapping("/updateList")
	public String alarmList() {
		return "update/updateSet";
	}

	@RequestMapping("/sqlList")
	public String sqlList() {
		return "strategy/strategySet";
	}

	@RequestMapping(value = "/fileUpload", produces="text/html;charset=UTF-8;",method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody String fileUpload(@RequestParam MultipartFile myfile) {

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

		CommonResult result = updateBiz.uploadUpdate(myfile);
		UpdateBean bean = (UpdateBean) result.getData();
		if (bean != null) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("name", bean.getFileName());
			map.put("remark", bean.getIniText());

			listMap.add(map);
		}
		return JSONObject.toJSONString(listMap);

	}

	@RequestMapping(value = "/sqlUpload",produces="text/html;charset=UTF-8;", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody String sqlUpload(@RequestParam MultipartFile myfile) {
		CommonResult result = updateBiz.sqlUpdate(myfile);
		return JSONObject.toJSONString(result);

	}

	@RequestMapping(value = "/save")
	public @ResponseBody String save(@RequestParam(value = "name") String name ) {
		CommonResult commonResult = updateBiz.save(name);
		System.out.println(name);
		return JSONObject.toJSONString(commonResult);
	}

}
