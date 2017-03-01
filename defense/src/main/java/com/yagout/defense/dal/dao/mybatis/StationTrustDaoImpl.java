package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.StationTrustDao;
import com.yagout.defense.dal.model.StationTrust;
import com.yagout.defense.dal.service.StationTrustMapper;
@Repository
public class StationTrustDaoImpl extends BaseDao implements StationTrustDao  {
	
	@Autowired
	private StationTrustMapper stationTrustMapper;
	@Override
	public List<Map<String, Object>> getStationTrustByMap(
			Map<String, Object> map) {
		return stationTrustMapper.selectAll(map);
	}

	@Override
	public int deleteStationTrusts(List<String> macs) {
		return stationTrustMapper.deleteStationTrusts(macs);
	}

	@Override
	public int saveStationTrusts(List<StationTrust> stationTrustLists) {
		return super.groupCommit(stationTrustLists, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.StationTrustMapper.batchInsert","trustStationlist");
	}
	@Override
	public int saveStationTrusts(List<StationTrust> stationTrustLists,int batchCount) {
		return super.groupCommit(stationTrustLists, batchCount,"com.yagout.defense.dal.service.StationTrustMapper.batchInsert","trustStationlist");
	}

	@Override
	public StationTrust queryByMac(String mac) {
		return stationTrustMapper.selectByPrimaryKey(mac);
	}

	@Override
	public int updateStationTrusts(List<StationTrust> stationTrustList) {
		return super.groupCommit(stationTrustList, DEFAULT_BATCH_COUNT, "com.yagout.defense.dal.service.StationTrustMapper.batchUpdate","trustStationlist");
	}
	
	@Override
	public List<StationTrust> selectList(){
		return stationTrustMapper.selectList();
	}

}
