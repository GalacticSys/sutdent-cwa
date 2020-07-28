package com.hjt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hjt.*")
@MapperScan(basePackages = "com.hjt.dao")
public class AtudentCwaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtudentCwaApplication.class, args);
	}

}
