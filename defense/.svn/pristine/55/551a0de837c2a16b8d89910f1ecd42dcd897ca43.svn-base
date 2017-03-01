package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.Station;
import com.yagout.defense.util.CommonPage;

public interface StationService  {
	/**
	 * 批量多表添加。多个表多条数据插入
	 * station中的map需要new LinkedHashMap();有序排列
	 * @param ap
	 * @return
	 */
	public boolean save(List<Station> station);
	/**
	 * 单表多条数据插入
	 * @param ap
	 * @return
	 */
	public boolean save(Station station);
	/**
	 * 根据多个mac，多表多条删除
	 * @param map
	 * @return
	 */
	public boolean delete(Map<String,List<String>> map);
	/**
	 * 单表单条数据删除
	 * @param macs
	 * @param tableName
	 * @return
	 */
	public boolean delete(String macs,String tableName);
	/**
	 * 多个表多条数据修改
	 * station中的map需要new LinkedHashMap();有序排列
	 * @param ap
	 * @return
	 */
	public boolean update(List<Station> station);
	/**
	 * 单表批量修改
	 * @param ap
	 * @return
	 */
	public boolean update(Station station);
	/**
	 * 查询所有
	 * @param commonPage
	 * @return
	 */
	public List<Map<String, Object>> query(CommonPage commonPage);
	/**
	 * 根据mac和表名查询
	 * @param mac
	 * @param tableName
	 * @param alias   需要查询的字段,String放别名，object放数据库字段名
	 * @return
	 */
	public Map<String, Object> query(String mac,String tableName,Map<String, Object> alias);
	
	/**
	 * 根据mac地址查询所在表的名称
	 * @param mac
	 * @return
	 */
	public Map<String, String> queryAllByMac(String mac);
}
