package com.springboot.chapter6.service;

import com.springboot.chapter6.entity.User;

public interface UserService {
	public User getUser(Long id);
	public int insertUser(User user);
}
