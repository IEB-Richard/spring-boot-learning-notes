package com.springboot.chapter3.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.chapter3.config.AppConfig;
import com.springboot.chapter3.pojo.User;

@SpringBootApplication
public class IoCTest {
	
	public static void main(String[] args) {
		
		// get the application context
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		
		// get bean from application context
		User user = ctx.getBean(User.class);
		System.out.println(user.getUserName());
		
		// close application context
		ctx.close();
	}

}
