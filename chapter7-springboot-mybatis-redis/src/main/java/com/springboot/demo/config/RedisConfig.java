package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

//@Configuration
public class RedisConfig {
	
	private RedisConnectionFactory connectionFactory = null;
	
	@Bean(name = "redisConnectionFactory")
	public RedisConnectionFactory initConnectionFactory() {
		if(this.connectionFactory != null) {
			return this.connectionFactory;
		}
		
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		
		// the max idle time
		poolConfig.setMaxIdle(50);
		// the max connections
		poolConfig.setMaxTotal(100);
		// the max waiting time
		poolConfig.setMaxWaitMillis(2000);
		// the Jedis connection factory 
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
		
		// config the redis connection
		RedisStandaloneConfiguration rsc = connectionFactory.getStandaloneConfiguration();
		rsc.setHostName("127.0.0.1");
		rsc.setPort(6379);
		rsc.setPassword(RedisPassword.of("123456"));
		
		this.connectionFactory = connectionFactory;
		
		return connectionFactory;
	}
	
	@Bean(name="redisTemplate")
	public RedisTemplate<Object, Object> initRedisTemplate(){
		
		// Create RedisTemplate
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(initConnectionFactory());
		RedisSerializer<String> stringRedisSerializer = redisTemplate.getStringSerializer();
		
	    redisTemplate.setKeySerializer(stringRedisSerializer);
	    redisTemplate.setHashKeySerializer(stringRedisSerializer);
	    redisTemplate.setHashValueSerializer(stringRedisSerializer);		
		
		return redisTemplate;
	}
}
