package com.jshop.mongo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.jshop.mongo.dao.RepositoryDao;
import com.jshop.mongo.service.RepositoryService;
@Service("repositoryService")
@Scope("prototype")
public class RepositoryServiceImpl<T> implements RepositoryService<T> {
	@Resource
	private RepositoryDao<T> repositoryDao;
	@Override
	public void insert(T t) {
		repositoryDao.insert(t);
	}
	@Override
	public boolean deleteById(String id, Class<T> t) {
		return repositoryDao.deleteById(id, t);
	}
	@Override
	public void delete(T t) {
		repositoryDao.delete(t);
		
	}
	@Override
	public T findOne(Query query, Class<T> t) {
		return repositoryDao.findOne(query, t);
	}
	@Override
	public boolean updateFirst(Query query, Update update, Class<T> t) {
		return repositoryDao.updateFirst(query, update, t);
	}
	@Override
	public List<T> findAll(Class<T> t) {
		return repositoryDao.findAll(t);
	}
	@Override
	public Long getCount(Query query, Class<T> t) {
		return repositoryDao.getCount(query, t);
	}
	@Override
	public List<T> findAll(Query query, Class<T> t) {
		return repositoryDao.findAll(query, t);
	}
	@Override
	public List<T> findByPage(Query query, int currentPage, int lineSize,
			Class<T> t) {
		return repositoryDao.findByPage(query, currentPage, lineSize, t);
	}
	@Override
	public T findAndModify(Query query, Update update, Class<T> t) {
		return repositoryDao.findAndModify(query, update, t);
	}
	@Override
	public void saveOrUpdate(T t) {
		repositoryDao.saveOrUpdate(t);
	}
	@Override
	public boolean updateMulti(Query query, Update update, Class<T> t) {
		return repositoryDao.updateMulti(query, update, t);
	}
	@Override
	public boolean upsert(Query query, Update update, Class<T> t) {
		return repositoryDao.upsert(query, update, t);
	}
	@Override
	public void drop(Class<T> t) {
		repositoryDao.drop(t);
		
	}

}
