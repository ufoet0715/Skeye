package com.xqls.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.OperationRecordDao;
import com.xqls.dal.model.OperationRecord;
import com.xqls.dal.service.OperationRecordMapper;
@Repository
public class OperationRecordDaoImpl implements OperationRecordDao {

	@Autowired private OperationRecordMapper opRecordMapper;
	@Override
	public int insert(OperationRecord opRecord) {
		int result = opRecordMapper.insert(opRecord);
		return result;
	}

	@Override
	public List<Map<String, Object>> queryByMap(Map<String, Object> map) {
		return opRecordMapper.selectByMap(map);
	}

}
