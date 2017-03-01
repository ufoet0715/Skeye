package com.skeye.yagout.dal.dao;

import com.skeye.yagout.dal.model.YagoutLog;

import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/11/22.
 */
public interface LogDao {

    public boolean addLog(YagoutLog yagoutLog);

    public List<Map> getLogByMap(Map<String,Object> map);
}
