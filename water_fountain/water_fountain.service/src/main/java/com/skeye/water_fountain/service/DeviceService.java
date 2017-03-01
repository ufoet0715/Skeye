package com.skeye.water_fountain.service;

import java.util.List;
import java.util.Map;

import com.skeye.water_fountain.dal.model.Device;
import com.skeye.water_fountain.dal.model.DeviceTwo;

public interface DeviceService {
	boolean insertDevice(Device record);

	Device getDevice(String deviceNo);

	boolean getDeviceCount(String deviceNo);
	
	List<Device> getDeviceList();

	List<DeviceTwo> getDeviceListByMap(Map<String,Object> map);

	boolean getCountByMap(Map<String, Object> map);
}
