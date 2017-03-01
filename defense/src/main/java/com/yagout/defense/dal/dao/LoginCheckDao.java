package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.LoginCheck;
import com.yagout.defense.dal.model.LoginCheckExample;

public interface LoginCheckDao {
	
    boolean insertData(LoginCheck record);
    
    boolean updateData(LoginCheck record);
    
    boolean recoveLoginByList(List<Long> rowIdList);
    
    List<LoginCheck> getLoginCheckByExample(LoginCheckExample example);
    
    List<LoginCheck> getLoginCheckByMap(Map<String,Object> map);
    
    List<LoginCheck> getLoginCheckForLogin(Map<String,Object> map);   
}
