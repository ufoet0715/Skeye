package com.yagout.defense.service;

import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.Ap;
import com.yagout.defense.util.CommonPage;

public interface ApService  {
	/**
	 * 批量多表添加。多个表多条数据插入
	 * @param ap
	 * @return
	 */
	public boolean save(List<Ap> ap);
	/**
	 * 单表多条数据插入
	 * @param ap
	 * @return
	 */
	public boolean save(Ap ap);
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
	 * @param ap
	 * @return
	 */
	public boolean update(List<Ap> ap);
	/**
	 * 单表批量修改
	 * @param ap
	 * @return
	 */
	public boolean update(Ap ap);
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
	 * @return
	 */
	public Map<String, Object> query(String mac,String tableName);
}
