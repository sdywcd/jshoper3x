package com.jshop.mongo.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.jshop.mongo.dao.AbstractRepositoryDao;
@Repository("abstractRepositoryDao")
public class AbstractRepositoryDaoImpl<T> implements  AbstractRepositoryDao<T>{
	@Resource
	private MongoTemplate mongoTemplate;
	@Override
	public void insert(T t) {
		mongoTemplate.insert(t);
	}

}
