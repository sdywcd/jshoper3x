package com.jshop.dao;

import java.io.Serializable;


public interface BaseTDao<T> {

	/**
	 * 持久化对象
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * 更新持久化对象
	 * @param t
	 */
	public void update(T t);
//	/**
//	 * 持久化或者更新对象
//	 * @param t
//	 */
//	public void saveOrUpdate(T t);
//	/**
//	 * 根据sql更新持久化对象
//	 * @param sql
//	 */
//	public void updateBySql(String sql);
//	/**
//	 * 根据hql更新持久化对象
//	 * @param hql
//	 */
//	public void updateByHql(String hql);
//	
	/**
	 * 删除持久化对象
	 * @param t
	 */
	public void delete(T t);
//	/**
//	 * 批量删除持久化对象
//	 * @param ids
//	 */
//	public void deleteAll(String []ids);
	/**
	 * 根据持久化对象的主键获取对象
	 * @param id
	 * @return
	 */
	public T findByPK(Class<T> t,Serializable id);

	
}
