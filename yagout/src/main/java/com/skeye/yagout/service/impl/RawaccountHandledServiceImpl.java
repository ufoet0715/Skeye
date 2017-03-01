package com.skeye.yagout.service.impl;

import com.skeye.yagout.dal.dao.RawaccountHandledDao;
import com.skeye.yagout.dal.model.RawaccountHandled;
import com.skeye.yagout.dal.model.RawaccountHandledExample;
import com.skeye.yagout.service.RawaccountHandledService;
import com.skeye.yagout.util.CommonPage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RawaccountHandledServiceImpl implements RawaccountHandledService {
    @Autowired private RawaccountHandledDao rawaccountHandledDao;
    
    @Override
	public List<RawaccountHandled> getRawaccountHandledList()
    {
    	RawaccountHandledExample rawaccountHandledExample=new RawaccountHandledExample();
    	return this.rawaccountHandledDao.getRawaccountHandledList(rawaccountHandledExample);
    }

	@Override
	public List<Map> getRawaccountHandledDistinc(String accountName, String adslAccount, Integer getRows) {
	   Map<String,Object> map=new HashMap();
          if(StringUtils.isNotEmpty(accountName)){
			  map.put("accountName",accountName);
			  map.put("groupBy","AccountName");
		  }else if (StringUtils.isNotEmpty(adslAccount)){
			  map.put("adslAccount",adslAccount);
			  map.put("groupBy","ADSLAccount");
		  }
          map.put("getRows",getRows);
			return rawaccountHandledDao.rawaccountHandledGroup(map);
	}

	@Override
	public List<Map> getRawaccountHandledListByPage(CommonPage commonPage) {
		return this.rawaccountHandledDao.getRawaccountHandledListByMap(commonPage.pageToMap());
	}

	@Override
	public boolean deleteRawaccountHandledByList(List<Integer> ids) {
        RawaccountHandledExample example=new RawaccountHandledExample();
		example.createCriteria().andIdIn(ids);
		int rows=rawaccountHandledDao.deleteRawaccountHandledByRecord(example);
		return ids.size()>=rows&&rows>0;
            
	}
}
