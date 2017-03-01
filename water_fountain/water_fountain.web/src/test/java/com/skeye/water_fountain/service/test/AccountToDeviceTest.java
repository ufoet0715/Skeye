package com.skeye.water_fountain.service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skeye.water_fountain.dal.model.AccountToDeviceTwo;
import com.skeye.water_fountain.service.AccountToDeviceService;
import com.skeye.water_fountain.test.BasicTest;

public class AccountToDeviceTest extends BasicTest{
    @Autowired private AccountToDeviceService accountToDeviceService;
    
    @Test
    public void Test()
    {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("deviceNo", "0000000001");
    	map.put("deviceState", "加热");
    	map.put("waterTemperature", 20);
    	
		List<AccountToDeviceTwo> dataList=this.accountToDeviceService.getDeviceListByMap(map);
		
    	for (AccountToDeviceTwo accountToDeviceTwo : dataList) {
    		System.out.println(accountToDeviceTwo);
		}
    }
}
    
