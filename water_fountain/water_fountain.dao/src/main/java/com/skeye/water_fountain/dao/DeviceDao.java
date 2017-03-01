package com.skeye.water_fountain.dao;

import java.util.List;
import java.util.Map;

import com.skeye.water_fountain.dal.model.Device;
import com.skeye.water_fountain.dal.model.DeviceExample;

public interface DeviceDao {
	int insertDevice(Device record);

	Device getDevice(String deviceNo);

	int getDeviceCount(DeviceExample example);
	
	List<Device> getDeviceList(DeviceExample example);

	List<Device> getDeviceListByMap(Map<String, Object> map);

	int getCountByMap(Map<String, Object> map);
}
