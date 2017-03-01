package com.skyeye.test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skeye.yagout.dal.dao.DailinfoHandledDao;
import com.skeye.yagout.dal.model.DailinfoHandled;
import com.skeye.yagout.dal.model.DailinfoHandledExample;
import com.skeye.yagout.dal.model.DailinfoHandledExample.Criteria;
import com.skyeye.test.BasicTest;

public class DailinfoHandledDaoTest extends BasicTest {
    @Autowired private DailinfoHandledDao dailinfoHandledDao;
    @Test
    public void Test()
    {
    	DailinfoHandledExample dailinfoHandledExample=new DailinfoHandledExample();
    	Criteria criteria = dailinfoHandledExample.createCriteria();
		criteria.andAdslaccountEqualTo("0000002");
		criteria.andPasswdEqualTo("123456");
		criteria.andDailtimeEqualTo(800);
		criteria.andDailipEqualTo(19216801);
		criteria.andDailmacEqualTo("FF:FF:FF:FF:FF:FF");
		criteria.andDailtypeEqualTo(1);
		
    	int i=this.dailinfoHandledDao.deleteDailinfoHandledByRecord(dailinfoHandledExample);
		System.out.println(i);
		
    }
}
