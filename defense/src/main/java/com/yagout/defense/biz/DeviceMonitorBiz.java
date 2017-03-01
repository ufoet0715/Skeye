package com.yagout.defense.biz;

import java.util.List;

import com.yagout.defense.biz.bean.DeviceMonitorBean;
import com.yagout.defense.dal.model.DeviceMonitor;
import com.yagout.defense.util.CommonResult;

public interface DeviceMonitorBiz {
	
	
	public DeviceMonitor getDeviceMonitorById(String deviceSerial);
	public CommonResult updateDeviceMonitor(DeviceMonitorBean bean);
	public List<DeviceMonitorBean> queryAllDeviceMonitor();
}
