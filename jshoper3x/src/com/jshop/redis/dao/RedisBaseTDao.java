package com.jshop.redis.dao;


public interface RedisBaseTDao<T> {
	/**
	 * 将对象保存至内存
	 * @param t
	 */
	public void put(String key,T t,Class<T>cls);

	/**
	 * 从内存中读取单个对象
	 * @param t
	 * @param id
	 * @return
	 */
	public T get(String key,Class<T> cls);
	
}
