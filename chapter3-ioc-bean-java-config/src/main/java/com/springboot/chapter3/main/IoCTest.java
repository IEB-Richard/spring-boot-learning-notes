package com.springboot.chapter3.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.chapter3.config.AppConfig;
import com.springboot.chapter3.pojo.User;

public class IoCTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		
		User user = ctx.getBean(User.class);
		System.out.println(user.getUserName());
	}

}
