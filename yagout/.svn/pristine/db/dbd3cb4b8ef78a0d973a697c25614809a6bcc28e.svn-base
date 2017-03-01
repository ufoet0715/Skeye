package com.skeye.yagout.controller;

import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.skeye.yagout.dal.model.AccountTwo;
import com.skeye.yagout.dal.model.DailinfoHandled;
import com.skeye.yagout.dal.model.RawaccountHandledTwo;
import com.skeye.yagout.service.AccountTwoService;
import com.skeye.yagout.service.DailinfoHandledService;
import com.skeye.yagout.service.LogService;
import com.skeye.yagout.service.RawaccountHandledTwoService;
import com.skeye.yagout.util.POIUtil;
import com.skeye.yagout.util.EncodeUtil;

import java.util.UUID;

@Controller
@RequestMapping("/poi")
public class POIControl {
	@Autowired
	private AccountTwoService accountTwoService;
	@Autowired
	private DailinfoHandledService dailinfoHandledService;
	@Autowired
	private RawaccountHandledTwoService rawaccountHandledTwoService;
	private static Logger logger = Logger.getLogger(POIUtil.class);
	@Autowired  private LogService logService;
	@SuppressWarnings("rawtypes")
	@RequestMapping("/account")
	public void createAccountExcel(HttpServletResponse response) {
		boolean success=false;
		try {
			String[] propertiesName = { "编号", "账号名", "密码", "账号类型", "次数", "ADSL账号", "MAC地址", "IP地址", "时间", "CapIP", "Virtual ID", "端口" };
			Class targetClass=AccountTwo.class;
			List<AccountTwo> accountTwoList = this.accountTwoService.getAll();
            for(AccountTwo accountTwo:accountTwoList)
			{
                accountTwo.setPassword(EncodeUtil.doCharsEncode(accountTwo.getPassword()));
			}
			byte[] bytes = POIUtil.doPOI("账户信息", propertiesName, targetClass, accountTwoList);
			 toResponse(response,bytes);
			success=true;
		}catch (Exception e){
			logger.error("createAccountExcelError",e);
		}
		Subject subject = SecurityUtils.getSubject();
		logService.addLog((String) subject.getPrincipal(),"excel导出",success,"用户名为:"+ subject.getPrincipal()+"导出账户信息");
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/dailinfoHandled")
	public void createDailinfoHandledExcel(HttpServletResponse response) {
		String[] propertiesName = { "编号", "ADSL账号名称", "ADSL账号密码", "时间", "IP地址", "会话编号", "账号状态", "MAC地址" };
		boolean success=false;
		try {
		Class targetClass=DailinfoHandled.class;
		List<DailinfoHandled> dailinfoHandledList = this.dailinfoHandledService.getDailinfoHandledList();
		byte[] bytes =POIUtil.doPOI("ADSL账户信息", propertiesName, targetClass, dailinfoHandledList);
		toResponse(response,bytes);
		success=true;
		}catch (Exception e){
			logger.error("createAccountExcelError",e);
		}
		Subject subject = SecurityUtils.getSubject();
		logService.addLog((String) subject.getPrincipal(),"excel导出",success,"用户名为:"+ subject.getPrincipal()+"导出ADSL账户信息");
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/rawaccountHandled")
	public void createRawaccountHandled(HttpServletResponse response) {
		String[] propertiesName = { "编号", "账号名称", "账号密码", "账号类型", "ADSL账号", "MAC地址", "IP地址", "时间" };
		boolean success=false;
		try {
		Class targetClass=RawaccountHandledTwo.class;
		List<RawaccountHandledTwo> rawaccountHandledTwoList = this.rawaccountHandledTwoService.getAll();
        for(RawaccountHandledTwo rawaccountHandTwo:rawaccountHandledTwoList)
			{
                rawaccountHandTwo.setPassword(EncodeUtil.doCharsEncode(rawaccountHandTwo.getPassword()));
			}
			byte[] bytes =	POIUtil.doPOI("账号流水信息", propertiesName, targetClass, rawaccountHandledTwoList);
			toResponse(response,bytes);
			success=true;
		}catch (Exception e){
			logger.error("createAccountExcelError",e);
		}
		Subject subject = SecurityUtils.getSubject();
		logService.addLog((String) subject.getPrincipal(),"excel导出",success,"用户名为:"+ subject.getPrincipal()+"导出账号流水信息");
	}


	private  void toResponse(HttpServletResponse response,byte[] bytes ) throws  Exception{
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;filename=" + UUID.randomUUID() + ".xls");
		response.setContentLength(bytes.length);
		response.getOutputStream().write(bytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
}
