package com.skeye.yagout.service;

import com.skeye.yagout.dal.model.YagoutLog;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;

import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/11/22.
 */
public interface LogService {
    public boolean  addLog(String userName, String logType, CommonResult result);

    public boolean  addLog(String userName, String logType, boolean isSuccess);
    public boolean  addLog(String userName, String logType, boolean isSuccess,String msg);

    public List<Map> queryLogByPage(CommonPage commonPage);
}
