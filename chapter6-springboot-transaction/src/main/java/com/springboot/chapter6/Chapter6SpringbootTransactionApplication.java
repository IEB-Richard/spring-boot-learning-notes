package com.springboot.chapter6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(
		basePackages = { "com.springboot.chapter6.dao" },
		annotationClass= Repository.class
)
public class Chapter6SpringbootTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter6SpringbootTransactionApplication.class, args);
	}

}
