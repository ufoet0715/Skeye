package com.skeye.yagout.dal.dao.mybatis;

import com.skeye.yagout.dal.dao.RawaccountHandledDao;
import com.skeye.yagout.dal.model.RawaccountHandled;
import com.skeye.yagout.dal.model.RawaccountHandledExample;
import com.skeye.yagout.dal.service.RawaccountHandledMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RawaccountHandledDaoImpl implements RawaccountHandledDao {
    @Autowired private RawaccountHandledMapper rawaccountHandledMapper;

	@Override
	public List<Map> rawaccountHandledGroup(Map<String, Object> paramMap) {
		return rawaccountHandledMapper.selectGroupByMap(paramMap);
	}

	@Override
	public List<RawaccountHandled> getRawaccountHandledList(
			RawaccountHandledExample rawaccountHandledExample) {
		return this.rawaccountHandledMapper.selectByExample(rawaccountHandledExample);
	}

	@Override
	public List<RawaccountHandled> getRawaccountHandledListByLike(RawaccountHandledExample rawaccountHandledExample) {
		return this.rawaccountHandledMapper.selectByExample(rawaccountHandledExample);
	}

	@Override
	public List<Map> getRawaccountHandledListByMap(Map<String, Object> paramMap) {
		return this.rawaccountHandledMapper.selectByMap(paramMap);
	}

	@Override
	public int deleteRawaccountHandledByRecord(RawaccountHandledExample rawaccountHandledExample) {
		return this.rawaccountHandledMapper.deleteByExample(rawaccountHandledExample);
	}

}
