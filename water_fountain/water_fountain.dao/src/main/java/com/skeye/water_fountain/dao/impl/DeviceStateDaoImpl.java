package com.skeye.water_fountain.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.water_fountain.dal.model.DeviceState;
import com.skeye.water_fountain.dal.model.DeviceStateExample;
import com.skeye.water_fountain.dal.service.DeviceStateMapper;
import com.skeye.water_fountain.dao.DeviceStateDao;

@Repository
public class DeviceStateDaoImpl implements DeviceStateDao {
    @Autowired private DeviceStateMapper deviceStateMapper;
	
	@Override
	public int insertDeviceState(DeviceState record) {
		return this.deviceStateMapper.insert(record);
	}

	@Override
	public int countDeviceState(DeviceStateExample example) {
		return this.deviceStateMapper.countByExample(example);
	}
	
	@Override
	public List<DeviceState> getDeviceStateList(DeviceStateExample example) {
		return this.deviceStateMapper.selectByExample(example);
	}
}
