package com.springboot.chapter4.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.springboot.chapter4.pojo.User;
import com.springboot.chapter4.validator.UserValidator;
import com.springboot.chapter4.validator.impl.UserValidatorImpl;

@Aspect
@Component
@EnableAspectJAutoProxy
public class MyAspect {
	
//	@DeclareParents(value = "com.springboot.chapter4.service.impl.UserServiceImpl+", defaultImpl=UserValidatorImpl.class)
//	public UserValidator userValidator;
//	
	@Pointcut("execution(* com.springboot.chapter4.service.impl.UserServiceImpl.printUser(..))")
	public void pointCut() {}
	
	@Before("pointCut() && args(user)")
	public void beforeParam( User user) {
		System.out.println("before with args ......");
	} 
	
	@Before("pointCut()")
	public void before() {
		System.out.println("before ......");
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("after ......");
	}
	
	
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("afterReturning ......");
	}
	
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("afterThrowing ......");
	}
	

	@Around("pointCut()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around before......");
		jp.proceed();
		System.out.println("around after......");
	}
}
