package com.skeye.yagout.service;

import com.skeye.yagout.dal.model.Account;
import com.skeye.yagout.util.CommonPage;

import java.util.List;
import java.util.Map;

public interface AccountService {

	int getCountByAccount(String accountName);

	List<Account> getAccountList();
	
	List<Map> getAccountListByPage(CommonPage commonPage);
	
	List<Account> getAccountListByName(String accountName);

	List<Map> getAccountListByLike(String accountName,String adslAccount,Integer rows);

	boolean deleteAccountByList(List<Integer> ids);
}