package com.yagout.defense.controller;

import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.ScanStationBiz;
import com.yagout.defense.util.DictionaryEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/station")
public class ScanStationController {
	@Autowired
	private ScanStationBiz stationBiz;
	@Autowired
	private DictionaryBiz dictionaryBiz;
	
	@RequestMapping("/scanStationlistData")
	@ResponseBody
    public List<Map<String, Object>> listData(String id) {
		List<Map<String, Object>> stations=null;
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if(id.equals("未连接AP的终端")){
			stations=stationBiz.getmacApisNullByMap();
		}else{
			map.put("macAp",  id.replaceAll("-",":"));
			stations = stationBiz.queryStationByPage(map);

		}
		dataMap.put("encryptWayMap", dictionaryBiz.queryDictionaryByParent(DictionaryEnums.ENCRYPT_WAY.getCode()));
		dataMap.put("identityMap", dictionaryBiz.queryDictionaryByParent(DictionaryEnums.IDENTITY.getCode()));
		dataMap.put("authWayMap", dictionaryBiz.queryDictionaryByParent(DictionaryEnums.AUTH_WAY.getCode()));
		dataMap.put("privacy", dictionaryBiz.queryDictionaryByParent(DictionaryEnums.PRIVACY.getCode()));
		dataMap.put("WPS", dictionaryBiz.queryDictionaryByParent(DictionaryEnums.WPS.getCode()));
		dataMap.put("boradcastSSID", dictionaryBiz.queryDictionaryByParent(DictionaryEnums.BROADCAST_SSID.getCode()));
		stations.add(dataMap);
		return stations;
    }
}
