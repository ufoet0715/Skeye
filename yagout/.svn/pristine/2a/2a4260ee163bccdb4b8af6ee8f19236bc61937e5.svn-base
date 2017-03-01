package com.skeye.yagout.dal.dao.mybatis;

import com.skeye.yagout.dal.dao.RawaccountHandledAndAccountTypeDao;
import com.skeye.yagout.dal.model.RawaccountHandledAndAccountType;
import com.skeye.yagout.dal.service.RawaccountHandledAndAccountTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RawaccountHandledAndAccountTypeDaoImpl implements RawaccountHandledAndAccountTypeDao {
    @Autowired
    private RawaccountHandledAndAccountTypeMapper rawaccountHandledAndAccountTypeMapper;

    @Override
    public List<RawaccountHandledAndAccountType> countByTime(Map<String, Object> map) {
        return this.rawaccountHandledAndAccountTypeMapper.countByTime(map);
    }

    @Override
    public List<RawaccountHandledAndAccountType> countByNameAndType(Map<String, Object> map) {
        return this.rawaccountHandledAndAccountTypeMapper.countByNameAndType(map);
    }


    @Override
    public List<RawaccountHandledAndAccountType> countByNameAndADSL(Map<String, Object> map) {
        return this.rawaccountHandledAndAccountTypeMapper.countByNameAndADSL(map);
    }


    @Override
    public List<RawaccountHandledAndAccountType> countByNameAndIP(Map<String, Object> map) {
        return this.rawaccountHandledAndAccountTypeMapper.countByNameAndIP(map);
    }


    @Override
    public List<RawaccountHandledAndAccountType> countByNameAndMAC(Map<String, Object> map) {
        return this.rawaccountHandledAndAccountTypeMapper.countByNameAndMAC(map);
    }


}
