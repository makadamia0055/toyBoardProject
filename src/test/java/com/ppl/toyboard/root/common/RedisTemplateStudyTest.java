package com.ppl.toyboard.root.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "classpath:test-Business-layer.xml")
public class RedisTemplateStudyTest {
	
	 @Autowired
	    private StringRedisTemplate redisTemplate;

	    @Test
	    public void testStrings() {
	    	final String key = "makmunwui";
	    	
	    	final ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
	    	stringStringValueOperations.set(key, "1"); // redis set 명령어
	    	final String result_1 = stringStringValueOperations.get(key);
	    	System.out.println("result_1 : " + result_1);
	    	
	    	stringStringValueOperations.increment(key);// redis incr 명령어
	    	final String result_2 = stringStringValueOperations.get(key);
	    	
	    	System.out.println("result_2 : " + result_2);
	    }
	    
	    @Test
	    public void testList() {
	    	final String key = "makforList";
	    	
	    	final ListOperations<String, String> stringStringListOperations = redisTemplate.opsForList();
	    	stringStringListOperations.rightPush(key, "H");
	    	stringStringListOperations.rightPush(key, "e");
	    	stringStringListOperations.rightPush(key, "l");
	    	stringStringListOperations.rightPush(key, "l");
	    	stringStringListOperations.rightPush(key, "o");
	    	
	    	stringStringListOperations.rightPushAll(key, " ", "m", "a", "n");
	    	
	    	final String character_1 = stringStringListOperations.index(key, 1);
	    	
	    	System.out.println("character_1 :" + character_1);
	    	final Long size = stringStringListOperations.size(key);
	    	
	    	System.out.println("size : " + size);
	    	
	    	final List<String> resultRange = stringStringListOperations.range(key, 0, 9);
	    	System.out.println("resultRange : " + Arrays.toString(resultRange.toArray()));

	    }
	    @Test
	    public void testHash() {
	    	String key = "momo";
	    	HashOperations<String, Object, Object> stringObjectObjectHashOperations = redisTemplate.opsForHash();
	    	
	    	stringObjectObjectHashOperations.put(key, "hello", "momo");
	    	stringObjectObjectHashOperations.put(key, "hello2", "momo2");
	    	stringObjectObjectHashOperations.put(key, "hello3", "momo3");
	    	
	    	Object hello = stringObjectObjectHashOperations.get(key, "Hello");
	    	System.out.println("hello = " + hello);
	    	
	    	Map<Object, Object> entries = stringObjectObjectHashOperations.entries(key);
	    	System.out.println("entires : " + entries.get("hello"));
	    	
	    	Long size = stringObjectObjectHashOperations.size(key);
	    	
	    	System.out.println("size : " + size);
	    }
}
