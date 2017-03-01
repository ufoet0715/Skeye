package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.ApNeighborDao;
import com.yagout.defense.dal.model.ApNeighbor;
import com.yagout.defense.dal.service.ApNeighborMapper;
@Repository
public class ApNeighborDaoImpl extends BaseDao implements ApNeighborDao  {
	
	@Autowired
	private ApNeighborMapper apNeighborMapper;
	@Override
	public List<Map<String, Object>> getApNeighborByMap(
			Map<String, Object> map) {
		return apNeighborMapper.selectAll(map);
	}

	@Override
	public int deleteApNeighbors(List<String> macs) {
		return apNeighborMapper.deleteApNeighbors(macs);
	}

	@Override
	public int saveApNeighbors(List<ApNeighbor> apNeighborLists) {
		return super.groupCommit(apNeighborLists, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.ApNeighborMapper.batchInsert","apNeighborlist");
	}
	@Override
	public int saveApNeighbors(List<ApNeighbor> apNeighborLists,int batchCount) {
		return super.groupCommit(apNeighborLists, batchCount,"com.yagout.defense.dal.service.ApNeighborMapper.batchInsert","apNeighborlist");
	}

	@Override
	public ApNeighbor queryByMac(String mac) {
		return apNeighborMapper.selectByPrimaryKey(mac);
	}

	@Override
	public int updateApNeighbors(List<ApNeighbor> apNeighborList) {
		return super.groupCommit(apNeighborList, DEFAULT_BATCH_COUNT, "com.yagout.defense.dal.service.ApNeighborMapper.batchUpdate","apNeighborlist");
	}
	
	

}
