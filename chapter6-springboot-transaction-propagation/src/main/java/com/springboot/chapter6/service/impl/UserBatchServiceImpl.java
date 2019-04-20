package com.springboot.chapter6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.chapter6.entity.User;
import com.springboot.chapter6.service.UserBatchService;
import com.springboot.chapter6.service.UserService;

@Service
public class UserBatchServiceImpl implements UserBatchService {
	
	@Autowired
	private UserService userService = null;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int insertUsers(List<User> userList) {
		int count = 0;
		for(User user : userList) {
			// Here we the method to insert single user, on which we will define
			// propagation with annotation @Transactional
			count += userService.insertUser(user);
		}
		return count;
	}

}
