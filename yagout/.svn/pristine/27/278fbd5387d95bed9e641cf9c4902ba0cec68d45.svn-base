package com.skeye.yagout.dal.dao.mybatis;

import com.skeye.yagout.biz.enumpackage.LogTypeEnum;
import com.skeye.yagout.dal.dao.LogDao;
import com.skeye.yagout.dal.model.YagoutLog;
import com.skeye.yagout.dal.service.YagoutLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/11/22.
 */
@Repository
public class LogDaoImpl implements LogDao {

    @Autowired private YagoutLogMapper  yagoutLogMapper;
    @Override
    public boolean addLog(YagoutLog yagoutLog) {
        int rows= yagoutLogMapper.insertSelective(yagoutLog);
        return rows>0;
    }

    @Override
    public List<Map> getLogByMap(Map<String, Object> map) {
        String logTypeEq=(String)map.get("logTypeEq");
        if(logTypeEq!=null){
            map.put("logTypeEq", LogTypeEnum.findMSG(Integer.parseInt(logTypeEq)));
        }
        return yagoutLogMapper.getLogByMap(map);
    }
}
