package com.yagout.defense.biz.bean;

import java.util.List;
import java.util.Map;

public class ApBean {
	
	
	private String tableName;
	
	private List<Map<String,Object>>  data;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	
	
   
}
