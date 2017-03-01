package com.skeye.water_fountain.dao;

import java.util.List;
import java.util.Map;

import com.skeye.water_fountain.dal.model.AccountToDevice;

public interface AccountToDeviceDao {
	public List<AccountToDevice> getAccountListByMap(Map<String, Object> map);

	public List<AccountToDevice> getDeviceListByMap(Map<String, Object> map);
}
