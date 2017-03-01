package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.ApAdHocBiz;
import com.yagout.defense.service.ApAdHocService;
import com.yagout.defense.util.CommonPage;
@Service
public class ApAdHocBizImpl implements ApAdHocBiz{

	
	@Autowired private ApAdHocService apService;
	@Override
	public void query(CommonPage commonPage) {
		List<Map<String, Object>> datas=apService.query(commonPage);
		
		 commonPage.setPageData(datas);
	}

}
