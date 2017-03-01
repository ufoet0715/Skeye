package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.ApVisitor;
import com.yagout.defense.util.CommonPage;

public interface ApVisitorService  {
	public boolean save(List<ApVisitor> apVisitors);
	public boolean save(ApVisitor apVisitor);
	public boolean delete(List<String> macs);
	public boolean delete(String macs);
	public boolean update(List<ApVisitor> apVisitors);
	public boolean update(ApVisitor apVisitor);
	public List<Map<String, Object>> query(CommonPage commonPage);
	public ApVisitor query(String mac);
}
