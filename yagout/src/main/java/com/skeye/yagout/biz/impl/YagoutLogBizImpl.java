package com.skeye.yagout.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.yagout.biz.YagoutLogBiz;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.util.CommonPage;

@Service
public class YagoutLogBizImpl implements YagoutLogBiz {
	@Autowired private LogService logService;
	
	public String logList() {
        return "admin/logList";
    }

    public void logListData(CommonPage commonPage) {
        List<Map> logList = logService.queryLogByPage(commonPage);
        for (Map map : logList) {
			boolean l=(Boolean) map.get("is_success");
			if(l)
			{
				map.put("is_success", "成功");
			}
			else
			{
				map.put("is_success", "失败");
			}
		}
        commonPage.setPageData(logList);
    }
}
