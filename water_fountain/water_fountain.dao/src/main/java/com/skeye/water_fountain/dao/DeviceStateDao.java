package com.skeye.water_fountain.dao;

import java.util.List;

import com.skeye.water_fountain.dal.model.DeviceState;
import com.skeye.water_fountain.dal.model.DeviceStateExample;

public interface DeviceStateDao {
	int insertDeviceState (DeviceState record);

	int countDeviceState(DeviceStateExample example);
	
	List<DeviceState> getDeviceStateList(DeviceStateExample example);
}
