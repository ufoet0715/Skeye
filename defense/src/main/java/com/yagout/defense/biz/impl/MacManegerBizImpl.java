package com.yagout.defense.biz.impl;


import com.yagout.defense.biz.MacManegerBiz;
import com.yagout.defense.biz.bean.StationTrustBean;
import com.yagout.defense.util.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Service
public class MacManegerBizImpl implements MacManegerBiz {
	private static Logger logger = Logger.getLogger(MacManegerBizImpl.class);
	@Override
	public void queryByPage(CommonPage commonPage,MacType macType) {
		try {
        	Object bean=BeansUtil.getBean(macType.getServiceClass());//获取到他的service
        	Method method=bean.getClass().getDeclaredMethod("query", commonPage.getClass());
        	@SuppressWarnings("unchecked")
			List<Map<String,Object>> stationTrusts=(List<Map<String, Object>>) method.invoke(bean, commonPage);
        	commonPage.setPageData(ObjectUtil.transferListMap(stationTrusts,StationTrustBean.class));
        }catch (Exception e){
            logger.error("查询"+macType.getTypeName()+"数据异常",e);
        }
	}
	@Override
	public CommonResult batchDelete(List<String> keyList,MacType macType) {
		 CommonResult result=new CommonResult();
	        try {
	        	Object bean=BeansUtil.getBean(macType.getServiceClass());
	        	Method method=bean.getClass().getDeclaredMethod("delete", keyList.getClass());
	            result.setIsSuccess((Boolean) method.invoke(bean, keyList));
	        }catch (Exception e){
	            logger.error("批量删除"+macType.getTypeName()+"异常",e);
	        }
	        return result;
		
	}
	@Override
	public Object queryByPrimaryKey(String primaryKey,MacType macType) {
		Object result=null;
		Object bean=BeansUtil.getBean(macType.getServiceClass());
		try {
			Method method=bean.getClass().getDeclaredMethod("query", primaryKey.getClass());
			result=method.invoke(bean, primaryKey);
		} catch (Exception e) {
			logger.error("根据主键查询"+macType.getTypeName()+"数据异常",e);
		}
		return result;
	}
	
	@Override
	public <V> CommonResult batchInsert(List<V> dataList,MacType macType) {
		CommonResult result=new CommonResult();
		Object bean=BeansUtil.getBean(macType.getServiceClass());
        try {
        	Method method=bean.getClass().getDeclaredMethod("save", dataList.getClass());
            result.setIsSuccess((Boolean) method.invoke(bean, dataList));
        }catch (Exception e){
            logger.error("批量添加"+macType.getTypeName()+"异常",e);
        }
        return result;
	}
	@Override
	public <V> CommonResult batchUpdate(List<V> dataList, MacType macType) {
		CommonResult result=new CommonResult();
		Object bean=BeansUtil.getBean(macType.getServiceClass());
        try {
        	Method method=bean.getClass().getDeclaredMethod("update", dataList.getClass());
            result.setIsSuccess((Boolean) method.invoke(bean, dataList));
        }catch (Exception e){
            logger.error("批量修改"+macType.getTypeName()+"异常",e);
        }
        return result;
	}
	@Override
	public <V> CommonResult deleteByPrimaryKey(V key, MacType macType) {
		CommonResult result=new CommonResult();
		Object bean=BeansUtil.getBean(macType.getServiceClass());
        try {
        	Method method=bean.getClass().getDeclaredMethod("delete", key.getClass());
            result.setIsSuccess((Boolean) method.invoke(bean, key));
        }catch (Exception e){
            logger.error("根据主键删除"+macType.getTypeName()+"异常",e);
        }
        return result;
	}
	@Override
	public <V> CommonResult insert(V data, MacType macType) {
		CommonResult result=new CommonResult();
		Object bean=BeansUtil.getBean(macType.getServiceClass());
        try {
        	Method method=bean.getClass().getDeclaredMethod("save", data.getClass());
            result.setIsSuccess((Boolean) method.invoke(bean, data));
        }catch (Exception e){
            logger.error("添加"+macType.getTypeName()+"异常",e);
        }
        return result;
	}
	@Override
	public <V> CommonResult updateByPrimaryKey(V data, MacType macType) {
		CommonResult result=new CommonResult();
		Object bean=BeansUtil.getBean(macType.getServiceClass());
        try {
        	Method method=bean.getClass().getDeclaredMethod("update", data.getClass());
            result.setIsSuccess((Boolean) method.invoke(bean, data));
        }catch (Exception e){
            logger.error("根据主键修改"+macType.getTypeName()+"异常",e);
        }
        return result;
	}

	@Override
	public Object queryList(MacType macType){
		Object result=null;
		Object bean=BeansUtil.getBean(macType.getServiceClass());
		try {
			Method method=bean.getClass().getDeclaredMethod("query");
			result=method.invoke(bean);
		} catch (Exception e) {
			logger.error("查询"+macType.getTypeName()+"集合数据异常",e);
		}
		return result;
	}
	

}
