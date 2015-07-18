package com.jshop.redis.dao.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.jshop.redis.dao.RedisBaseTDao;

@Repository("redisBaseTDao")
public class RedisBaseTDaoImpl<T> implements RedisBaseTDao<T> {
	@Autowired
	private RedisTemplate<String, T> redisTemplate;

	@Override
	public void put(String key, final T t, Class<T> cls) {
		redisTemplate.opsForHash().put(cls.getName(), key, t);
	}

	@Override
	public T get(String key, Class<T> cls) {
		return (T) redisTemplate.opsForHash().get(cls.getName(), key);
	}

	@Override
	public void put(String key, T t, Class<T> cls, long timeout,TimeUnit timeUnit) {
		redisTemplate.opsForHash().put(cls.getName(), key, t);
		redisTemplate.expire(key, timeout, timeUnit);
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void delete(List<String> keys) {
		redisTemplate.delete(keys);
	}


}
