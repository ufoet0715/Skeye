package com.skeye.water_fountain.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.water_fountain.biz.AccountToDeviceBiz;
import com.skeye.water_fountain.service.AccountToDeviceService;
import com.skeye.water_fountain.util.CommonPage;

@Service
public class AccountToDeviceBizImpl implements AccountToDeviceBiz {
    @Autowired private AccountToDeviceService accountToDeviceService;
	
	@Override
	public void getAccountListByMap(CommonPage commonPage) {
		commonPage.setData(this.accountToDeviceService.getAccountListByMap(commonPage.pageToMap()));
	}

	@Override
	public void getDeviceListByMap(CommonPage commonPage) {
		commonPage.setData(this.accountToDeviceService.getDeviceListByMap(commonPage.pageToMap()));
	}
}
