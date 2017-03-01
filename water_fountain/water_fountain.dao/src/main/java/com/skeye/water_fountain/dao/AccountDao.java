package com.skeye.water_fountain.dao;

import java.util.List;

import com.skeye.water_fountain.dal.model.Account;
import com.skeye.water_fountain.dal.model.AccountExample;

public interface AccountDao {
	int insertAccount(Account record);
    
	Account getAccount(String accountNo);
    
	int getAccountCount(AccountExample example);
	
	List<Account> getAccountList(AccountExample example);
}
