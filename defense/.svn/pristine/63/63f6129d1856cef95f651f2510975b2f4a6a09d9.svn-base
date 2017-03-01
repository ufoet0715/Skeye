package com.yagout.defense.biz;

import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.CommonResult;
import com.yagout.defense.util.MacType;

import java.util.List;

public interface MacManegerBiz {
	public void  queryByPage(CommonPage commonPage,MacType macType);
	
	public CommonResult batchDelete(List<String> args,MacType macType);
	
	public <V> CommonResult deleteByPrimaryKey(V key, MacType macType);
	
	public <V> CommonResult batchInsert(List<V> dataList,MacType macType);
	
	public <V> CommonResult insert(V data,MacType macType);
	
	public <V> CommonResult batchUpdate(List<V> dataList,MacType macType);
	
	public <V> CommonResult updateByPrimaryKey(V data,MacType macType);
	
	public Object queryByPrimaryKey(String primaryKey,MacType macType);
	
	public Object queryList(MacType macType);
}
