package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ApAdHoc;
import com.yagout.defense.util.CommonPage;

public interface ApAdHocService  {
	public boolean save(List<ApAdHoc> apAdHocs);
	public boolean save(ApAdHoc apAdHoc);
	public boolean delete(List<String> macs);
	public boolean delete(String macs);
	public boolean update(List<ApAdHoc> apAdHocs);
	public boolean update(ApAdHoc apAdHoc);
	public List<Map<String, Object>> query(CommonPage commonPage);
	public ApAdHoc query(String mac);
}
