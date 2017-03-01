package com.skeye.water_fountain.service.test;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import com.skeye.water_fountain.test.BasicTest;

public class UrlTest extends BasicTest {

	@Test
	public void Test(HttpServletRequest request) {
		String path=request.getContextPath();
	    System.out.println(path);
	}
}
