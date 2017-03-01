package com.skeye.water_fountain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.water_fountain.dal.model.Account;
import com.skeye.water_fountain.dal.model.AccountExample;
import com.skeye.water_fountain.dal.model.AccountExample.Criteria;
import com.skeye.water_fountain.dao.AccountDao;
import com.skeye.water_fountain.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired private AccountDao accountDao;
	
	@Override
	public boolean insertAccount(Account record) {
		boolean isInserted=false;
		if(this.accountDao.insertAccount(record)>0)
		{
			isInserted=true;
		}
		return isInserted;
	}

	@Override
	public Account getAccount(String accountNo) {
		return this.accountDao.getAccount(accountNo);
	}

	
	@Override
	public boolean getAccount(String accountNo,String password) {
		boolean isChecked=false;
		AccountExample example=new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountNoEqualTo(accountNo);
		
		if(password!=null && !password.equals(""))
		{
		   criteria.andPasswordEqualTo(password);
		}
		
		if(this.accountDao.getAccountCount(example)>0)
		{
			isChecked=true;
		}
		return isChecked;
	}
	
	@Override
	public List<Account> getAccountList() {
		AccountExample example=new AccountExample();
		return this.accountDao.getAccountList(example);
	}
}
