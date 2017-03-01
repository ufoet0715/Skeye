package com.skeye.water_fountain.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skeye.water_fountain.dal.model.Account;
import com.skeye.water_fountain.service.AccountService;
import com.skeye.water_fountain.test.BasicTest;


public class AccountTest extends BasicTest{
	@Autowired private AccountService accountService;
	
	@Test
	public void test()
	{	 
	    List<Account> accountList = this.accountService.getAccountList();
	    for (Account account : accountList) {
	    	System.out.println(account);
		}
		
	}

}
