package com.skeye.water_fountain.biz;

import com.skeye.water_fountain.biz.bean.AccountBean;
import com.skeye.water_fountain.util.CommonPage;
import com.skeye.water_fountain.util.CommonResult;

public interface AccountBiz {
	CommonResult insertAccount(AccountBean accountBean);

	AccountBean getAccount(String accountNo);

	CommonResult getAccount(String accountNo,String password);
	
	void getAccountList(CommonPage commandPage);
}
