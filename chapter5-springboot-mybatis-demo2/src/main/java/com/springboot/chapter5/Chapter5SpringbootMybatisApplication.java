package com.springboot.chapter5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.springboot.chapter5.dao"})
public class Chapter5SpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter5SpringbootMybatisApplication.class, args);
	}

}
