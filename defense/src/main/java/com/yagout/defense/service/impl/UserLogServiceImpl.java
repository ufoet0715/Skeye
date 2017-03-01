package com.yagout.defense.service.impl;

import com.yagout.defense.dal.dao.UserLogDao;
import com.yagout.defense.dal.dao.UsersDao;
import com.yagout.defense.dal.model.UserLog;
import com.yagout.defense.service.UserLogService;
import com.yagout.defense.util.LogTypeEnum;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.yagout.defense.dal.model.DefenseType;
import com.yagout.defense.dal.model.User;
import com.yagout.defense.util.DateFormatter;


@Service
public class UserLogServiceImpl implements UserLogService {

	@Autowired private UsersDao userDao;
	@Autowired private UserLogDao userLogDao;
	private static Logger logger=Logger.getLogger(UserLogServiceImpl.class);
	
	@Override
	public boolean insertUserLog(UserLog userLog) {
		return this.userLogDao.insertUserLog(userLog);
	}
	
	@Override
	public void insertUserLog(LogTypeEnum logTypeEnum, boolean isSuccess, String userName, String exception){
		String msg = logTypeEnum.getMsg();

	    Calendar calendar=Calendar.getInstance();
	    Date date = calendar.getTime();
	    String dateMeg=DateFormatter.dateFormat(date);
	    
	    int result=0;
	    if(!isSuccess)
	    {
	    	result=1;
	    }
	    
	    int userId = 0;
	    
	    String desc="账户："+String.valueOf(userId)+" "+msg;
	    
	    try {
	    	User user = this.userDao.getUserByName(userName);
		    if(user!=null)
		    {
		    	userId = Integer.valueOf(String.valueOf(user.getUserId()));
		    	
		    	UserLog userLog=new UserLog();
		    
		    	userLog.setUserId(userId);
		    	userLog.setEventType(logTypeEnum.getCode());
			    userLog.setEventTime(date);
			    userLog.setEventResult(result);
			    userLog.setEventVerbose(desc);
			    userLog.setLogException(exception);
			    
			    if(!this.userLogDao.insertUserLog(userLog)){
					logger.error("插入日志报错" );
				}


		    }
		    else
		    {
				logger.error("["+dateMeg+"]: 账户未找到，日志插入失败！");

		    }
		} catch (Exception e) {
			logger.error("["+dateMeg+"]: 系统异常，日志插入失败！\n"+e.getMessage());

		}
	    
	}
	
	@Override
	public void insertUserLog(LogTypeEnum logTypeEnum,boolean isSuccess,String exception){
		String msg = logTypeEnum.getMsg();
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
	    int userId = Integer.valueOf(String.valueOf(session.getAttribute("userId")));
	    
	    Calendar calendar=Calendar.getInstance();
	    Date date = calendar.getTime();
	    String dateMeg=DateFormatter.dateFormat(date);
	    
	    int result=0;
	    if(!isSuccess)
	    {
	    	result=1;
	    }
	    
	    String desc="账户："+String.valueOf(userId)+" "+msg;
	   
	    UserLog userLog=new UserLog();
	    userLog.setUserId(userId);
	    userLog.setEventType(logTypeEnum.getCode());
	    userLog.setEventTime(date);
	    userLog.setEventResult(result);
	    userLog.setEventVerbose(desc);
	    userLog.setLogException(exception);
	    
	    try {
	    	if(!this.userLogDao.insertUserLog(userLog))
		    {
				logger.error("["+dateMeg+"]: 日志插入失败!");
		    }
		} catch (Exception e) {
			logger.error("["+dateMeg+"]: 系统异常，日志插入失败！\n"+e.getMessage());

		}
	}

	@Override
	public void insertUserLogByDefenseTypeList(boolean isSuccess, List<DefenseType> defenseTypesList,
			String exception) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
	    int userId = Integer.valueOf(String.valueOf(session.getAttribute("userId")));
	    
	    Calendar calendar=Calendar.getInstance();
	    Date date = calendar.getTime();
	    String dateMeg=DateFormatter.dateFormat(date);
	    
	    int result=0;
	    if(!isSuccess)
	    {
	    	result=1;
	    }
	    
	    String desc=null;
	    List<UserLog> userLogList=new ArrayList<UserLog>();
	    
	    try {
	    	if(defenseTypesList!=null)
		    {
		    	for (DefenseType defenseType : defenseTypesList) {
			    	desc="账户："+String.valueOf(userId)+" "+defenseType.getName();
			    	LogTypeEnum logTypeEnum = LogTypeEnum.findByMsg(defenseType.getName());
			    	
			    	UserLog userLog=new UserLog();
				    userLog.setUserId(userId);
				    userLog.setEventType(logTypeEnum.getCode());
				    userLog.setEventTime(date);
				    userLog.setEventResult(result);
				    userLog.setEventVerbose(desc);
				    userLog.setLogException(exception);
				    
				    userLogList.add(userLog);
				}
			    
		    	if(!this.userLogDao.insertUserLogByList(userLogList))
			    {
					logger.error("["+dateMeg+"]: 日志插入失败!");

			    }
		    }
		    else
		    {
		    	logger.error("账户未找到，日志插入失败！");
		    }
		} catch (Exception e) {
			logger.error("["+dateMeg+"]: 系统异常，日志插入失败！\n"+e.toString());
		}
	    
	}
}
