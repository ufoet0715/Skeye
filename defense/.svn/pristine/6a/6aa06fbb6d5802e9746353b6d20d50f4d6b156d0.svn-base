package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.StationAdHocBiz;
import com.yagout.defense.service.StationAdHocService;
import com.yagout.defense.util.CommonPage;
@Service
public class StationAdHocBizImpl implements	StationAdHocBiz{

	
	@Autowired private StationAdHocService service;
	
	@Override
	public void queryByMap(CommonPage commonPage) {
		List<Map<String, Object>> datas=service.queryByMap(commonPage.pageToMap());
		commonPage.setPageData(datas);
		}
		
	
	
	

}
