package com.springboot.chapter5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.chapter5.dao.JpaUserRepository;
import com.springboot.chapter5.entity.User;

@Controller
public class JpaController {

	@Autowired
	private JpaUserRepository jpaUserRepository = null;
	
	@RequestMapping("/getUser/{id}")
	@ResponseBody
	public User getUser(@PathVariable Long id) {
		User user = jpaUserRepository.findById(id).get();
		return user;
	}
	
	@PostMapping("/addUser")
	@ResponseBody
	public User addUser(@RequestBody User user) {
		return jpaUserRepository.save(user);
	}
}
