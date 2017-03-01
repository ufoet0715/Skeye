package com.skeye.yagout.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.yagout.dal.dao.DailinfoHandledDao;
import com.skeye.yagout.dal.model.DailinfoHandled;
import com.skeye.yagout.dal.model.DailinfoHandledExample;
import com.skeye.yagout.dal.service.DailinfoHandledMapper;

@Repository
public class DailinfoHandledDaoImpl implements DailinfoHandledDao {
    @Autowired private DailinfoHandledMapper dailinfoHandledMapper;
	
	@Override
	public List<DailinfoHandled> getDailinfoHandledList(DailinfoHandledExample dailinfoHandledExample) {
		return this.dailinfoHandledMapper.selectByExample(dailinfoHandledExample);
	}

	@Override
	public List<Map> getDailinfoHandledListByMap(Map<String, Object> paramMap) {
		return this.dailinfoHandledMapper.selectByMap(paramMap);
	}

	@Override
	public int deleteDailinfoHandledByRecord(DailinfoHandledExample dailinfoHandledExample) {
		return this.dailinfoHandledMapper.deleteByExample(dailinfoHandledExample);
	}

}
