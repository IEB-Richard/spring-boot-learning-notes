package com.springboot.chapter5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.chapter5.pojo.User;
import com.springboot.chapter5.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{userId}")
	@ResponseBody
	public User getUser(@PathVariable Long userId) {
		
		return userService.getUser(userId);
	}
}
