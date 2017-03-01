package com.yagout.defense.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.LoginCheckBiz;
import com.yagout.defense.biz.bean.LoginCheckBean;
import com.yagout.defense.dal.model.LoginCheck;
import com.yagout.defense.service.LoginCheckService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.ObjectUtil;

@Service
public class LoginCheckBizImpl implements LoginCheckBiz {

	@Autowired private LoginCheckService loginCheckService;
	
	@Override
	public CommonResult insertData(LoginCheck record) {
		CommonResult commonResult=new CommonResult();
		commonResult.setIsSuccess(this.loginCheckService.insertData(record));
		return commonResult;
	}

	@Override
	public boolean updateData(LoginCheck record) {
		return this.loginCheckService.updateData(record);
	}
	
	@Override
	public CommonResult updateData(LoginCheckBean recordBean) {
		LoginCheck loginCheck = (LoginCheck) ObjectUtil.transfer(recordBean, LoginCheck.class);
		CommonResult commonResult=new CommonResult();
		commonResult.setIsSuccess(this.loginCheckService.updateData(loginCheck));
		return commonResult;
	}

	@Override
	public boolean recoveLoginByList(List<Long> rowIdList) {
		return this.loginCheckService.recoveLoginByList(rowIdList);
	}
	
	@Override
	public int countLoginCheckByExample(LoginCheckBean recordBean) {
		LoginCheck record=(LoginCheck) ObjectUtil.transfer(recordBean, LoginCheck.class);
		return this.loginCheckService.countLoginCheckByExample(record);
	}

	@Override
	public List<LoginCheck> getLoginCheckByName(String userName) {
		return this.loginCheckService.getLoginCheckByName(userName);
	}
	
	@Override
	public List<LoginCheck> getLoginCheckByMac(String mac) {
		return this.loginCheckService.getLoginCheckByMac(mac);
	}

	@Override
	public void getLoginCheckByMap(CommonPage commonPage) {
		commonPage.setPageData(this.loginCheckService.getLoginCheckByMap(commonPage.pageToMap()));
	}

	@Override
	public List<LoginCheck> getLoginCheckForLogin(String userName, String mac) {
		return this.loginCheckService.getLoginCheckForLogin(userName, mac);
	}
}
