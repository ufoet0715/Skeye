package com.skeye.water_fountain.service;

import java.util.List;
import java.util.Map;

import com.skeye.water_fountain.dal.model.AccountToDeviceTwo;

public interface AccountToDeviceService {
	List<AccountToDeviceTwo> getAccountListByMap(Map<String,Object> map);

	List<AccountToDeviceTwo> getDeviceListByMap(Map<String,Object> map);
}
