package com.springboot.chapter3.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.chapter3.pojo.DataBaseProperties;
import com.springboot.chapter3.pojo.definition.Person;

public class IoCTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = ctx.getBean(Person.class);
		person.service();
		DataBaseProperties databaseProperties = ctx.getBean(DataBaseProperties.class);
		System.out.println(databaseProperties.getDriverName());
		ctx.close();
	}	
}
