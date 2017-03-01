package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.ApVisitorDao;
import com.yagout.defense.dal.model.ApVisitor;
import com.yagout.defense.dal.service.ApVisitorMapper;
@Repository
public class ApVisitorDaoImpl extends BaseDao implements ApVisitorDao  {
	
	@Autowired
	private ApVisitorMapper apVisitorMapper;
	@Override
	public List<Map<String, Object>> getApVisitorByMap(
			Map<String, Object> map) {
		return apVisitorMapper.selectAll(map);
	}

	@Override
	public int deleteApVisitors(List<String> macs) {
		return apVisitorMapper.deleteApVisitors(macs);
	}

	@Override
	public int saveApVisitors(List<ApVisitor> apVisitorLists) {
		return super.groupCommit(apVisitorLists, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.ApVisitorMapper.batchInsert","apVisitorlist");
	}
	@Override
	public int saveApVisitors(List<ApVisitor> apVisitorLists,int batchCount) {
		return super.groupCommit(apVisitorLists, batchCount,"com.yagout.defense.dal.service.ApVisitorMapper.batchInsert","apVisitorlist");
	}

	@Override
	public ApVisitor queryByMac(String mac) {
		return apVisitorMapper.selectByPrimaryKey(mac);
	}

	@Override
	public int updateApVisitors(List<ApVisitor> apVisitorList) {
		return super.groupCommit(apVisitorList, DEFAULT_BATCH_COUNT, "com.yagout.defense.dal.service.ApVisitorMapper.batchUpdate","apVisitorlist");
	}
	
	

}
