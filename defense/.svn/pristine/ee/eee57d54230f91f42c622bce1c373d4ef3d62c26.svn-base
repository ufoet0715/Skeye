package com.yagout.defense.biz;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.Station;
import com.yagout.defense.dal.model.StationAdapter;

public interface StationBiz {
	boolean update(List<Station> stationList,StationAdapter stationAdapter);
	
	/**
	 * 根据mac地址查询表中位置
	 * @param mac
	 * @return
	 */
	public Map<String, String> queryAllByMac(String mac);
}
