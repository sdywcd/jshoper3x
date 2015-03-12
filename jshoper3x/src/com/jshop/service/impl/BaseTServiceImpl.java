package com.jshop.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.BaseTDao;
import com.jshop.service.BaseTService;


@Service("baseTService")
@Scope("prototype")
public class BaseTServiceImpl<T> implements BaseTService<T>{
	@Resource
	private BaseTDao<T> baseTDao;

	@Override
	@Transactional
	public void save(T t) {
		baseTDao.save(t);
	}

	@Override
	@Transactional
	public T findByPK(Class<T> t, Serializable id) {
		return baseTDao.findByPK(t, id);
	}

	@Override
	@Transactional
	public T getByHql(String hql, Object[] param) {
		return baseTDao.getByHql(hql, param);
	}

	@Override
	@Transactional
	public T get(Class<T> t, Serializable id) {
		return baseTDao.get(t, id);
	}

	@Override
	@Transactional
	public void saveOrUpdateAll(List<T> t) {
		baseTDao.saveOrUpdateAll(t);
	}

	@Override
	@Transactional
	public void saveOrUpdate(T t) {
		baseTDao.saveOrUpdate(t);
	}

	@Override
	@Transactional
	public void update(T t) {
		baseTDao.update(t);
	}

	@Override
	@Transactional
	public void delete(T t) {
		baseTDao.delete(t);
	}

	@Override
	@Transactional
	public void deleteAll(List<T> param) {
		baseTDao.deleteAll(param);
	}

	@Override
	@Transactional
	public List<T> findAll(Class<T> t, String status) {
		return baseTDao.findAll(t, status);
	}

	@Override
	@Transactional
	public List<T> findAll(Class<T> t, int currentPage, int lineSize) {
		return baseTDao.findAll(t, currentPage, lineSize);
	}

	@Override
	@Transactional
	public int countfindAll(Class<T> t) {
		return baseTDao.countfindAll(t);
	}

	@Override
	@Transactional
	public List<T> findAllByShopId(Class<T> t, String shopId, int currentPage,
			int lineSize) {
		return baseTDao.findAllByShopId(t, shopId, currentPage, lineSize);
	}

	@Override
	@Transactional
	public int countfindAllByShopId(Class<T> t, String shopId) {
		return baseTDao.countfindAllByShopId(t, shopId);
	}

	@Override
	@Transactional
	public List<T> findByHql(String hql) {
		return baseTDao.findByHql(hql);
	}

	@Override
	@Transactional
	public List<T> findByHql(String hql, Object[] param) {
		return baseTDao.findByHql(hql, param);
	}

	@Override
	@Transactional
	public List<T> findByHql(String hql, List<Object> param) {
		return baseTDao.findByHql(hql, param);
	}

	@Override
	@Transactional
	public List<T> findByHqlByPage(String hql, Object[] param, int currentPage,
			int lineSize) {
		return baseTDao.findByHqlByPage(hql, param, currentPage, lineSize);
	}

	@Override
	@Transactional
	public List<T> findByHqlByPage(String hql, List<Object> param,
			int currentPage, int lineSize) {
		return baseTDao.findByHqlByPage(hql, param, currentPage, lineSize);
	}

	@Override
	@Transactional
	public Long count(String hql) {
		return baseTDao.count(hql);
	}

	@Override
	@Transactional
	public Long count(String hql, Object[] param) {
		return baseTDao.count(hql, param);
	}

	@Override
	@Transactional
	public Long count(String hql, List<Object> param) {
		return baseTDao.count(hql, param);
	}

	@Override
	@Transactional
	public Integer executeHql(String hql) {
		return baseTDao.executeHql(hql);
	}

	@Override
	@Transactional
	public Integer executeHql(String hql, Object[] param) {
		return baseTDao.executeHql(hql, param);
	}

	@Override
	@Transactional
	public Integer executeHql(String hql, List<Object> param) {
		return baseTDao.executeHql(hql, param);
	}



	@Override
	@Transactional
	public List<T> findAll(Class<T> t) {
		return baseTDao.findAll(t);
	}

	

	@Override
	@Transactional
	public T findOneByCriteria(Class<T> t,Criterion criterion) {
		return baseTDao.findOneByCriteria(t, criterion);
	}

	@Override
	@Transactional
	public Long count(Class<T> t, Criterion criterion) {
		return baseTDao.count(t, criterion);
	}

	@Override
	@Transactional
	public List<T> findByCriteria(Class<T> t, Criterion criterion, Order order) {
		return baseTDao.findByCriteria(t, criterion, order);
	}

	@Override
	@Transactional
	public List<T> findByCriteriaByPage(Class<T> t, Criterion criterion,
			Order order, int currentPage, int lineSize) {
		return baseTDao.findByCriteriaByPage(t, criterion, order, currentPage, lineSize);
	}

	@Override
	@Transactional
	public List<T> findByCriteria(Class<T> t, Criterion criterion) {
		return baseTDao.findByCriteria(t, criterion);
	}

	@Override
	@Transactional
	public Long count(Class<T> t) {
		return baseTDao.count(t);
	}

	@Override
	@Transactional
	public List<T> findByCriteriaByPage(Class<T> t, Order order,
			int currentPage, int lineSize) {
		return baseTDao.findByCriteriaByPage(t, order, currentPage, lineSize);
	}


	

}
