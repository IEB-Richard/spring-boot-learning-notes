package com.springboot.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.springboot.demo.pojo.User;

@Repository
public interface UserDao {
	
	// get single user
	User getUser(Long id);
	
	// insert one single user
	int insertUser(User user);
	
	// update one single user
	int updateUser(User user);
	
	// find user by mybatis parameters
    List<User> findUsers(@Param("userName") String userName,
            @Param("note") String note);  
    // delete user by id
    int deleteUser(Long id);
}
