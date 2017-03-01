package com.yagout.defense.biz.impl;

import com.yagout.defense.biz.ScanApBiz;
import com.yagout.defense.biz.bean.ScanApBean;
import com.yagout.defense.dal.model.ScanAp;
import com.yagout.defense.dal.model.ScanStation;
import com.yagout.defense.service.ScanApService;
import com.yagout.defense.service.ScanStationService;
import com.yagout.defense.util.CommonPage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ScanApBizImpl implements ScanApBiz{
	@Autowired
	private ScanApService apService;
	@Autowired ScanStationService scanService;
	

	@Override
	public void queryApByPage(CommonPage commonPage) {
		List<ScanStation> list=scanService.getMacapIsNull();
		List<Map<String,Object>> apByPage = apService.queryApByPage(commonPage);
		if(apByPage!=null){
			String mac;
			for(Map<String,Object> ap:apByPage){
				mac=(String)ap.get("mac");
				if(StringUtils.isNotEmpty(mac)){
					ap.put("mac",mac.replace(":","-"));
				}

			}
		}
		if(list!=null){
			Map<String, Object> apMap=new HashMap<String, Object>();
			apMap.put("mac", "未连接AP的终端");
			apMap.put("stationCount", list.size());
			apByPage.add(apMap);
		}
		
		commonPage.setPageData(apByPage);
		
	}
	
	@Override
	public List<ScanAp> queryApList(){
		return apService.queryApList();
	}
	
	@Override
	public ScanApBean queryByKey(String mac){
		return apService.queryByKey(mac);
	}

}
