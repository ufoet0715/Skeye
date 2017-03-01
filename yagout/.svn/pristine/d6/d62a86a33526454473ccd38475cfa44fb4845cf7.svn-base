package com.skeye.yagout.service;

import com.skeye.yagout.dal.model.RawaccountHandled;
import com.skeye.yagout.util.CommonPage;

import java.util.List;
import java.util.Map;

public interface RawaccountHandledService {

	List<RawaccountHandled> getRawaccountHandledList();

	List<Map> getRawaccountHandledListByPage(CommonPage commonPage);
	
	boolean deleteRawaccountHandledByList(List<Integer> ids);
	
	List<Map> getRawaccountHandledDistinc(String accountName,String adslAccount,Integer getRows);
}