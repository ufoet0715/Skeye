package com.xqls.dal.dao;

import java.util.List;
import java.util.Map;

import com.xqls.dal.model.OperationRecord;

public interface OperationRecordDao {
	/**
	 * 传记录对象，并给予数据
	 * @param opRecord
	 * @return
	 */
	public int insert(OperationRecord opRecord);
	/**
	 * 条件查询
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryByMap(Map<String, Object> map);
}
