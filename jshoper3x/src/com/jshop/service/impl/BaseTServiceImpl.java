package com.jshop.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

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
	public void save(T t) {
		baseTDao.save(t);
	}

	@Override
	public void update(T t) {
		baseTDao.update(t);
	}

	@Override
	public void delete(T t) {
		baseTDao.delete(t);
	}

	@Override
	public T findByPK(Class<T> t, Serializable id) {
		return baseTDao.findByPK(t, id);
	}

	@Override
	public List<T> findAll(Class<T> t, String status) {
		return baseTDao.findAll(t, status);
	}

	@Override
	public List<T> findAll(Class<T> t, int currentPage, int lineSize) {
		return baseTDao.findAll(t, currentPage, lineSize);
	}

	@Override
	public int countfindAll(Class<T> t) {
		return baseTDao.countfindAll(t);
	}

	@Override
	public int deleteAll(Class<T> t, String[] ids) {
		return baseTDao.deleteAll(t, ids);
	}

	@Override
	public List<T> findAllByShopId(Class<T> t, String shopId, int currentPage,
			int lineSize) {
		return baseTDao.findAllByShopId(t, shopId, currentPage, lineSize);
	}

	@Override
	public int countfindAllByShopId(Class<T> t, String shopId) {
		return baseTDao.countfindAllByShopId(t, shopId);
	}

	@Override
	public void saveOrUpdateAll(List<T> t) {
		baseTDao.saveOrUpdateAll(t);
	}

	

}
