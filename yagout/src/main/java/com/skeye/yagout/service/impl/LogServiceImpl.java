package com.skeye.yagout.service.impl;

import com.skeye.yagout.dal.dao.LogDao;
import com.skeye.yagout.dal.model.YagoutLog;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/11/22.
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired private LogDao logDao;

    @Override
    public boolean addLog(String userName, String logType, boolean isSuccess) {
        CommonResult result=new CommonResult(isSuccess);
        return addLog(userName, logType, result);
    }

    @Override
    public boolean addLog(String userName, String logType, CommonResult result) {
        YagoutLog yagoutLog=new YagoutLog();
       // yagoutLog.s etUserId(userId);
        yagoutLog.setYagoutUserName(userName);
        yagoutLog.setLogType(logType);
        yagoutLog.setIsSuccess(result.getIsSuccess());
        yagoutLog.setLogException(result.getErrorException());
        yagoutLog.setLogMsg(result.getResultMsg());
        yagoutLog.setLogTime(new Date());
        return  logDao.addLog(yagoutLog);
    }

    @Override
    public boolean addLog(String userName, String logType, boolean isSuccess, String msg) {
        CommonResult result=new CommonResult(isSuccess);
        result.setResultMsg(msg);
        return addLog(userName, logType, result);
    }

    @Override
    public List<Map> queryLogByPage(CommonPage commonPage) {
        return logDao.getLogByMap(commonPage.pageToMap());
    }
}
