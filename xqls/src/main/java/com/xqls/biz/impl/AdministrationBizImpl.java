package com.xqls.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.bean.AdministrationBean;
import com.xqls.biz.AdministrationBiz;
import com.xqls.dal.model.Administration;
import com.xqls.service.AdministrationService;
import com.xqls.util.CommonPage;
import com.xqls.util.CommonResult;

@Service
public class AdministrationBizImpl implements AdministrationBiz{
	private static Logger logger = Logger.getLogger(AdministrationBiz.class);
	@Autowired private AdministrationService administrationService;
	
	
	public CommonResult queryAdministration(CommonPage commonPage){
		CommonResult commonResult=new CommonResult();
		try {
			commonPage.setPageData(administrationService.selectByMap(commonPage.pageToMap()));
			commonResult.setIsSuccess(true);
		} catch (Exception e) {
			logger.error("动态操作列表异常",e);
		}
		return commonResult;
	}
	
	public AdministrationBean queryAdministratiobByTableno(String tableno){
		
		
		try {
			return administrationService.selectByTableno(tableno);
		} catch (Exception e) {
			logger.error("单表查询异常",e);
		}
		return null;
	}
	
	public CommonResult updateAdministration(AdministrationBean administrationBean){
		CommonResult commonResult=new CommonResult();
		boolean success=false;
		try {
			success=administrationService.updateAdministration(administrationBean);
		} catch (Exception e) {
			logger.error("动态指标编辑异常",e);
		}
		commonResult.setIsSuccess(success);
		return commonResult;
	}
	
	public CommonResult addFiled(String tablename,String filed, String type) {
		CommonResult commonResult=new CommonResult();
		boolean success=false;
		try {
			success=administrationService.addFiled(tablename,filed, type);
		} catch (Exception e) {
			logger.error("添加字段异常",e);
		}
		commonResult.setIsSuccess(success);
		return commonResult;
	}


	public List<String> conversion(String tablename) {
		List<String> fields = new ArrayList<String>();
		List<String> displayfields=new ArrayList<String>();
		try {
			List<Administration> administrationBeans=administrationService.selectByTablename(tablename);
			for (Administration administration : administrationBeans) {
				String[] display = administration.getDisplayfield().split(",");// 显示字段
				for (int i = 0; i < display.length; i++) {
					fields.add(display[i]);	
				}
			}
			for (String field : fields) {
		        StringBuffer sb = new StringBuffer();
				for(int i = 0;i<field.length();i++){
					char c = field.charAt(i);
					if((c<='z'&&c>='a')||(c<='Z'&&c>='A')){
						sb.append(c);
						
					}
					
					
				}
				displayfields.add(sb.toString());
			}
		} catch (Exception e) {
			logger.error("获取数据库字段异常",e);
		}
		return displayfields;
	}
	
	
	public List<String> fieldalias(String tablename) {
		List<String> fields = new ArrayList<String>();
		List<String> fieldalias=new ArrayList<String>();
		try {
			List<Administration> administrationBeans=administrationService.selectByTablename(tablename);
			for (Administration administration : administrationBeans) {
				String[] display = administration.getDisplayfield().split(",");// 显示字段
				for (int i = 0; i < display.length; i++) {
					fields.add(display[i]);	
				}
			}
			for (String field : fields) {
				
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < field.length(); i++) {
		            if ((field.charAt(i)+"").getBytes().length>1) {
		                sb.append(field.charAt(i));
		            }
		        }
		        
		        fieldalias.add(sb.toString());
			}
		} catch (Exception e) {
			logger.error("获取数据库字段别名异常",e);
		}
		return fieldalias;
	}
	
	
	
	

}
