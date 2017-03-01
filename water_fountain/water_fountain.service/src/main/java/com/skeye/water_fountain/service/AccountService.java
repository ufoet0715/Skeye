package com.skeye.water_fountain.service;

import java.util.List;

import com.skeye.water_fountain.dal.model.Account;


public interface AccountService {
	boolean insertAccount(Account record);

	Account getAccount(String accountNo);

	boolean getAccount(String accountNo,String password);
	
	List<Account> getAccountList();
}
