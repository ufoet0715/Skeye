package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ApVisitor;

public interface ApVisitorDao {
	public List<Map<String,Object>> getApVisitorByMap(Map<String, Object> map);
	
	public int deleteApVisitors(List<String> macs);
	
	public int saveApVisitors(List<ApVisitor> apVisitorList);
	
	public int saveApVisitors(List<ApVisitor> apVisitorList,int batchCount);
	
	public ApVisitor queryByMac(String mac);
	
	public int updateApVisitors(List<ApVisitor> apVisitorList);
}
