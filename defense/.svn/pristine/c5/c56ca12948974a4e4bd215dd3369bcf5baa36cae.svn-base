package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ApTrust;
import com.yagout.defense.util.CommonPage;

public interface ApTrustService  {
	public boolean save(List<ApTrust> apTrusts);
	public boolean save(ApTrust apTrust);
	public boolean delete(List<String> macs);
	public boolean delete(String macs);
	public boolean update(List<ApTrust> apTrusts);
	public boolean update(ApTrust apTrust);
	public List<Map<String, Object>> query(CommonPage commonPage);
	public ApTrust query(String mac);
}
