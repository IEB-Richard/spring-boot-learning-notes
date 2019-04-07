package com.springboot.chapter3.pojo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public void printUser(User user) {
		System.out.println("user ID: " + user.getId());
		System.out.println("user name: " + user.getUserName());
		System.out.println("Note: " + user.getNote());
	}
}
