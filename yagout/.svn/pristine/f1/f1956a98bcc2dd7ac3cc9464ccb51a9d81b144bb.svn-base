package com.skeye.yagout.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.YagoutRawaccountHandledBiz;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.service.RawaccountHandledService;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;
import com.skeye.yagout.util.EncodeUtil;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class YagoutRawaccountHandledBizImpl implements YagoutRawaccountHandledBiz {
	@Autowired  private RawaccountHandledService rawaccountHandledService;
	private static Logger logger = Logger.getLogger(YagoutRawaccountHandledBizImpl.class);
	@Autowired  private LogService logService;
	@Override
	public void queryRawaccountHandledByPage(CommonPage commonPage) {
	    List<Map> rawaccountHandledList = this.rawaccountHandledService.getRawaccountHandledListByPage(commonPage);
	    for (Map map : rawaccountHandledList) {
			map.put("Password", EncodeUtil.doCharsEncode((String) map.get("Password")));
		}
	    commonPage.setPageData(rawaccountHandledList);
	}

	@Override
	public CommonResult queryAccountByGroup(String accountName, String adslAccount, Integer rows) {
		CommonResult result=new CommonResult();
		result.setData(rawaccountHandledService.getRawaccountHandledDistinc(accountName, adslAccount, rows));
		result.setIsSuccess(true);
		return result;
	}

	@Override
	public CommonResult deleteRawaccountHandledByList( List<Integer> ids) {
		CommonResult commonResult=new CommonResult();
		try {
			commonResult.setIsSuccess(rawaccountHandledService.deleteRawaccountHandledByList(ids));
		}catch (Exception e){
			logger.error("删除账户轨迹异常",e);
		}
		Subject subject = SecurityUtils.getSubject();
		logService.addLog((String) subject.getPrincipal(),"删除账户轨迹",commonResult.getIsSuccess(),"删除的账户轨迹的id为:"+ JSONObject.toJSONString(ids));
		return commonResult;
	}

	
}
