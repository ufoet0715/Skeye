package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.StationVisitorBiz;
import com.yagout.defense.service.StationVisitorService;
import com.yagout.defense.util.CommonPage;
@Service
public class StationVisitorBizImpl implements	StationVisitorBiz{

	
	@Autowired private StationVisitorService service;
	
	@Override
	public void queryByMap(CommonPage commonPage) {
		List<Map<String, Object>> datas=service.queryByMap(commonPage.pageToMap());
		commonPage.setPageData(datas);
		}
		
	
	
	

}
