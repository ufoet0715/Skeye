package com.skeye.water_fountain.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.water_fountain.biz.AccountBiz;
import com.skeye.water_fountain.biz.bean.AccountBean;
import com.skeye.water_fountain.dal.model.Account;
import com.skeye.water_fountain.service.AccountService;
import com.skeye.water_fountain.util.CommonPage;
import com.skeye.water_fountain.util.CommonResult;
import com.skeye.water_fountain.util.ObjectUtil;

@Service
public class AccountBizImpl implements AccountBiz {
    @Autowired private AccountService accountService;
	
	@Override
	public CommonResult insertAccount(AccountBean accountBean) {
		CommonResult commonResult=new CommonResult();
		Account account=new Account();
		account.setAccountNo(accountBean.getAccountNo());
		account.setAccountName(accountBean.getAccountName());
		account.setPassword(accountBean.getPassword());
		account.setTelephone(accountBean.getTelephone());
		commonResult.setIsSuccess(this.accountService.insertAccount(account));
        return commonResult;
	}
	
	public CommonResult getAccount(String accountNo,String password) {
		CommonResult commonResult=new CommonResult();
		commonResult.setIsSuccess(this.accountService.getAccount(accountNo, password));
		return commonResult;
	}
	
	@Override
	public AccountBean getAccount(String accountNo) {
		Account account = this.accountService.getAccount(accountNo);
		AccountBean accountBean=null;
		if(account!=null)
		{
			accountBean = (AccountBean) ObjectUtil.transfer(account, AccountBean.class);
		}
        return accountBean;
	}

	@Override
	public void getAccountList(CommonPage commandPage) {
		// TODO Auto-generated method stub
		
	}

}
