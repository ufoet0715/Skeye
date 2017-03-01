package com.skeye.water_fountain.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.water_fountain.biz.DeviceStateBiz;
import com.skeye.water_fountain.biz.bean.DeviceStateBean;
import com.skeye.water_fountain.dal.model.DeviceState;
import com.skeye.water_fountain.dal.model.DeviceStateTwo;
import com.skeye.water_fountain.service.DeviceService;
import com.skeye.water_fountain.service.DeviceStateService;
import com.skeye.water_fountain.util.CommonPage;
import com.skeye.water_fountain.util.CommonResult;

@Service
public class DeviceStateBizImpl implements DeviceStateBiz {
	@Autowired private DeviceService deviceServer;
    @Autowired private DeviceStateService deviceStateService;
	
	@Override
	public CommonResult insertDeviceState(DeviceStateBean deviceStateBean) {
		DeviceState deviceState=new DeviceState();
		deviceState.setRecordNo(deviceStateBean.getRecordNo());
		deviceState.setDeviceNo(deviceStateBean.getDeviceNo());
		deviceState.setDeviceState(deviceStateBean.getDeviceState());
		deviceState.setWaterTemperature(deviceStateBean.getWaterTemperature());
		deviceState.setTime(deviceStateBean.getTime());
		CommonResult commonResult=new CommonResult();
		commonResult.setIsSuccess(this.deviceStateService.insertDeviceState(deviceState));
		return commonResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getDeviceStateList(CommonPage commonPage) {
		Map<String, Object> map = this.deviceStateService.getDeviceStateList(commonPage.pageToMap());
		List<DeviceStateTwo> twoList=(List<DeviceStateTwo>) map.get("list");
		int totalRecord=(Integer) map.get("totalRecord");
		int totalPage=totalRecord % commonPage.getPageSize() == 0 ? totalRecord / commonPage.getPageSize()
				: totalRecord / commonPage.getPageSize() + 1;
		commonPage.setTotalRecord(totalRecord);
		commonPage.setTotalPage(totalPage);
        commonPage.setData(twoList);
	}

	@Override
	public CommonResult saveDeviceState(DeviceStateBean deviceStateBean) {
		CommonResult commonResult=new CommonResult();
		if(this.deviceServer.getDeviceCount(deviceStateBean.getDeviceNo()))
		{
			DeviceState deviceState=new DeviceState();
			deviceState.setRecordNo(deviceStateBean.getRecordNo());
			deviceState.setDeviceNo(deviceStateBean.getDeviceNo());
			deviceState.setDeviceState(deviceStateBean.getDeviceState());
			deviceState.setWaterTemperature(deviceStateBean.getWaterTemperature());
			deviceState.setTime(deviceStateBean.getTime());
			commonResult.setIsSuccess(this.deviceStateService.insertDeviceState(deviceState));
		}
		else
		{
			commonResult.setIsSuccess(false);
		}
		return commonResult;
	}

	
}
