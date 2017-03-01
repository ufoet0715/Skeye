package com.skeye.water_fountain.biz;

import com.skeye.water_fountain.biz.bean.AccountToDeviceBean;
import com.skeye.water_fountain.biz.bean.DeviceBean;
import com.skeye.water_fountain.util.CommonPage;
import com.skeye.water_fountain.util.CommonResult;

public interface DeviceBiz {
	CommonResult insertDevice(DeviceBean deviceBean);

	DeviceBean getDevice(CommonPage commonPage);
	
	void getDeviceListByMap(CommonPage commmonPage);

	CommonResult getCountByMap(AccountToDeviceBean accountToDeviceBean);
}
