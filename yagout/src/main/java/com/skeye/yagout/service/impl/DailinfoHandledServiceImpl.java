package com.skeye.yagout.service.impl;

import com.skeye.yagout.dal.dao.DailinfoHandledDao;
import com.skeye.yagout.dal.model.DailinfoHandled;
import com.skeye.yagout.dal.model.DailinfoHandledExample;
import com.skeye.yagout.service.DailinfoHandledService;
import com.skeye.yagout.util.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DailinfoHandledServiceImpl implements DailinfoHandledService {
	@Autowired private DailinfoHandledDao dailinfoHandledDao;
	
	@Override
	public List<DailinfoHandled> getDailinfoHandledList()
	{
		DailinfoHandledExample dailinfoHandledExample=new DailinfoHandledExample();
		return this.dailinfoHandledDao.getDailinfoHandledList(dailinfoHandledExample);
	}

	@Override
	public List<Map> getDailinfoHandledListByPage(CommonPage commonPage) {
		return this.dailinfoHandledDao.getDailinfoHandledListByMap(commonPage.pageToMap());
	}

	@Override
	public boolean deleteDailinfoHandledByList(List<Integer> ids) {
		DailinfoHandledExample example=new DailinfoHandledExample();
		example.createCriteria().andIdIn(ids);
		int rows=dailinfoHandledDao.deleteDailinfoHandledByRecord(example);
		return ids.size()>=rows&&rows>0;
	}
}
