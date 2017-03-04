package com.xqls.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.bean.OperationRecordBean;
import com.xqls.dal.dao.OperationRecordDao;
import com.xqls.dal.model.OperationRecord;
import com.xqls.service.OperationRecordService;
import com.xqls.util.ObjectUtil;
@Service
public class OperationRecordServiceImpl implements OperationRecordService {

	@Autowired	private OperationRecordDao opRecordDao;
	@Override
	public boolean save(OperationRecordBean opRecord) {
		opRecord.setRecordTime(new Date());
		OperationRecord operationRecord = (OperationRecord) ObjectUtil.transfer(opRecord, OperationRecord.class);
		int result = opRecordDao.insert(operationRecord);
		return result>0;
	}

	@Override
	public List<Map<String, Object>> queryByMap(Map<String, Object> map) {
		return opRecordDao.queryByMap(map);
	}

}
