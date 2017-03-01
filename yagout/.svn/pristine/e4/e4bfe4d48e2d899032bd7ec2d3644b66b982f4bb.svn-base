package com.skeye.yagout.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.yagout.dal.dao.AccountTwoDao;
import com.skeye.yagout.dal.model.AccountTwo;
import com.skeye.yagout.service.AccountTwoService;

@Service
public class AccountTwoServiceImpl implements AccountTwoService {
	@Autowired private AccountTwoDao accountTwoDao;
	
    @Override
	public List<AccountTwo> getAll() {
		return this.accountTwoDao.getAll();
	}

}
