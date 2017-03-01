package com.skeye.yagout.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CommonPage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7941149355570542666L;
	public Integer pageNo;//当前页码
	public String sort;
	public Integer rows; //每页条数
	public String order;

	public Integer total;
	public Integer totalPage;

	public String params ;

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Object pageData;
	public static Integer DEFAULT_PAGESIZE = 10;

	public CommonPage() {

	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer totalRecord) {
		this.total = totalRecord;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Object getPageData() {
		return pageData;
	}

	public void setPageData(Object pageData) {
		this.pageData = pageData;
	}


	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getRows() {
		if(rows==null) return DEFAULT_PAGESIZE;
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
    
	/**
	 * 
	 * @param
	 * @return
	 */
	public   Map<String, Object> pageToMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", this);
		String params = this.getParams();
		if (StringUtils.isNotEmpty(params)) {
			try {
				Map<String, Object> paramsMap = JSONObject.parseObject(params);
				map.putAll(paramsMap);
			} catch (Exception e) {
			}
		}
		return map;
	}

	public boolean containParam(String paramKey){
		String params = this.getParams();
		if (StringUtils.isNotEmpty(params)) {
			try {
				Map<String, Object> paramsMap = JSONObject.parseObject(params);
               return paramsMap.containsKey(paramKey);
			} catch (Exception e) {
				return false;
			}
		}else {
			return  false;
		}

	}
	public String getParam(String paramKey) {
		String params = this.getParams();
		if (StringUtils.isNotEmpty(params)) {
			try {
				Map<String, Object> paramsMap = JSONObject.parseObject(params);
				return (String) paramsMap.get(paramKey);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

	
	
}
