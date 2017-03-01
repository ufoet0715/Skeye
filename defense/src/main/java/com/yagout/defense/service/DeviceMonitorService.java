package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.DeviceMonitor;

public interface DeviceMonitorService {
	public DeviceMonitor getDemtById(String device_serial);
	public DeviceMonitor getDemtByName(String name);
	public List<DeviceMonitor> selAllDeviceMonitor();
	
	public boolean saveDeviceMonitor(DeviceMonitor demt);
	public boolean updateDeviceMonitor(DeviceMonitor demt);
	
}
