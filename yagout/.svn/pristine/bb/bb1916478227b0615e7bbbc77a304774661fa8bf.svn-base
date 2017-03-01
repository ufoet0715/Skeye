package com.skyeye.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skeye.yagout.dal.dao.SystemadminDao;
import com.skeye.yagout.dal.model.Systemadmin;
import com.skyeye.test.BasicTest;

import java.sql.Timestamp;

public class AdminDaoTest extends BasicTest {

	@Autowired private SystemadminDao  systemadminDao;
	
	@Test
	public void test(){
		Systemadmin record=new Systemadmin();
		record.setId(6);
		record.setPassword("22222");
		record.setUsername("tt");
		systemadminDao.addSystemadmin(record);
	}

	public static void main(String[] args) {
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		long sqlLastTime = timestamp.getTime();// 直接转换成long
		System.out.println("sqlLastTime = "+sqlLastTime); //毫秒数
		System.out.println("sqlLastTime/1000 = "+sqlLastTime/1000);     // 秒数
	}
}
