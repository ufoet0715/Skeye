package com.skeye.yagout.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.service.DailinfoHandledService;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;
import com.skeye.yagout.util.DateFormatUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class YagoutDailinfoHandledBizImpl implements com.skeye.yagout.biz.YagoutDailinfoHandledBiz {
    @Autowired private DailinfoHandledService dailinfoHandledService;
	@Autowired  private LogService logService;
	private static Logger logger = Logger.getLogger(YagoutDailinfoHandledBizImpl.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void queryDailinfoHandledByPage(CommonPage commonPage) {
		List<Map> dailinfoHandledList = this.dailinfoHandledService.getDailinfoHandledListByPage(commonPage);
		for (Map map : dailinfoHandledList) {
			int time=(Integer) map.get("DailTime");
			String date=DateFormatUtil.toDateStringM(time);
			map.put("DailTime", date);
			
			int l=(Integer) map.get("DailType"); 
			if(l==1)
			{
				map.put("DailType", "上线");
			}
			else
			{
				map.put("DailType", "下线");
			}
		}
		commonPage.setPageData(dailinfoHandledList);
	}
	
	@Override
	public CommonResult deleteDailinfoHandledByList(List<Integer> ids) {
		CommonResult commonResult=new CommonResult();
		try {
		commonResult.setIsSuccess(dailinfoHandledService.deleteDailinfoHandledByList(ids));
		}catch (Exception e){
			logger.error("删除ADSL异常",e);
		}
		Subject subject = SecurityUtils.getSubject();
		logService.addLog((String) subject.getPrincipal(),"删除ADSL帐号",commonResult.getIsSuccess(),"删除的ADSL帐号的id为:"+ JSONObject.toJSONString(ids));
		return commonResult;
	}

}
