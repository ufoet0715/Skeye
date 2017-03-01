package com.yagout.defense.biz.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.exceptionMacBiz;
import com.yagout.defense.biz.bean.ExceptionMacBean;
import com.yagout.defense.service.ExceptionMacService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
@Service
public class exceptionMacBizImpl implements exceptionMacBiz{
	private static Logger logger = Logger.getLogger(exceptionMacBiz.class);
	@Autowired private ExceptionMacService macService;
	
	public void  queryByMap(CommonPage commonPage){
		List<Map<String, Object>> datas=macService.query(commonPage);
		for (Map<String, Object> map : datas) {
			Long cnvalidTime = Long.parseLong(String.valueOf(map.get("cnvalidTime")));
			if(cnvalidTime>new Date().getTime()){
				map.put("excpState", 1);
			}else{
				map.put("excpState", 0);
			}
		}
		commonPage.setPageData(datas);
	}
	
	
	public CommonResult delete(String mac){
		CommonResult result=new CommonResult();
		boolean success=false;
		try {
			success=macService.delete(mac);
		} catch (Exception e) {
			logger.error("忽略mac异常",e);
		}
		result.setIsSuccess(success);
		return result;
		
	}
	
	@Override
	public List<ExceptionMacBean> queryList(){
		return macService.queryList();
	}

}
