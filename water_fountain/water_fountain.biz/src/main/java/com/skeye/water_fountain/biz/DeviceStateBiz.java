package com.skeye.water_fountain.biz;

import com.skeye.water_fountain.biz.bean.DeviceStateBean;
import com.skeye.water_fountain.util.CommonPage;
import com.skeye.water_fountain.util.CommonResult;

public interface DeviceStateBiz {
	CommonResult insertDeviceState(DeviceStateBean deviceStateBean);
	
	void getDeviceStateList(CommonPage commonPage);
	
	CommonResult saveDeviceState(DeviceStateBean deviceStateBean);
}
