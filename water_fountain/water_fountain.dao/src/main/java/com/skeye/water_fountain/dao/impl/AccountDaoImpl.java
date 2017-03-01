package com.skeye.water_fountain.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.water_fountain.dal.model.Account;
import com.skeye.water_fountain.dal.model.AccountExample;
import com.skeye.water_fountain.dal.service.AccountMapper;
import com.skeye.water_fountain.dao.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired private AccountMapper accountMapper;
	
	@Override
	public int insertAccount(Account record) {
		return this.accountMapper.insert(record);
	}

	@Override
	public Account getAccount(String accountNo) {
		return this.accountMapper.selectByPrimaryKey(accountNo);
	}

	@Override
	public int getAccountCount(AccountExample example) {
		return this.accountMapper.countByExample(example);
	}
	
	@Override
	public List<Account> getAccountList(AccountExample example) {
		return this.accountMapper.selectByExample(example);
	}
}
