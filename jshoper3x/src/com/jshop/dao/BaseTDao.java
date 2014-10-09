package com.jshop.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public interface BaseTDao<T> {

	/**
	 * 根据持久化对象的主键获取对象
	 * @param id
	 * @return
	 */
	public T findByPK(Class<T> t,Serializable id);
	/**
	 * 持久化对象
	 * @param t
	 */
	public void save(T t);
	/**
	 * 保存多个对象
	 * @param t
	 */
	public void saveOrUpdateAll(List<T> t);
	
	/**
	 * 更新持久化对象
	 * @param t
	 */
	public void update(T t);
	/**
	 * 删除持久化对象
	 * @param t
	 */
	public void delete(T t);
	/**
	 * 批量删除持久化对象
	 * @param ids
	 */
	public int deleteAll(Class<T> t,String []ids);
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
	 * 根据状态查询所有数据
	 * @param t
	 * @param status
	 * @return
	 */
	public List<T>findAll(Class<T> t,String status);
	
	/**
	 * 分页查询所有记录
	 * @param t
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<T>findAll(Class<T> t,int currentPage,int lineSize);
	/**
	 * 查询记录总数
	 * @param t
	 * @return
	 */
	public int countfindAll(Class<T>t);
	/**
	 * 根据店铺Id分页查询信息
	 * @param t
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<T>findAllByShopId(Class<T>t,String shopId,int currentPage,int lineSize);
	/**
	 * 统计根据店铺Id分页查询信息
	 * @param t
	 * @param shopId
	 * @return
	 */
	public int countfindAllByShopId(Class<T>t,String shopId);
	
	
}
