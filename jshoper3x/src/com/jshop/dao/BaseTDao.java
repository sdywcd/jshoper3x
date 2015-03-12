package com.jshop.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;


public interface BaseTDao<T> {
	
	
	/**
	 * 持久化对象
	 * @param t
	 */
	public void save(T t);
	/**
	 * 根据持久化对象的主键获取对象
	 * @param id
	 * @return
	 */
	public T findByPK(Class<T> t,Serializable id);
	/**
	 * 获得一个对象
	 * @param hql
	 * @param param
	 * @return
	 */
	public T getByHql(String hql,Object[]param);
	/**
	 * 查询单个对象
	 * @param t
	 * @param id
	 * @return
	 */
	public T get(Class<T> t,Serializable id);

	
	/**
	 * 保存多个对象
	 * @param t
	 */
	public void saveOrUpdateAll(List<T> t);
	/**
	 * 保存或者更新单个对象
	 * @param t
	 */
	public void saveOrUpdate(T t);
	
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
	public void deleteAll(List<T>param);

	/**
	 * 根据状态查询所有数据
	 * @param t
	 * @param status
	 * @return
	 */
	public List<T>findAll(Class<T> t,String status);
	/**
	 * 查询所有数据
	 * @param t
	 * @return
	 */
	public List<T>findAll(Class<T>t);
	
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
	/**
	 * 根据hql查询
	 * @param hql
	 * @return
	 */
	public List<T> findByHql(String hql);
	/**
	 * 根据hql查询集合
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T>findByHql(String hql,Object[] param);
	/**
	 * 根据hql查询集合
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T>findByHql(String hql,List<Object>param);
	
	/**
	 * 根据hql分页查询
	 * @param hql
	 * @param param
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<T>findByHqlByPage(String hql,Object[]param,int currentPage,int lineSize);
	/**
	 * 根据hql分页查询
	 * @param hql
	 * @param param
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<T>findByHqlByPage(String hql,List<Object>param,int currentPage,int lineSize);

	/**
	 * 根据hql查询记录总数
	 * @param hql
	 * @return
	 */
	public Long count(String hql);
	
	/**
	 * 根据参数通过hql查询记录总数
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql,Object[]param);
	/**
	 * 根据参数通过hql查询记录总数
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql,List<Object>param);
	/**
	 * 执行hql返回的结果集大小
	 * @param hql
	 * @return
	 */
	public Integer executeHql(String hql);
	/**
	 * 执行hql返回的结果集大小
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql,Object[]param);
	/**
	 * 执行hql返回的结果集大小
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql,List<Object>param);
	
	
	
	/**
	 * 根据条件查询纪录总数
	 * @param t
	 * @param criterion
	 * @return
	 */
	public Long count(Class<T>t,Criterion criterion);
	/**
	 * 查询纪录总数
	 * @param t
	 * @return
	 */
	public Long count(Class<T>t);

	/**
	 * 根据criterion和order查询数据结果
	 * @param t
	 * @param criterion
	 * @param order
	 * @return
	 */
	public List<T>findByCriteria(Class<T> t,Criterion criterion,Order order);
	/**
	 * 根据criteria分页查询结果
	 * @param t
	 * @param criterion
	 * @param order
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<T>findByCriteriaByPage(Class<T>t,Criterion criterion,Order order,int currentPage,int lineSize);
	/**
	 * 分页查询信息
	 * @param t
	 * @param order
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<T>findByCriteriaByPage(Class<T>t,Order order,int currentPage,int lineSize);
	/**
	 * 根据criterion查询单个数据
	 * @param t
	 * @param criterion
	 * @return
	 */
	public T findOneByCriteria(Class<T>t,Criterion criterion);

	/**
	 * 根据criterion查询数据结果
	 * @param t
	 * @param criterion
	 * @return
	 */
	public List<T>findByCriteria(Class<T> t,Criterion criterion);
	
}
