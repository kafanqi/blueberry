package com.jiafly.blueberry.common.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Redis 工具类
 *
 * @author liuyi
 */
@Component
public class RedisUtils {

    private final RedisTemplate redisTemplate;

    public RedisUtils(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
