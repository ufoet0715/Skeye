package com.skeye.yagout.service.impl;

import com.skeye.yagout.dal.dao.RawaccountHandledAndAccountTypeDao;
import com.skeye.yagout.dal.model.RawaccountHandledAndAccountType;
import com.skeye.yagout.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private RawaccountHandledAndAccountTypeDao rawaccountHandledAndAccountTypeDao;

    /* (non-Javadoc)
     * @see com.skeye.yagout.service.impl.AnalysisService#countByNameAndType(java.lang.String)
	 */
    @Override
    public List<RawaccountHandledAndAccountType> countByNameAndType(Long beginTime, Long endTime) {
        Map<String, Object> map = new HashMap();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return this.rawaccountHandledAndAccountTypeDao.countByNameAndType(map);
    }

    /* (non-Javadoc)
     * @see com.skeye.yagout.service.impl.AnalysisService#countByNameAndADSL(java.lang.String)
     */
    @Override
    public List<RawaccountHandledAndAccountType> countByNameAndADSL(Long beginTime, Long endTime) {
        Map<String, Object> map = new HashMap();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return this.rawaccountHandledAndAccountTypeDao.countByNameAndADSL(map);
    }


    /* (non-Javadoc)
     * @see com.skeye.yagout.service.impl.AnalysisService#countByNameAndIP(java.lang.String)
     */
    @Override
    public List<RawaccountHandledAndAccountType> countByNameAndIP(Long beginTime, Long endTime) {
        Map<String, Object> map = new HashMap();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return this.rawaccountHandledAndAccountTypeDao.countByNameAndIP(map);
    }


    @Override
    public List<RawaccountHandledAndAccountType> countByTime(String beginTime, String endTime,String accountName,String adslAccountEq,String timeFmort) {
        Map<String, Object> map = new HashMap();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        map.put("accountNameEq", accountName);
        map.put("adslAccountEq", adslAccountEq);
        map.put("timeFmort", timeFmort);
        return this.rawaccountHandledAndAccountTypeDao.countByTime(map);
    }

    /* (non-Javadoc)
         * @see com.skeye.yagout.service.impl.AnalysisService#countByNameAndMAC(java.lang.String)
         */
    @Override
    public List<RawaccountHandledAndAccountType> countByNameAndMAC(Long beginTime, Long endTime) {
        Map<String, Object> map = new HashMap();
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return this.rawaccountHandledAndAccountTypeDao.countByNameAndMAC(map);
    }


}
