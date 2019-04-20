package com.springboot.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate = null;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate = null;

	@RequestMapping("/stringAndHash")
	@ResponseBody
	public Map<String, Object> testStringAndHash(){
		redisTemplate.opsForValue().set("key1", "value1");
		redisTemplate.opsForValue().set("int_key", "1");
		redisTemplate.opsForValue().set("int", "1");
		stringRedisTemplate.opsForValue().increment("int", 1);

		Jedis jedis = (Jedis)stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		jedis.decr("int");

		Map<String, String> hash = new HashMap<String, String>();
		hash.put("field1", "Value1");
		hash.put("field2", "Value2");

		stringRedisTemplate.opsForHash().putAll("hash", hash);
		stringRedisTemplate.opsForHash().put("hash", "field3", "value3");
		BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
		hashOps.delete("field1", "field2");

		hashOps.put("field4", "value5");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		return map;
	}
}
