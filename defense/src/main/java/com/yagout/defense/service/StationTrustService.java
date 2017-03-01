package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.StationTrust;
import com.yagout.defense.util.CommonPage;

public interface StationTrustService  {
	public boolean save(List<StationTrust> stationTrusts);
	public boolean save(StationTrust stationTrust);
	public boolean delete(List<String> macs);
	public boolean delete(String macs);
	public boolean update(List<StationTrust> stationTrusts);
	public boolean update(StationTrust stationTrust);
	public List<Map<String, Object>> query(CommonPage commonPage);
	public StationTrust query(String mac);
	public List<StationTrust> query();
}
