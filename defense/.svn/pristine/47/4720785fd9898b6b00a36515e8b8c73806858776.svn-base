package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.ApVisitorBiz;
import com.yagout.defense.service.ApVisitorService;
import com.yagout.defense.util.CommonPage;
@Service
public class ApVisitorBizImpl  implements ApVisitorBiz{
	@Autowired private ApVisitorService apService;
	
	public void query(CommonPage commonPage){
		List<Map<String, Object>> datas=apService.query(commonPage);
		commonPage.setPageData(datas);
	}

}
