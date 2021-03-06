package com.springboot.chapter3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan("com.springboot.chapter3.*")
//@ComponentScan(basePackages = {"com.springboot.chapter3.pojo"})
//@ComponentScan(basePackageClasses = {User.class})
@ComponentScan(basePackages = "com.springboot.chapter3.*", 
excludeFilters= {@Filter(classes= {Service.class})})
public class AppConfig {
}
