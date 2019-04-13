package com.springboot.chapter4.validator.impl;

import org.springframework.stereotype.Component;

import com.springboot.chapter4.pojo.User;
import com.springboot.chapter4.validator.UserValidator;

@Component
public class UserValidatorImpl implements UserValidator {

	@Override
	public boolean validate(User user) {
		System.out.println("引入新的接口："+ UserValidator.class.getSimpleName());
		return user != null;
	}
}
