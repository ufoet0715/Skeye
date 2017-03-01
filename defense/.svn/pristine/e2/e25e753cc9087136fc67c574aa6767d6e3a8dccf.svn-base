package com.yagout.defense.biz;

import java.util.List;

import com.yagout.defense.biz.bean.LoginCheckBean;
import com.yagout.defense.dal.model.LoginCheck;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;

public interface LoginCheckBiz {
	
    CommonResult insertData(LoginCheck record);
    
    boolean updateData(LoginCheck record);
    
    CommonResult updateData(LoginCheckBean recordBean);
    
    boolean recoveLoginByList(List<Long> rowIdList);
    
    int countLoginCheckByExample(LoginCheckBean recordBean);
    
    List<LoginCheck> getLoginCheckByName(String userName);
    
    List<LoginCheck> getLoginCheckByMac(String mac);
    
    void getLoginCheckByMap(CommonPage commonPage);
    
    List<LoginCheck> getLoginCheckForLogin(String userName,String mac);
}
