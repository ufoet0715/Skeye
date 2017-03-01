package com.skeye.water_fountain.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.water_fountain.dal.model.AccountToDevice;
import com.skeye.water_fountain.dal.model.AccountToDeviceTwo;
import com.skeye.water_fountain.dao.AccountToDeviceDao;
import com.skeye.water_fountain.service.AccountToDeviceService;

@Service
public class AccountToDeviceServiceImpl implements AccountToDeviceService {
    @Autowired private AccountToDeviceDao accountToDeviceDao;
	
	@Override
	public List<AccountToDeviceTwo> getAccountListByMap(Map<String,Object> map){
		List<AccountToDeviceTwo> twoList=new ArrayList<AccountToDeviceTwo>();
		AccountToDeviceTwo accountToDeviceTwo=null;
		SimpleDateFormat simpleDateFormat=null;
		List<AccountToDevice> dataList = this.accountToDeviceDao.getAccountListByMap(map);
		for (AccountToDevice accountToDevice : dataList) {
			accountToDeviceTwo=new AccountToDeviceTwo();
			
			accountToDeviceTwo.setId(accountToDevice.getId());
			accountToDeviceTwo.setAccount(accountToDevice.getAccount());
		    accountToDeviceTwo.setDevice(accountToDevice.getDevice());
		    
		    simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    String time=simpleDateFormat.format(accountToDevice.getTime());
		    
			accountToDeviceTwo.setTime(time);
			
			twoList.add(accountToDeviceTwo);
		}
		return twoList;
	}

	@Override
	public List<AccountToDeviceTwo> getDeviceListByMap(Map<String,Object> map) {
		List<AccountToDeviceTwo> twoList=new ArrayList<AccountToDeviceTwo>();
		AccountToDeviceTwo accountToDeviceTwo=null;
		SimpleDateFormat simpleDateFormat=null;
		List<AccountToDevice> dataList = this.accountToDeviceDao.getDeviceListByMap(map);
		for (AccountToDevice accountToDevice : dataList) {
			accountToDeviceTwo=new AccountToDeviceTwo();
			
			accountToDeviceTwo.setId(accountToDevice.getId());
			accountToDeviceTwo.setAccount(accountToDevice.getAccount());
		    accountToDeviceTwo.setDevice(accountToDevice.getDevice()); 
		    
		    simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
		    String productTime=simpleDateFormat.format(accountToDevice.getDevice().getProductDate());
			
		    simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    String time=simpleDateFormat.format(accountToDevice.getTime());
		    
			accountToDeviceTwo.setProductTime(productTime);
			accountToDeviceTwo.setTime(time);
			
			twoList.add(accountToDeviceTwo);
		}
		return twoList;
	}
}
