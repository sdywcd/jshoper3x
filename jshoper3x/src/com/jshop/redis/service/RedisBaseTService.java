package com.jshop.redis.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface RedisBaseTService<T> {
	/**
	 * 将对象保存至内存
	 * 
	 * @param t
	 */
	public void put(String key, T t, Class<T> cls);

	/**
	 * 从内存中读取单个对象
	 * 
	 * @param t
	 * @param id
	 * @return
	 */
	public T get(String key, Class<T> cls);

	/**
	 * 将对象保存至内存，并设定失效时间
	 * 
	 * @param key
	 * @param t
	 * @param cls
	 * @param timeout 失效时间
	 * @param timeUnit 时间单位
	 */
	public void put(String key, T t, Class<T> cls, long timeout,TimeUnit timeUnit);
	/**
	 * 删除内存中的key
	 * @param key
	 */
	public void delete(String key);
	/**
	 * 删除内存中的多个key
	 * @param keys
	 */
	public void delete(List<String>keys);
}
