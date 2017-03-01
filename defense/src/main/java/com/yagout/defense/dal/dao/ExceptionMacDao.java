package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ExceptionMac;

public interface ExceptionMacDao {
	public List<Map<String,Object>> getExceptionMacByMap(Map<String, Object> map);
	
	public int deleteExceptionMacs(List<String> macs);
	
	public int saveExceptionMacs(List<ExceptionMac> exceptionMacList);
	
	public int saveExceptionMacs(List<ExceptionMac> exceptionMacList,int batchCount);
	
	public ExceptionMac queryByMac(String mac);
	
	public int updateExceptionMacs(List<ExceptionMac> exceptionMacList);
	
	public int deleteByMac(String mac);
	
	public List<ExceptionMac> queryList();
}
