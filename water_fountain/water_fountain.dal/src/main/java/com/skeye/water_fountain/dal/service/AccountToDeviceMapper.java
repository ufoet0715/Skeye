package com.skeye.water_fountain.dal.service;

import java.util.List;
import java.util.Map;

import com.skeye.water_fountain.dal.model.AccountToDevice;

public interface AccountToDeviceMapper {
    List<AccountToDevice> getAccountListByMap(Map<String, Object> map);
    
    List<AccountToDevice> getDeviceListByMap(Map<String, Object> map);
}
