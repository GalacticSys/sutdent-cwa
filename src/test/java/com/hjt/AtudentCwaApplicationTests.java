package com.hjt;

import com.hjt.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class AtudentCwaApplicationTests {

	@Test
	void contextLoads() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ac.getBean("classes").toString());
	}

}
