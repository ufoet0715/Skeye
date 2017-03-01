package com.yagout.defense.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.dal.dao.DeviceMonitorDao;
import com.yagout.defense.dal.model.DeviceMonitor;
import com.yagout.defense.service.DeviceMonitorService;
@Service
public class DeviceMonitServiceImpl implements DeviceMonitorService{
	
	
	@Autowired
	private DeviceMonitorDao demntDao;
	@Override
	public DeviceMonitor getDemtById(String device_serial) {
		
		return demntDao.getDemtById(device_serial);
	}

	@Override
	public DeviceMonitor getDemtByName(String name) {
		// TODO Auto-generated method stub
		return demntDao.getDemtByName(name);
	}

	@Override
	public boolean saveDeviceMonitor(DeviceMonitor demt) {
		// TODO Auto-generated method stub
		return demntDao.saveDeviceMonitor(demt);
	}

	@Override
	public boolean updateDeviceMonitor(DeviceMonitor demt) {
		// TODO Auto-generated method stub
		return demntDao.updateDeviceMonitor(demt);
	}

	@Override
	public List<DeviceMonitor> selAllDeviceMonitor() {
		// TODO Auto-generated method stub
		return demntDao.selAllDeviceMonitor();
	}
	
}
