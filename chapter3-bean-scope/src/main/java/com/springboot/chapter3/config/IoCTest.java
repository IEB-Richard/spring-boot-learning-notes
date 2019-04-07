package com.springboot.chapter3.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.chapter3.pojo.ScopeBean;

public class IoCTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// if singleton bean, scopeBean1 == scopeBean2, if Protype bean, then scopeBean1 != ScopeBean2
		ScopeBean scopeBean1 = ctx.getBean(ScopeBean.class);
		ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
		System.out.println(scopeBean1 == scopeBean2);
		
		ctx.close();
	}	
}
