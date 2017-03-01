package com.skeye.water_fountain.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

public class CommonPage implements Serializable {
	
	private static final long serialVersionUID = 7941149355570542666L;
	
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalPage;
	private Integer totalRecord;
	private String sort;
	private String order;
	private String params;
	private Object data;

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getparams() {
		return params;
	}

	public void setparams(String params) {
		this.params = params;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public CommonPage() {
	}

	public Map<String, Object> pageToMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commonPage", this);
		String params = this.getparams();
		if (StringUtils.isNotEmpty(params)) {
			Map<String, Object> paramsMap = JSONObject.parseObject(params);
			map.putAll(paramsMap);
		}
		return map;
	}

	public String getparams(String paramsKey) {
		String value = null;
		String params = this.getparams();
		if (StringUtils.isNotEmpty(params)) {
			Map<String, Object> paramsMap = JSONObject.parseObject(params);
			value = (String) paramsMap.get(paramsKey);
		} else {
			value = null;
		}
		return value;
	}

	public boolean containparams(String paramsKey) {
		boolean f = false;
		String params = this.getparams();
		if (StringUtils.isNotEmpty(params)) {
			try {
				Map<String, Object> paramsMap = JSONObject.parseObject(params);
				f = paramsMap.containsKey(paramsKey);
			} catch (Exception e) {
				f = false;
			}
		} else {
			f = false;
		}
		return f;
	}
}
