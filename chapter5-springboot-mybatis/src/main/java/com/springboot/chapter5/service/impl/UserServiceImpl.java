package com.springboot.chapter5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.chapter5.dao.UserDao;
import com.springboot.chapter5.pojo.User;
import com.springboot.chapter5.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

}
