package com.springboot.chapter3.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.chapter3"})
@PropertySource(value={"classpath:jdbc.properties"}, ignoreResourceNotFound=true)
public class Chapter3DependencyInjection01Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter3DependencyInjection01Application.class, args);
	}

}
