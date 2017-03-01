package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.StationDao;
import com.yagout.defense.dal.model.Station;
import com.yagout.defense.dal.service.StationMapper;
@Repository
public class StationDaoImpl extends BaseDao implements StationDao{
	@Autowired
	private StationMapper stationMapper;
	
	@Override
	public List<Map<String, Object>> getStationByMap(Map<String, Object> map) {
		return stationMapper.selectAll(map);
	}

	@Override
	public int deleteStations(Map<String, List<String>> map) {
		return stationMapper.deleteStations(map);
	}

	@Override
	public int saveStations(List<Station> station) {
		return super.groupCommit(station, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.StationMapper.batchInsert","stationlist");
	}

	@Override
	public int saveStations(List<Station> station, int batchCount) {
		return super.groupCommit(station, batchCount,"com.yagout.defense.dal.service.StationMapper.batchInsert","stationlist");
	}

	@Override
	public Map<String, Object> queryByMac(Map<String, Object> map) {
		return stationMapper.selectByMap(map);
	}

	@Override
	public int updateStations(List<Station> station) {
		return super.groupCommit(station, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.StationMapper.batchUpdate","stationlist");
	}
	
	@Override
	public Map<String, String> selectAllByMac(String mac){
		return stationMapper.selectAllByMac(mac);
	}

}
