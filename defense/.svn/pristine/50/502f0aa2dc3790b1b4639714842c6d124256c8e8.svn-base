package com.yagout.defense.service.impl;

import com.yagout.defense.dal.dao.UpdateDao;
import com.yagout.defense.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    UpdateDao updateDao;
    @Override
    public boolean sqlUpdate(String sql) {
        return updateDao.sqlUpdate(sql);
    }
}
