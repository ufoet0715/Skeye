package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.ApDao;
import com.yagout.defense.dal.model.Ap;
import com.yagout.defense.dal.service.ApMapper;
@Repository
public class ApDaoImpl extends BaseDao implements ApDao{
	@Autowired
	private ApMapper apMapper;
	
	@Override
	public List<Map<String, Object>> getApByMap(Map<String, Object> map) {
		return apMapper.selectAll(map);
	}

	@Override
	public int deleteAps(Map<String, List<String>> map) {
		return apMapper.deleteAps(map);
	}

	@Override
	public int saveAps(List<Ap> ap) {
		return super.groupCommit(ap, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.ApMapper.batchInsert","aplist");
	}

	@Override
	public int saveAps(List<Ap> ap, int batchCount) {
		return super.groupCommit(ap, batchCount,"com.yagout.defense.dal.service.ApMapper.batchInsert","aplist");
	}

	@Override
	public Map<String, Object> queryByMac(Map<String, Object> map) {
		return apMapper.selectByMap(map);
	}

	@Override
	public int updateAps(List<Ap> ap) {
		return super.groupCommit(ap, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.ApMapper.batchUpdate","aplist");
	}

}
