package com.springboot.chapter3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.chapter3.pojo.User;

@Configuration
public class AppConfig {
	
	@Bean(name="user")
	public User initUser() {
		User user = new User();
		
		user.setId(1L);
		user.setUserName("Jack");
		user.setNote("this test user is for Jack Ma");
		
		return user;
	}
}
