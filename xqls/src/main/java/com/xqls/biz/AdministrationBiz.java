package com.xqls.biz;

import java.util.List;

import com.xqls.bean.AdministrationBean;
import com.xqls.util.CommonPage;
import com.xqls.util.CommonResult;

public interface AdministrationBiz {
	
	
	public CommonResult queryAdministration(CommonPage commonPage);
	
	public AdministrationBean queryAdministratiobByTableno(String tableno);
	
	public CommonResult updateAdministration(AdministrationBean administrationBean);
	public CommonResult addFiled(String tablename,String filed, String type);
	
	/**
	 * commonpage获取指定数据库字段名
	 * @param tablename    输入数据库表名
	 * @return
	 */
	public List<String> conversion(String tablename) ;
	
	/**
	 * commonpage获取指定数据库字段中文名
	 * @param tablename  数据库表名
	 * @return
	 */
	public List<String> fieldalias(String tablename) ;
	
		
	
}
