package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.ApNeighborBiz;
import com.yagout.defense.service.ApNeighborService;
import com.yagout.defense.util.CommonPage;
@Service
public class ApNeighborBizImpl implements ApNeighborBiz{

	
	@Autowired private ApNeighborService apService;
	@Override
	public void query(CommonPage commonPage) {
		List<Map<String, Object>> datas=apService.query(commonPage);
		commonPage.setPageData(datas);
	}

}
