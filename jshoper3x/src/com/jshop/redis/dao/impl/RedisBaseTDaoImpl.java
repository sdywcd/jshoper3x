package com.jshop.redis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Repository;

import com.jshop.redis.dao.RedisBaseTDao;

@Repository("redisBaseTDao")
public class RedisBaseTDaoImpl<T> implements RedisBaseTDao<T> {
	@Autowired
	private RedisTemplate<String, T> redisTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public void put(String key, final T t, Class<T> cls) {
		redisTemplate.opsForHash().put(cls.getName(), key, t);
	}

	@Override
	public T get(String key, Class<T> cls) {
		return (T) redisTemplate.opsForHash().get(cls.getName(), key);
	}

}
