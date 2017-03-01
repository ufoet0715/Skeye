package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.LoginCheck;

public interface LoginCheckService {
	
    boolean insertData(LoginCheck record);
    
    boolean updateData(LoginCheck record);
    
    boolean recoveLoginByList(List<Long> rowIdList);
    
    int countLoginCheckByExample(LoginCheck record);

    List<LoginCheck> getLoginCheckByName(String userName);
    
    List<LoginCheck> getLoginCheckByMac(String mac);
    
    List<LoginCheck> getLoginCheckByMap(Map<String,Object> map);
    
    List<LoginCheck> getLoginCheckForLogin(String userName,String mac);
}
