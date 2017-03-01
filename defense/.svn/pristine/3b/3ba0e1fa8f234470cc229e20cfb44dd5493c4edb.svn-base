package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.StationTrustBiz;
import com.yagout.defense.service.StationTrustService;
import com.yagout.defense.util.CommonPage;
@Service
public class StationTrustBizImpl implements StationTrustBiz{

	
	@Autowired private StationTrustService service;
	
	@Override
	public void queryByMap(CommonPage commonPage) {
		List<Map<String, Object>> datas=service.query(commonPage);
		commonPage.setPageData(datas);
		}
		
	
	
	

}
