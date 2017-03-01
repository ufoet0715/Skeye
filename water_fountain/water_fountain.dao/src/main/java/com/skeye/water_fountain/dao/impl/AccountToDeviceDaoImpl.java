package com.skeye.water_fountain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.water_fountain.dal.model.AccountToDevice;
import com.skeye.water_fountain.dal.service.AccountToDeviceMapper;
import com.skeye.water_fountain.dao.AccountToDeviceDao;

@Repository
public class AccountToDeviceDaoImpl implements AccountToDeviceDao {
    @Autowired private AccountToDeviceMapper accountToDeviceMapper;
	
	@Override
	public List<AccountToDevice> getAccountListByMap(Map<String, Object> map) {
		return this.accountToDeviceMapper.getAccountListByMap(map);
	}

	@Override
	public List<AccountToDevice> getDeviceListByMap(Map<String, Object> map) {
		return this.accountToDeviceMapper.getDeviceListByMap(map);
	}

}
