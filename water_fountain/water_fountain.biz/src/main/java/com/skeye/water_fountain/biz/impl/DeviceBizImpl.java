package com.skeye.water_fountain.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.water_fountain.biz.DeviceBiz;
import com.skeye.water_fountain.biz.bean.AccountToDeviceBean;
import com.skeye.water_fountain.biz.bean.DeviceBean;
import com.skeye.water_fountain.dal.model.Device;
import com.skeye.water_fountain.service.DeviceService;
import com.skeye.water_fountain.util.CommonPage;
import com.skeye.water_fountain.util.CommonResult;

@Service
public class DeviceBizImpl implements DeviceBiz {
    @Autowired private DeviceService deviceService;
	
	@Override
	public CommonResult insertDevice(DeviceBean deviceBean) {
		CommonResult commonResult=new CommonResult();
		Device record=new Device();
		record.setDeviceNo(deviceBean.getDeviceNo());
		record.setDeviceName(deviceBean.getDeviceName());
		record.setProductName(deviceBean.getProductName());
		record.setModel(deviceBean.getModel());
		record.setProductDate(deviceBean.getProductDate());
		
		commonResult.setIsSuccess(this.deviceService.insertDevice(record));
		return commonResult;
	}

	@Override
	public DeviceBean getDevice(CommonPage commonPage) {
		String deviceNo=(String) commonPage.pageToMap().get("deviceNo");
		Device device = this.deviceService.getDevice(deviceNo);
		DeviceBean deviceBean=new DeviceBean();
		deviceBean.setDeviceNo(deviceNo);
		deviceBean.setDeviceName(device.getDeviceName());
		deviceBean.setProductName(device.getProductName());
		deviceBean.setModel(device.getModel());
		deviceBean.setProductDate(device.getProductDate());
		return deviceBean;
	}

	@Override
	public void getDeviceListByMap(CommonPage commonPage) {
		commonPage.setData(this.deviceService.getDeviceListByMap(commonPage.pageToMap()));
	}

	@Override
	public CommonResult getCountByMap(AccountToDeviceBean accountToDeviceBean) {		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("accountNo", accountToDeviceBean.getAccountNo());
		map.put("deviceNo", accountToDeviceBean.getDeviceNo());
		map.put("deviceName", accountToDeviceBean.getDeviceName());
		map.put("productName", accountToDeviceBean.getProductName());
		map.put("model", accountToDeviceBean.getModel());
		map.put("productDate", accountToDeviceBean.getProductDate());
		
		CommonResult commonResult=new CommonResult();
		commonResult.setIsSuccess(this.deviceService.getCountByMap(map));
		return commonResult;
	}
}
