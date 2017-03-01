package com.skyeye.test.dao;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.junit.Test;

import com.skeye.yagout.dal.dao.RawaccountHandledDao;
import com.skeye.yagout.dal.model.RawaccountHandled;
import com.skeye.yagout.dal.model.RawaccountHandledExample;
import com.skeye.yagout.dal.model.RawaccountHandledExample.Criteria;
import com.skyeye.test.BasicTest;

public class RawaccountHandledDaoTest extends BasicTest{
    @Autowired private RawaccountHandledDao rawaccountHandledDao;
    
    @Test
    public void Test()
    {
    	RawaccountHandledExample rawaccountHandledExample=new RawaccountHandledExample();
    	Criteria criteria = rawaccountHandledExample.createCriteria();
    	criteria.andAccountnameEqualTo("r0000003");
    	criteria.andPasswordEqualTo("123456");
    	criteria.andAccounttypeEqualTo(5);
    	criteria.andAdslaccountEqualTo("0000003");
    	criteria.andIpaddrEqualTo("255.255.255.255");
    	criteria.andCapportEqualTo(70);
    	criteria.andCaptimeEqualTo(10000);
    	
    	int i=this.rawaccountHandledDao.deleteRawaccountHandledByRecord(rawaccountHandledExample);
    	System.out.println(i);
    }
}
