package com.jshop.mongo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jshop.mongo.dao.RepositoryDao;
import com.mongodb.WriteResult;
@Repository("repositoryDao")
public class RepositoryDaoImpl<T> implements RepositoryDao<T>{
	@Resource
	private MongoTemplate mongoTemplate;
	@Override
	public void insert(T t) {
		mongoTemplate.insert(t);
	}
	@Override
	public boolean deleteById(String id,Class<T>t) {
		Criteria criteria=Criteria.where("_id").in(id);
		if(null!=criteria){
			Query query=new Query(criteria);
			List<T> list = this.findAll(query, t) ;
			if (list != null && list.size() > 0) {
				this.delete(list.get(0));
				return true;
			}
			/*if(null!=query&&this.findOne(query, t)!=null){
				this.delete(this.findOne(query, t));
				return true;
			}*/
		}
		return false;
	}
	@Override
	public void delete(T t) {
		mongoTemplate.remove(t);
		
		
	}
	@Override
	public T findOne(Query query,Class<T> t) {
		return mongoTemplate.findOne(query,t);
	}
	
	@Override
	public boolean updateFirst(Query query, Update update, Class<T> t) {
		WriteResult result=mongoTemplate.updateFirst(query, update, t);
		if(result.getN()==1){
			return true;
		}
		return false;
	}
	@Override
	public List<T> findAll(Class<T>t) {
		return mongoTemplate.findAll(t);
	}
	@Override
	public Long getCount(Query query, Class<T> t) {
		return mongoTemplate.count(query, t);
	}
	@Override
	public List<T> findAll(Query query, Class<T> t) {
		return mongoTemplate.find(query, t);
	}
	@Override
	public List<T> findByPage(Query query, int currentPage, int lineSize,Class<T>t) {
		query.skip((currentPage - 1) * lineSize);
		query.limit(lineSize);
		return mongoTemplate.find(query, t);
	}
	@Override
	public T findAndModify(Query query,Update update,Class<T> t) {
		return mongoTemplate.findAndModify(query, update, t);
	}
	@Override
	public void saveOrUpdate(T t) {
		mongoTemplate.save(t);
	}
	@Override
	public boolean updateMulti(Query query, Update update, Class<T> t) {
		WriteResult result=mongoTemplate.updateMulti(query, update, t);
		if(result.getN()>=1){
			return true;
		}
		return false;
	}
	@Override
	public boolean upsert(Query query, Update update, Class<T> t) {
		WriteResult result=mongoTemplate.upsert(query, update, t);
		if(result.getN()>=1){
			return true;
		}
		return false;
	}
	@Override
	public void drop(Class<T> t) {
		mongoTemplate.dropCollection(t);
		
	}

	
	

}
