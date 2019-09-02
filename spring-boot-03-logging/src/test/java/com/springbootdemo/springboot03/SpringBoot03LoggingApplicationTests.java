package com.springbootdemo.springboot03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {
	//记录器
	Logger logger= LoggerFactory.getLogger(getClass());
	@Test
	public void contextLoads() {

		//日志级别，由低到高，可以调整输出的日志级别
		logger.trace("这是trace跟踪信息...");
		logger.debug("这是debug信息...。");
		logger.info("这是info信息...");
		logger.warn("这是warn信息...");
		logger.error("这是error信息...");
	}

}
