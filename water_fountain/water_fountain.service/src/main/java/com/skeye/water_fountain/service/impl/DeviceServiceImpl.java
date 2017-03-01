package com.skeye.water_fountain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.water_fountain.dal.model.Device;
import com.skeye.water_fountain.dal.model.DeviceExample;
import com.skeye.water_fountain.dal.model.DeviceExample.Criteria;
import com.skeye.water_fountain.dal.model.DeviceTwo;
import com.skeye.water_fountain.dao.DeviceDao;
import com.skeye.water_fountain.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceDao deviceDao;

	@Override
	public boolean insertDevice(Device record) {
		boolean isInserted = false;
		if (this.deviceDao.insertDevice(record) > 0) {
			isInserted = true;
		}
		return isInserted;
	}

	@Override
	public Device getDevice(String deviceNo) {
		return this.getDevice(deviceNo);
	}

	@Override
	public boolean getDeviceCount(String deviceNo) {
		boolean isHave=false;
		DeviceExample example = new DeviceExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeviceNoEqualTo(deviceNo);
		if(this.deviceDao.getDeviceCount(example)>0)
		{
			isHave=true;
		}
		return isHave;
	}
	
	@Override
	public List<Device> getDeviceList() {
		DeviceExample example = new DeviceExample();
		return this.deviceDao.getDeviceList(example);
	}

	@Override
	public List<DeviceTwo> getDeviceListByMap(Map<String, Object> map) {
		List<DeviceTwo> twoList = new ArrayList<DeviceTwo>();
		List<Device> deviceList = this.deviceDao.getDeviceListByMap(map);
		DeviceTwo deviceTwo = null;
		for (Device device : deviceList) {
			deviceTwo = new DeviceTwo();
			deviceTwo.setDeviceNo(device.getDeviceNo());
			deviceTwo.setDeviceName(device.getDeviceName());
			deviceTwo.setProductName(device.getProductName());
			deviceTwo.setModel(device.getModel());
			deviceTwo.setProductDate(device.getProductDate());
			twoList.add(deviceTwo);
		}
		return twoList;
	}

	@Override
	public boolean getCountByMap(Map<String, Object> map) {
		boolean isHave = false;
		try {
			if (this.deviceDao.getCountByMap(map) > 0) {
				isHave = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isHave;
	}
}
