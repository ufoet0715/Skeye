package com.skeye.yagout.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.skeye.yagout.biz.YagoutAccountBiz;
import com.skeye.yagout.service.AccountService;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;
import com.skeye.yagout.util.EncodeUtil;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class YagoutAccountBizImpl implements YagoutAccountBiz {
	@Autowired private AccountService accountService;
	private static Logger logger = Logger.getLogger(YagoutUsersBizImpl.class);
	@Autowired  private LogService logService;
	@Override
	public void queryAccountByPage(CommonPage commonPage) {
        List<Map> accountList = this.accountService.getAccountListByPage(commonPage);
        for (Map map : accountList) {
			map.put("Password", EncodeUtil.doCharsEncode((String) map.get("Password")));
		}
        commonPage.setPageData(accountList);
	}

	@Override
	public CommonResult queryAccountByList(String accountName, String adslAccount, Integer rows) {
		CommonResult result=new CommonResult();
		result.setData(accountService.getAccountListByLike(accountName, adslAccount, rows));
		result.setIsSuccess(true);
		return result;
	}

	@Override
	public CommonResult deleteAccountByList( List<Integer> ids){
		CommonResult result=new CommonResult();
		boolean isSuccess=false;
		try {
			  isSuccess=accountService.deleteAccountByList(ids);
		}catch (Exception e){
			logger.error("删除账户信息异常",e);
		}
		Subject subject = SecurityUtils.getSubject();
		logService.addLog((String) subject.getPrincipal(),"删除账户信息",isSuccess,"删除的账户信息编号为:"+ JSONObject.toJSONString(ids));
		result.setIsSuccess(isSuccess);
		return result;
	}

}
