package com.springboot.chapter5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.springboot.chapter5"})
@EnableJpaRepositories(basePackages = "com.springboot.chapter5.dao")
@EntityScan(basePackages = "com.springboot.chapter5.entity")
public class Chapter5SpringbootMysqlDhcpApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(Chapter5SpringbootMysqlDhcpApplication.class, args);
	
	}
}
