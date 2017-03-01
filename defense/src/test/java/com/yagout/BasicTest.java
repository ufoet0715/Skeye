package com.yagout;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;


import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
@RunWith(JUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"classpath:spring-context.xml"})
public class BasicTest extends AbstractJUnit4SpringContextTests {


}
