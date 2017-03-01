package com.yagout.defense.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.HistoryAlarmRecordBiz;
import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.service.HistoryAlarmRecordService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
@Service
public class HistoryAlarmRecordBizImpl implements HistoryAlarmRecordBiz{
    private static Logger logger = Logger.getLogger(HistoryAlarmRecordBiz.class);
   // @Autowired
   // private LogService logService;
    @Autowired  private HistoryAlarmRecordService harService;
//    @Value("${nomalUserRole}")
//    @Autowired  private  Integer nomalUserRole;
	@Override
	public void queryHistoryAlarmRecordPage(CommonPage commonPage) {
		   List<Map<String,Object>> hisoryalarmrecord=harService.queryHistoryAlarmRecordPage(commonPage);
	        commonPage.setPageData(hisoryalarmrecord);
		
	}
	
	public int  getReadState() {
    	int num=harService.getReadState();
        return num;
    }

	@Override
	public int updateReadState(Map map) {
		// TODO Auto-generated method stub
		return harService.updateReadState(map);
	}
	
	public CommonResult insert(AlarmRecord record){
		CommonResult commonResult=new CommonResult();
		boolean success=false;
		try {
			success=harService.insert(record);
		} catch (Exception e) {
			logger.error("告警信息标记异常",e);
		}
		commonResult.setIsSuccess(success);
		return commonResult;
	}

}
