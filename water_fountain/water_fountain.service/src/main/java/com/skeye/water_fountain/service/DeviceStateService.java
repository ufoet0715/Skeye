package com.skeye.water_fountain.service;

import java.util.Map;

import com.skeye.water_fountain.dal.model.DeviceState;

public interface DeviceStateService {
	boolean insertDeviceState(DeviceState record);

	Map<String,Object> getDeviceStateList(Map<String,Object> map);
}
