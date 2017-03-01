package com.yagout.defense.service;

import com.yagout.defense.biz.bean.ScanApBean;
import com.yagout.defense.dal.model.ScanAp;
import com.yagout.defense.util.CommonPage;

import java.util.List;
import java.util.Map;


public interface ScanApService {
	public List<Map<String,Object>> queryApByPage(CommonPage commonPage);

	public List<Map<String,Object>> queryApMapList( );
    public List<ScanAp> queryApList();

    public ScanApBean queryByKey(String mac);
}
