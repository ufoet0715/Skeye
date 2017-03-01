package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.StationNeighborBiz;
import com.yagout.defense.service.StationNeighborService;
import com.yagout.defense.util.CommonPage;
@Service
public class StationNeighborBizImpl implements	StationNeighborBiz{

	
	@Autowired private StationNeighborService service;
	
	@Override
	public void queryByMap(CommonPage commonPage) {
		List<Map<String, Object>> datas=service.queryByMap(commonPage.pageToMap());
		commonPage.setPageData(datas);
		}
}
