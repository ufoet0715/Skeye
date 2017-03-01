package com.yagout.defense.biz.impl;

import com.yagout.defense.biz.AlarmRecordBiz;
import com.yagout.defense.dal.model.AlarmRecord;
import com.yagout.defense.redis.RedisCache;
import com.yagout.defense.service.AlarmRecordService;
import com.yagout.defense.service.UserLogService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.LogTypeEnum;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlarmRecordBizImpl implements AlarmRecordBiz{
	public   static  final  String  ALARMRECORDSTATE="ALARMRECORDSTATE";
	
	private static Logger logger = Logger.getLogger(AlarmRecordBiz.class);
	
	@Autowired
    private RedisCache<String, Object> redisCache;
	@Autowired  
	private AlarmRecordService arService;
	

	@Autowired private UserLogService userLogService;
	
	@Override
	public void queryAlarmRecordPage(CommonPage commonPage) {	
	        try{
	        	Boolean data=(Boolean) redisCache.get(ALARMRECORDSTATE);
	          if (data==null || data){
	        	List<Map<String,Object>> alarmrecord=arService.queryAlarmRecordPage(commonPage);
	        	commonPage.setPageData(alarmrecord);	  	        
	        	if(alarmrecord==null||alarmrecord.size()==0){
	        		this.userLogService.insertUserLog(LogTypeEnum.TYPE_ALARM_QUERY, false, "", "警告未找到");
	        		redisCache.put(ALARMRECORDSTATE, false,50000);
	        	}
	        	else
	        	{
	        		this.userLogService.insertUserLog(LogTypeEnum.TYPE_ALARM_QUERY, true, "", "");
	        	}
	          }
	        }catch (Exception e){
	            logger.error("查询警告异常",e);
	            this.userLogService.insertUserLog(LogTypeEnum.TYPE_ALARM_QUERY, false, "", "查询警告异常");
	        }	  
	}



	public int  getReadState() {
    	int num=arService.getReadState();
        return num;
    }
	
	public AlarmRecord queryById(Integer id){
		return arService.queryById(id);
	}

	@Override
	public CommonResult updateReadState(AlarmRecord record) {
		CommonResult commonResult=new CommonResult();
		boolean success=false;
		try {
			success=arService.updateReadState(record);
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_STATE, success, "");
		} catch (Exception e) {
			this.userLogService.insertUserLog(LogTypeEnum.TYPE_UPDATE_STATE, success, "修改告警状态异常");
			logger.error("告警信息标记异常",e);
		}
		commonResult.setIsSuccess(success);
		return commonResult;
	}
	
//	 @Override
//	    public String queryAlarmRecordState() {
//		 Map<String,String> data=null;
//		 Map map=new HashMap();
//	        try{
//	          data= (Map<String, String>) redisCache.get(ALARMRECORDSTATE);	          
//	          if (data.get(ALARMRECORDSTATE).equals("true")){
//	        	 map=arService.getAlarmRecordByMap();
//	          }
//	        }catch (Exception e){
//	            logger.error("查询警告中心异常",e);
//	        }
//			return "aa";	       
//	    }
}
