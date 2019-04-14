package com.springboot.chapter6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.chapter6.dao.UserDao;
import com.springboot.chapter6.entity.User;
import com.springboot.chapter6.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, timeout=1)
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, timeout=1)
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

}
