package com.jshop.mongo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * mongodb 基础操作
 * @author JC
 *
 */
public interface RepositoryDao<T> {

	/**
	 * 插入对象
	 * @param t
	 */
	public void insert(T t);
	
	/**
	 * 根据id删除对象
	 * @param id
	 * @return
	 */
	public boolean deleteById(String id,Class<T>t);
	/**
	 * 删除对象
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 根据条件查询单个对象数据
	 * @param query
	 * @return
	 */
	public T findOne(Query query,Class<T> t);
	/**
	 * 根据条件更新一个对象
	 * @param query
	 * @param update
	 * @param t
	 * @return
	 */
	public boolean updateFirst(Query query,Update update,Class<T>t);
	/**
	 * 查询所有数据
	 * @param t
	 * @return
	 */
	public List<T>findAll(Class<T>t);
	/**
	 * 查询总记录数
	 * @param query
	 * @param t
	 * @return
	 */
	public Long getCount(Query query,Class<T>t);
	/**
	 * 根据条件查询所有数据
	 * @param query
	 * @param t
	 * @return
	 */
	public List<T>findAll(Query query,Class<T>t);
	
	/**
	 * 根据条件分页查询所有数据
	 * @param query
	 * @param t
	 * @return
	 */
	public List<T>findByPage(Query query,int currentPage,int lineSize,Class<T>t);
	
	/**
	 * 返回更新后的数据
	 * @param t
	 * @return
	 */
	public T findAndModify(Query query,Update update,Class<T>t);
	/**
	 * 保存对象，如果对象存在就更新对象，如果对象不存在则保存对象
	 * @param t
	 */
	public void saveOrUpdate(T t);
	/**
	 * 根据条件更新多个对象
	 * @param query
	 * @param update
	 * @param t
	 * @return
	 */
	public boolean updateMulti(Query query,Update update,Class<T>t);
	/**
	 * 更新对象，如果对象不存在则插入对象
	 * @param query
	 * @param update
	 * @param t
	 * @return
	 */
	public boolean upsert(Query query,Update update,Class<T>t);
	/**
	 * 删除表
	 * @param t
	 */
	public void drop(Class<T>t);


}
