package com.example.redis_sample.sample;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisSampleService {
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;

	// redis에 데이터를 저장
    public void save(String key, Object value) {
        redisTemplate.opsForValue().set(key, value, 60, TimeUnit.MINUTES); // 60분 동안 유효
    }

    // redis에서 특정 데이터 검색
    public Object find(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // redis에 저장된 데이터 삭제
    public void delete(String key) {
        redisTemplate.delete(key);
    }
    
    // 모든 데이터 조회
    public Set<String> findAllKeys() {
        return redisTemplate.keys("*");
    }

}
