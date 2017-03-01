package com.skeye.water_fountain.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.water_fountain.dal.model.DeviceState;
import com.skeye.water_fountain.dal.model.DeviceStateExample;
import com.skeye.water_fountain.dal.model.DeviceStateExample.Criteria;
import com.skeye.water_fountain.dal.model.DeviceStateTwo;
import com.skeye.water_fountain.dao.DeviceStateDao;
import com.skeye.water_fountain.service.DeviceStateService;

@Service
public class DeviceStateServiceImpl implements DeviceStateService {
    @Autowired private DeviceStateDao deviceStateDao;
	
	@Override
	public boolean insertDeviceState(DeviceState record) {
		boolean isInserted=false;
		if(this.deviceStateDao.insertDeviceState(record)>0)
		{
			isInserted=true;
		}
		return isInserted;
	}

	@Override
	public Map<String,Object> getDeviceStateList(Map<String,Object> paramMap) {
		Map<String,Object> map=new HashMap<String, Object>();
		List<DeviceStateTwo> twoList=new ArrayList<DeviceStateTwo>();
		DeviceStateExample example=new DeviceStateExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeviceNoEqualTo((String) paramMap.get("deviceNo"));
		List<DeviceState> deviceStateList = this.deviceStateDao.getDeviceStateList(example);
		DeviceStateTwo deviceStateTwo=null;
		for (DeviceState deviceState : deviceStateList) {
			deviceStateTwo=new DeviceStateTwo();
			deviceStateTwo.setRecordNo(deviceState.getRecordNo());
			deviceStateTwo.setDeviceNo(deviceState.getDeviceNo());
			deviceStateTwo.setDeviceState(deviceState.getDeviceState());
			deviceStateTwo.setWaterTemperature(deviceState.getWaterTemperature());
			deviceStateTwo.setTime(deviceState.getTime());
			twoList.add(deviceStateTwo);
		}
		int totalRecord=this.deviceStateDao.countDeviceState(example);
		map.put("list", twoList);
		map.put("totalRecord", totalRecord);
		return map;
	}
}
