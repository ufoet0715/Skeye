package com.skyeye.test.util;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skeye.yagout.dal.dao.AccountDao;
import com.skeye.yagout.dal.model.Account;
import com.skeye.yagout.dal.model.AccountExample;
import com.skeye.yagout.dal.model.AccountExample.Criteria;
import com.skyeye.test.BasicTest;
import com.skyeye.test.POIUtilTest;

public class POITest extends BasicTest {
	//@Autowiredprivate RawaccountHandledService rawaccountHandledService;
	@Autowired private AccountDao accountDao;
	
	@Test
	public void test() {
		Class targetClass=Account.class;
		AccountExample accountExample = new AccountExample();
		Criteria criteria = accountExample.createCriteria();
		criteria.andAccountnameEqualTo("a0000001");
		List<?> dataList=this.accountDao.getAccoutList(accountExample);
		POIUtilTest utilTest=new POIUtilTest();
		String[] propertiesName = { "编号", "账号名", "密码", "账号类型", "次数", "ADSL账号", "MAC地址", "IP地址", "时间", "CapIP", "Virtual ID", "端口" };
		utilTest.doPOI("账户信息", propertiesName, targetClass, dataList, "D:\\WorkSpace\\Test.xls");
	}
}
