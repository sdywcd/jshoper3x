package com.jshop.mongo.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.mongo.dao.AbstractRepositoryDao;
import com.jshop.mongo.service.AbstractRepositoryService;
@Service("abstractRepositoryService")
@Scope("prototype")
public class AbstractRepositoryServiceImpl<T> implements AbstractRepositoryService<T> {
	@Resource
	private AbstractRepositoryDao<T> abstractRepositoryDao;
	@Override
	public void insert(T t) {
		abstractRepositoryDao.insert(t);
	}

}
