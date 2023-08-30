package com.ppl.toyboard.root.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "classpath:test-Business-layer.xml")
public class RedisConnectionTest {
	
	 @Autowired
	    private RedisTemplate<String, String> redisTemplate;

	    @Test
	    public void testRedisConnection() {
	        // Given
	        String key = "testKey";
	        String value = "testValue";

	        // When
	        redisTemplate.opsForValue().set(key, value);
	        String retrievedValue = redisTemplate.opsForValue().get(key);

	        // Then
	        assertEquals(value, retrievedValue);
	    }
}
