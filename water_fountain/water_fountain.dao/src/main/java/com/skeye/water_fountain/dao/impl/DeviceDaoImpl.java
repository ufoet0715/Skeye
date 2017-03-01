package com.skeye.water_fountain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.water_fountain.dal.model.Device;
import com.skeye.water_fountain.dal.model.DeviceExample;
import com.skeye.water_fountain.dal.service.DeviceMapper;
import com.skeye.water_fountain.dao.DeviceDao;

@Repository
public class DeviceDaoImpl implements DeviceDao {
    @Autowired private DeviceMapper deviceMapper;
	
	@Override
	public int insertDevice(Device record) {
		return this.deviceMapper.insert(record);
	}

	@Override
	public Device getDevice(String deviceNo) {
		return this.deviceMapper.selectByPrimaryKey(deviceNo);
	}

	@Override
	public int getDeviceCount(DeviceExample example) {
		return this.deviceMapper.countByExample(example);
	}
	
	@Override
	public List<Device> getDeviceList(DeviceExample example) {
		return this.deviceMapper.selectByExample(example);
	}

	@Override
	public List<Device> getDeviceListByMap(Map<String, Object> map) {
		return this.deviceMapper.getDeviceListByMap(map);
	}

	@Override
	public int getCountByMap(Map<String, Object> map) {
		return this.deviceMapper.getCountByMap(map);
	}
}
