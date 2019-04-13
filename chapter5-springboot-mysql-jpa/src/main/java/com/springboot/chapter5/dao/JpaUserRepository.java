package com.springboot.chapter5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.chapter5.entity.User;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
	
}
