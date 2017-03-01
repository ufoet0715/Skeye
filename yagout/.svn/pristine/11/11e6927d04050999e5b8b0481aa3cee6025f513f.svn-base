package com.skeye.yagout.service;

import com.skeye.yagout.dal.model.RawaccountHandledAndAccountType;

import java.util.List;

public interface AnalysisService {

	List<RawaccountHandledAndAccountType> countByNameAndType(Long beginTime,Long endTime);

	List<RawaccountHandledAndAccountType> countByNameAndADSL(Long beginTime,Long endTime);

	List<RawaccountHandledAndAccountType> countByNameAndIP(Long beginTime,Long endTime);

	List<RawaccountHandledAndAccountType> countByNameAndMAC(Long beginTime,Long endTime);

	List<RawaccountHandledAndAccountType> countByTime(String beginTime, String endTime,String accountName,String adslAccountEq,String timeFmort);
}