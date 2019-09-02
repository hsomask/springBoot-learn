package com.springbootdemo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.springbootdemo.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;
	@Test
	public void contextLoads() {
		System.out.println(person);
	}

}
