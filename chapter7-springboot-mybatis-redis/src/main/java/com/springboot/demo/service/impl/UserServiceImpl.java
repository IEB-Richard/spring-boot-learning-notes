package com.springboot.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.dao.UserDao;
import com.springboot.demo.pojo.User;
import com.springboot.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	@CachePut(value = "redisCache", key = "'redis_user_'+#id")
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	@Override
	@Transactional
	@CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
	public User insertUser(User user) {
		userDao.insertUser(user);
		return user;
	}

	@Override
	@Transactional
	@CachePut(value = "redisCache", condition = "#result != 'null'", key = "'redis_user_'+#id")
	public User updateUserName(Long id, String userName) {
		// 此处调用getUser方法，该方法缓存注解失效，
		// 所以这里还会执行SQL，将查询到数据库最新数据
		User user = this.getUser(id);
		if (user == null) {
			return null;
		}
		user.setUserName(userName);
		userDao.updateUser(user);
		return user;
	}
	
	// Because this interface may note be called frequently, so we don't apply redis cache 
	@Override
	@Transactional
	public List<User> findUsers(String userName, String note) {
		return userDao.findUsers(userName, note);
	}

	@Override
	@Transactional
	@CacheEvict(value = "redisCache", key = "'redis_user_'+#id", beforeInvocation = false)
	public int deleteUser(Long id) {
		return userDao.deleteUser(id);
	}

}
