package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.ApTrustDao;
import com.yagout.defense.dal.model.ApTrust;
import com.yagout.defense.dal.service.ApTrustMapper;
@Repository
public class ApTrustDaoImpl extends BaseDao implements ApTrustDao  {
	
	@Autowired
	private ApTrustMapper apTrustMapper;
	@Override
	public List<Map<String, Object>> getApTrustByMap(
			Map<String, Object> map) {
		return apTrustMapper.selectAll(map);
	}

	@Override
	public int deleteApTrusts(List<String> macs) {
		return apTrustMapper.deleteApTrusts(macs);
	}

	@Override
	public int saveApTrusts(List<ApTrust> apTrustLists) {
		return super.groupCommit(apTrustLists, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.ApTrustMapper.batchInsert","apTrustlist");
	}
	@Override
	public int saveApTrusts(List<ApTrust> apTrustLists,int batchCount) {
		return super.groupCommit(apTrustLists, batchCount,"com.yagout.defense.dal.service.ApTrustMapper.batchInsert","apTrustlist");
	}

	@Override
	public ApTrust queryByMac(String mac) {
		return apTrustMapper.selectByPrimaryKey(mac);
	}

	@Override
	public int updateApTrusts(List<ApTrust> apTrustList) {
		return super.groupCommit(apTrustList, DEFAULT_BATCH_COUNT, "com.yagout.defense.dal.service.ApTrustMapper.batchUpdate","apTrustlist");
	}
	
	

}
