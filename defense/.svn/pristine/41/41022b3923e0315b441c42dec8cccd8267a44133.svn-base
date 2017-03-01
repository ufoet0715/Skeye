package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ApTrust;

public interface ApTrustDao {
	public List<Map<String,Object>> getApTrustByMap(Map<String, Object> map);
	
	public int deleteApTrusts(List<String> macs);
	
	public int saveApTrusts(List<ApTrust> apTrustList);
	
	public int saveApTrusts(List<ApTrust> apTrustList,int batchCount);
	
	public ApTrust queryByMac(String mac);
	
	public int updateApTrusts(List<ApTrust> apTrustList);
}
