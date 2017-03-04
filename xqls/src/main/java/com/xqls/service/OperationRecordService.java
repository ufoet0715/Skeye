package com.xqls.service;

import java.util.List;
import java.util.Map;

import com.xqls.bean.OperationRecordBean;


public interface OperationRecordService {
/**
 * 保存   传入一个操作记录对象，对象中必须包含（操作记录所属编号、操作类型（字典枚举）、ss
 * 操作记录内容（字典编号）、企业编号、操作来源（可选填）、租户编号）
 * @param opRecord
 * @return
 */
	public boolean save(OperationRecordBean opRecord);
	/**
	 * 通过条件查询操作记录
	 * @param map    map内存入 （ 操作记录时间、操作记录类型、操作记录所属模块编号、企业编号）
	 * @return
	 */
	public List<Map<String, Object>> queryByMap(Map<String, Object> map);
}
