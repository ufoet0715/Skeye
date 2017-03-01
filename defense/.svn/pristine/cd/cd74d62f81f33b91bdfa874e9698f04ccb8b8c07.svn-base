package com.yagout.defense.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.DeviceMonitorDao;
import com.yagout.defense.dal.model.DeviceMonitor;
import com.yagout.defense.dal.model.DeviceMonitorExample;
import com.yagout.defense.dal.service.DeviceMonitorMapper;
@Repository
public class DeviceMonitDaoImpl implements DeviceMonitorDao{
	@Autowired
	private DeviceMonitorMapper demtmapper;
	@Override
	public DeviceMonitor getDemtById(String device_serial) {
		
		return demtmapper.selectByPrimaryKey(device_serial);
	}

	@Override
	public DeviceMonitor getDemtByName(String name) {
		DeviceMonitorExample example = new DeviceMonitorExample();
		example.createCriteria().andNameEqualTo(name);
		List<DeviceMonitor> demts = demtmapper.selectByExample(example);
		if(demts!=null&&demts.size()>0)
			return demts.get(0);
		return null;
	}

	@Override
	public boolean saveDeviceMonitor(DeviceMonitor demt) {
		int rows = demtmapper.insert(demt);
		return rows>0;
	}

	@Override
	public boolean updateDeviceMonitor(DeviceMonitor demt) {
		int rows = demtmapper.updateByPrimaryKey(demt);
		return rows>0;
	}

	@Override
	public int deleteDeviceMonitor(DeviceMonitorExample example) {
		// TODO Auto-generated method stub
		return demtmapper.deleteByExample(example);
	}

	@Override
	public List<DeviceMonitor> selAllDeviceMonitor() {
		
		return demtmapper.selAllDeviceMonitor();
	}
	
}
