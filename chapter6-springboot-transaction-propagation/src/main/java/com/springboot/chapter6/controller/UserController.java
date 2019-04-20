package com.springboot.chapter6.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.chapter6.entity.User;
import com.springboot.chapter6.service.UserBatchService;
import com.springboot.chapter6.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// 注入Service
	@Autowired
	private UserService userService = null;
	
	// Inject UserBatchService
	@Autowired
	private UserBatchService userBatchService = null;

	// 测试获取用户
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(Long id) {
		return userService.getUser(id);
	}

	// 测试插入用户
	@RequestMapping("/insertUser")
	@ResponseBody
	public Map<String, Object> insertUser(String userName, String note) {
		User user = new User();
		user.setUserName(userName);
		user.setNote(note);
		// 结果会回填主键，返回插入条数
		int update = userService.insertUser(user);
		Map<String, Object> result = new HashMap<>();
		result.put("success", update == 1);
		result.put("user", user);
		return result;
	}
	
	// test Propagation behavior
	@RequestMapping("/insertUsers")
	@ResponseBody
	public Map<String, Object> insertUsers(String userName1, String note1, String userName2, String note2){
		// User 1
		User user1 = new User();
		user1.setUserName(userName1);
		user1.setNote(note1);
		// User 2
		User user2 = new User();
		user2.setUserName(userName2);
		user2.setNote(note2);
		
		// User Array contains user1 and user2
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		
		// let's insert and see how propagation will work for different propagation behavior
		// will affect the transaction actions.
		int inserts = userBatchService.insertUsers(userList);
		
		// return the result
		Map<String, Object> result = new HashMap<>();
		result.put("success", inserts>0);
		result.put("user", userList);
		return result;
	}
}