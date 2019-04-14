package com.springboot.chapter6;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@MapperScan(
		basePackages = { "com.springboot.chapter6.dao" },
		annotationClass= Repository.class
)
public class Chapter6SpringbootTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter6SpringbootTransactionApplication.class, args);
	}
	
	// inject transaction manager
	@Autowired
	PlatformTransactionManager transactionManager = null;
	
	/**
	 * Check the transaction manager populated by Spring framework
	 */
	@PostConstruct
	public void viewTransactionManager() {
		System.out.println(transactionManager.getClass().getName());
	}

}
