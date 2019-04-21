package com.springboot.demo.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
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
		
		// get the native connection with Jedis
		Jedis jedis = (Jedis)stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		// decrease by 1, which is supported by Jedis, but not supported by RedisTemplate
		jedis.decr("int");

		Map<String, String> hash = new HashMap<String, String>();
		hash.put("field1", "Value1");
		hash.put("field2", "Value2");
		
		// 
		stringRedisTemplate.opsForHash().putAll("hash", hash);
		stringRedisTemplate.opsForHash().put("hash", "field3", "value3");
		BoundHashOperations<String, String, String> hashOps = stringRedisTemplate.boundHashOps("hash");
		hashOps.delete("field1", "field2");

		hashOps.put("field4", "value5");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		return map;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> testList() {
		// 插入两个列表,注意它们再链表的顺序
		// 链表从左到右顺序为v10,v8,v6,v4,v2
		stringRedisTemplate.opsForList().leftPushAll("list1", "v2", "v4", "v6", "v8", "v10");
		// 链表从左到右顺序为v1,v2,v3,v4,v5,v6
		stringRedisTemplate.opsForList().rightPushAll("list2", "v1", "v2", "v3", "v4", "v5", "v6");
		// 绑定list2链表操作
		BoundListOperations<String, String> listOps = stringRedisTemplate.boundListOps("list2");
		// 从右边弹出一个成员
		Object result1 = listOps.rightPop();
		// 获取定位元素，Redis从0开始计算,这里值为v2
		Object result2 = listOps.index(1);
		// 从左边插入链表
		listOps.leftPush("v0");
		// 求链表长度
		Long size = listOps.size();
		// 求链表下标区间成员，整个链表下标范围为0到size-1，这里不取最后一个元素
		List elements = listOps.range(0, size - 2);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		return map;
	}
	
	@RequestMapping("/zset")
	@ResponseBody
	public Map<String, Object> testZset() {
		Set<TypedTuple<String>> typedTupleSet = new HashSet<>();
		for (int i = 1; i <= 9; i++) {
			// 分数
			double score = i * 0.1;
			// 创建一个TypedTuple对象，存入值和分数
			TypedTuple<String> typedTuple = new DefaultTypedTuple<String>("value" + i, score);
			typedTupleSet.add(typedTuple);
		}
		// 往有序集合插入元素
		stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
		// 绑定zset1有序集合操作
		BoundZSetOperations<String, String> zsetOps = stringRedisTemplate.boundZSetOps("zset1");
		// 增加一个元素
		zsetOps.add("value10", 0.26);
		Set<String> setRange = zsetOps.range(1, 6);
		// 按分数排序获取有序集合
		Set<String> setScore = zsetOps.rangeByScore(0.2, 0.6);
		// 定义值范围
		Range range = new Range();
		range.gt("value3");// 大于value3
		// range.gte("value3");// 大于等于value3
		// range.lt("value8");// 小于value8
		range.lte("value8");// 小于等于value8
		// 按值排序，请注意这个排序是按字符串排序
		Set<String> setLex = zsetOps.rangeByLex(range);
		// 删除元素
		zsetOps.remove("value9", "value2");
		// 求分数
		Double score = zsetOps.score("value8");
		// 在下标区间下，按分数排序，同时返回value和score
		Set<TypedTuple<String>> rangeSet = zsetOps.rangeWithScores(1, 6);
		// 在分数区间下，按分数排序，同时返回value和score
		Set<TypedTuple<String>> scoreSet = zsetOps.rangeByScoreWithScores(1, 6);
		// 按从大到小排序
		Set<String> reverseSet = zsetOps.reverseRange(2, 8);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		return map;
	}
}
