package com.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan(basePackages = {"com.springboot.demo"}, annotationClass = Repository.class)
public class SpringbootMybatisRedisApplication {
	
	/**
	 * get the redisTemplate from Spring IoC
	 */
	@Autowired
	private RedisTemplate<String, String> redisTempalte = null;
	
	/**
	 * Self-defined constructor method to set the serializer for RedisTemplate
	 */
	@PostConstruct
	public void init() {
		initRedisTempalte();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisRedisApplication.class, args);
	}
	
	private void initRedisTempalte() {
		// get the string serializer created by Spring framework 
		RedisSerializer<String> stringSerializer = redisTempalte.getStringSerializer();
		redisTempalte.setKeySerializer(stringSerializer);
		redisTempalte.setHashKeySerializer(stringSerializer);
	}
	
}
