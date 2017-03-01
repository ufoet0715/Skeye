package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.ExceptionMacDao;
import com.yagout.defense.dal.model.ExceptionMac;
import com.yagout.defense.dal.model.ExceptionMacExample;
import com.yagout.defense.dal.service.ExceptionMacMapper;
@Repository
public class ExceptionMacDaoImpl extends BaseDao implements ExceptionMacDao  {
	
	@Autowired
	private ExceptionMacMapper exceptionMacMapper;
	@Override
	public List<Map<String, Object>> getExceptionMacByMap(
			Map<String, Object> map) {
		return exceptionMacMapper.selectAll(map);
	}

	@Override
	public int deleteExceptionMacs(List<String> macs) {
		return exceptionMacMapper.deleteExceptionMacs(macs);
	}

	@Override
	public int saveExceptionMacs(List<ExceptionMac> exceptionMacLists) {
		return super.groupCommit(exceptionMacLists, DEFAULT_BATCH_COUNT,"com.yagout.defense.dal.service.ExceptionMacMapper.batchInsert","exceptionMaclist");
	}
	@Override
	public int saveExceptionMacs(List<ExceptionMac> exceptionMacLists,int batchCount) {
		return super.groupCommit(exceptionMacLists, batchCount,"com.yagout.defense.dal.service.ExceptionMacMapper.batchInsert","exceptionMaclist");
	}

	@Override
	public ExceptionMac queryByMac(String mac) {
		return exceptionMacMapper.selectByPrimaryKey(mac);
	}

	@Override
	public int updateExceptionMacs(List<ExceptionMac> exceptionMacList) {
		return super.groupCommit(exceptionMacList, DEFAULT_BATCH_COUNT, "com.yagout.defense.dal.service.ExceptionMacMapper.batchUpdate","exceptionMaclist");
	}
	
	
	public int deleteByMac(String mac){
		return exceptionMacMapper.deleteByPrimaryKey(mac);
	}
	
	@Override
	public List<ExceptionMac> queryList(){
		ExceptionMacExample example = new ExceptionMacExample();
		return exceptionMacMapper.selectByExample(example);
	}
	

}
