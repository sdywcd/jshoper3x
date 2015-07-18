package com.jshop.redis.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.redis.dao.RedisBaseTDao;
import com.jshop.redis.service.RedisBaseTService;
@Service("redisBaseTService")
@Scope("prototype")
public class RedisBaseTServiceImpl<T> implements RedisBaseTService<T> {
	@Resource
	private RedisBaseTDao<T> redisBaseTDao;
	
	@Override
	public void put(String key, T t, Class<T> cls) {
		redisBaseTDao.put(key, t, cls);
		
	}

	@Override
	public T get(String key, Class<T> cls) {
		return redisBaseTDao.get(key, cls);
	}

	@Override
	public void put(String key, T t, Class<T> cls, long timeout, TimeUnit timeUnit) {
		redisBaseTDao.put(key, t, cls, timeout, timeUnit);
	}

	@Override
	public void delete(String key) {
		redisBaseTDao.delete(key);
	}

	@Override
	public void delete(List<String> keys) {
		redisBaseTDao.delete(keys);
	}

}
