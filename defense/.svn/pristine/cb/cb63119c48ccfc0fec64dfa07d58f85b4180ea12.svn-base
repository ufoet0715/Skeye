package com.yagout.defense.dal.dao;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ApNeighbor;

public interface ApNeighborDao {
	public List<Map<String,Object>> getApNeighborByMap(Map<String, Object> map);
	
	public int deleteApNeighbors(List<String> macs);
	
	public int saveApNeighbors(List<ApNeighbor> apNeighborList);
	
	public int saveApNeighbors(List<ApNeighbor> apNeighborList,int batchCount);
	
	public ApNeighbor queryByMac(String mac);
	
	public int updateApNeighbors(List<ApNeighbor> apNeighborList);
}
