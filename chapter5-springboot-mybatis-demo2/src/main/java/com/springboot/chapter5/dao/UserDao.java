package com.springboot.chapter5.dao;

import org.springframework.stereotype.Repository;

import com.springboot.chapter5.pojo.User;

@Repository
public interface UserDao {
	public User getUser(Long id);
}
