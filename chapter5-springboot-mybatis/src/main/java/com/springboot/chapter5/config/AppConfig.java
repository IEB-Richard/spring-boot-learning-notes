package com.springboot.chapter5.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages= {"com.springboot.chapter5.dao"})
public class AppConfig {

}
