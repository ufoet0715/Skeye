package com.skeye.yagout.dal.dao;

import com.skeye.yagout.dal.model.RawaccountHandled;
import com.skeye.yagout.dal.model.RawaccountHandledExample;

import java.util.List;
import java.util.Map;

public interface RawaccountHandledDao {
	List<RawaccountHandled> getRawaccountHandledList(RawaccountHandledExample rawaccountHandledExample);

	List<RawaccountHandled> getRawaccountHandledListByLike(RawaccountHandledExample rawaccountHandledExample);
	
	List<Map> getRawaccountHandledListByMap(Map<String,Object> paramMap);
	List<Map> rawaccountHandledGroup(Map<String,Object> paramMap);
	
	int deleteRawaccountHandledByRecord(RawaccountHandledExample rawaccountHandledExample);
}
