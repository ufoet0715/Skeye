package com.skeye.water_fountain.test;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath*:config/xml/applicationContext.xml"})
public class BasicTest extends AbstractJUnit4SpringContextTests{
	
	@Test
	public void Test(){
		
	}
}
