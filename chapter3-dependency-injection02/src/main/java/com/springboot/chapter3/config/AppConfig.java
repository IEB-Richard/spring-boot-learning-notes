package com.springboot.chapter3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages="com.springboot.chapter3.pojo*")
//@ComponentScan(basePackages="com.springboot.chapter3.pojo.*", lazyInit=true)
@ComponentScan(basePackages="com.springboot.chapter3.*")
public class AppConfig {
	// 
}
