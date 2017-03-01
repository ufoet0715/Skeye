package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.ApAdHocDao;
import com.yagout.defense.dal.model.ApAdHoc;
import com.yagout.defense.dal.service.ApAdHocMapper;
@Repository
public class ApAdHocDaoImpl extends BaseDao implements ApAdHocDao  {
	
	@Autowired
	private ApAdHocMapper apAdHocMapper;
	@Override
	public List<Map<String, Object>> getApAdHocByMap(
			Map<String, Object> map) {
		return apAdHocMapper.selectAll(map);
	}

	@Override
	public int deleteApAdHocs(List<String> macs) {
		return apAdHocMapper.deleteApAdHocs(macs);
	}

	@Override
	public int saveApAdHocs(List<ApAdHoc> apAdHocLists) {
		return super.groupCommit(apAdHocLists, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.ApAdHocMapper.batchInsert","apAdHoclist");
	}
	@Override
	public int saveApAdHocs(List<ApAdHoc> apAdHocLists,int batchCount) {
		return super.groupCommit(apAdHocLists, batchCount,"com.yagout.defense.dal.service.ApAdHocMapper.batchInsert","apAdHoclist");
	}

	@Override
	public ApAdHoc queryByMac(String mac) {
		return apAdHocMapper.selectByPrimaryKey(mac);
	}

	@Override
	public int updateApAdHocs(List<ApAdHoc> apAdHocList) {
		return super.groupCommit(apAdHocList, DEFAULT_BATCH_COUNT, "com.yagout.defense.dal.service.ApAdHocMapper.batchUpdate","apAdHoclist");
	}
	
	

}
