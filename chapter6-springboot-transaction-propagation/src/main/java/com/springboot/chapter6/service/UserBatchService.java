package com.springboot.chapter6.service;

import java.util.List;

import com.springboot.chapter6.entity.User;

public interface UserBatchService {
	public int insertUsers(List<User> userList);
}
