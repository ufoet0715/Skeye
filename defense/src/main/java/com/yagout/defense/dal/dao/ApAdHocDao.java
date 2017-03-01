package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ApAdHoc;

public interface ApAdHocDao {
	public List<Map<String,Object>> getApAdHocByMap(Map<String, Object> map);
	
	public int deleteApAdHocs(List<String> macs);
	
	public int saveApAdHocs(List<ApAdHoc> apAdHocList);
	
	public int saveApAdHocs(List<ApAdHoc> apAdHocList,int batchCount);
	
	public ApAdHoc queryByMac(String mac);
	
	public int updateApAdHocs(List<ApAdHoc> apAdHocList);
}
