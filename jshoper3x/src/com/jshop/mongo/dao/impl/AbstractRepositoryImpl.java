package com.jshop.mongo.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.jshop.mongo.dao.AbstractRepository;
@Repository("abstractRepository")
public class AbstractRepositoryImpl<T> implements  AbstractRepository<T>{
	@Resource
	private MongoTemplate mongoTemplate;
	@Override
	public void insert(T t) {
		mongoTemplate.insert(t);
	}

}
