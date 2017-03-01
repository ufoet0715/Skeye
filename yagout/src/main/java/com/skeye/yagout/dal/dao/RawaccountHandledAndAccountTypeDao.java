package com.skeye.yagout.dal.dao;

import com.skeye.yagout.dal.model.RawaccountHandledAndAccountType;

import java.util.List;
import java.util.Map;

public interface RawaccountHandledAndAccountTypeDao {
    public List<RawaccountHandledAndAccountType> countByNameAndType(Map<String, Object> map);


    public List<RawaccountHandledAndAccountType> countByNameAndADSL(Map<String, Object> map);


    public List<RawaccountHandledAndAccountType> countByNameAndIP(Map<String, Object> map);


    public List<RawaccountHandledAndAccountType> countByNameAndMAC(Map<String, Object> map);


    public List<RawaccountHandledAndAccountType> countByTime(Map<String, Object> map);
}
