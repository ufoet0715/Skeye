package com.yagout.defense.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class CommonPage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7941149355570542666L;
	public Integer sEcho;//请求次数
	public Integer iDisplayLength; //每页条数
	public Integer iDisplayStart;//起始条数
	public String sidx;//排序字段
	public String sord;//排序方式

	public Integer iTotalRecords;
	//public Integer totalPage;

	public String params ;

	public String tableFiled;//优化的主键
	public String tableName;//优化的查询分页表名称
	public String tableAglisName;// 表别名

	private  Map<String,Object> paramsMap=null;

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getTableAglisName() {
		return tableAglisName;
	}

	public void setTableAglisName(String tableAglisName) {
		this.tableAglisName = tableAglisName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableFiled() {
		return tableFiled;
	}

	public void setTableFiled(String tableFiled) {
		this.tableFiled = tableFiled;
	}

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

	public Integer getsEcho() {
		return sEcho;
	}

	public void setsEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Integer totalRecord) {
		this.iTotalRecords = totalRecord;
	}

//	public Integer getTotalPage() {
//		return totalPage;
//	}
//
//	public void setTotalPage(Integer totalPage) {
//		this.totalPage = totalPage;
//	}

	public Object getPageData() {
		return pageData;
	}

	public void setPageData(Object pageData) {
		this.pageData = pageData;
	}


	public Integer getiDisplayLength() {
		if(iDisplayLength ==null) return DEFAULT_PAGESIZE;
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	//	public String getOrder() {
//		return order;
//	}
//
//	public void setOrder(String order) {
//		this.order = order;
//	}
    
	/**
	 * 
	 * @param
	 * @return
	 */
	public   Map<String, Object> pageToMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", this);
		String params = this.getParams();
		String sidx = this.getSidx();
		if(sidx!=null&&!sidx.equals("")){
			map.put("sidx", sidx);
			map.put("sord", this.getSord());
		}
		if (params!=null&&!params.equals("")) {
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
		if (params!=null&&!params.equals("")) {
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

	private Map<String, Object>  getParamsMap(){

		if (paramsMap==null){
			if (params!=null&&!params.equals("")) {
				try {
					paramsMap = JSONObject.parseObject(params);
					return paramsMap;
				} catch (Exception e) {
					return null;
				}
			} else {
				return null;
			}
		}else {
			return  paramsMap;
		}
	}
	public String getParam(String paramKey) {
		if (getParamsMap()!=null ) {
				return (String) getParamsMap().get(paramKey);
		} else {
			return null;
		}
	}

	
	public String toShowPage(){
		JSONObject getObj = new JSONObject();
		getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
		getObj.put("iTotalRecords", iTotalRecords);//实际的行数
		getObj.put("iTotalDisplayRecords", iTotalRecords);//显示的行数,这个要和上面写的一样
		if(iTotalRecords%iDisplayLength == 0){
			getObj.put("total", iTotalRecords/iDisplayLength);
		}else{
			getObj.put("total", iTotalRecords/iDisplayLength+1);
		}
		if(pageData!=null){
		   getObj.put("aaData", pageData);//要以JSON格式返回
		}else {
		   getObj.put("aaData", new ArrayList());//要以JSON格式返回
		}
		return getObj.toString();
	}

	
	


	
	
}
