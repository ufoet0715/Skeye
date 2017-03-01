package com.skeye.water_fountain.service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skeye.water_fountain.dal.model.DeviceTwo;
import com.skeye.water_fountain.service.DeviceService;
import com.skeye.water_fountain.test.BasicTest;

public class DeviceTest extends BasicTest {
	@Autowired
	private DeviceService deviceService;

	@Test
	public void Test() {
		Map<String, Object> map=new HashMap<String, Object>();
	   //map.put("accountNo", 00000000001);
       List<DeviceTwo> twoList = this.deviceService.getDeviceListByMap(map);
       for (DeviceTwo deviceTwo : twoList) {
		System.out.println(deviceTwo);
	}
       
	}
}
