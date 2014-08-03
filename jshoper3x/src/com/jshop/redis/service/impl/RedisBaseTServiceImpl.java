package com.jshop.redis.service.impl;

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

}
