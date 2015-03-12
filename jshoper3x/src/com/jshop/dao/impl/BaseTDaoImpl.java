package com.jshop.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.BaseTDao;

@Repository("baseTDao")
public class BaseTDaoImpl<T> implements BaseTDao<T> {
	private static final Logger log = LoggerFactory
			.getLogger(BaseTDaoImpl.class);
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		this.getCurrentSession().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByPK(Class<T> t, Serializable id) {
		return (T) this.getCurrentSession().get(t, id);
	}

	@Override
	public T getByHql(String hql, Object[] param) {
		List<T> list = this.findByHql(hql, param);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public T get(Class<T> t, Serializable id) {
		return (T) this.getCurrentSession().get(t, id);
	}

	@Override
	public void saveOrUpdateAll(List<T> t) {
		for (T param : t) {
			this.getCurrentSession().saveOrUpdate(param);
		}
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void update(T t) {
		this.getCurrentSession().update(t);
	}

	@Override
	public void delete(T t) {
		this.getCurrentSession().delete(t);
	}

	@Override
	public void deleteAll(List<T> param) {
		for (T p : param) {
			this.getCurrentSession().delete(p);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> t, String status) {
		Criteria criteria = this.getCurrentSession().createCriteria(t);
		criteria.add(Restrictions.eq("status", status));
		List<T> list = criteria.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> t, int currentPage, int lineSize) {
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (lineSize < 1) {
			lineSize = 20;
		}
		Criteria criteria = this.getCurrentSession().createCriteria(t);
		return criteria.setFirstResult((currentPage - 1) * lineSize)
				.setMaxResults(lineSize).list();
	}

	@Override
	public int countfindAll(Class<T> t) {
		return (int) this.getCurrentSession().createCriteria(t).list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByShopId(Class<T> t, String shopId, int currentPage,
			int lineSize) {
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (lineSize < 1) {
			lineSize = 20;
		}
		Criteria criteria = this.getCurrentSession().createCriteria(t);
		criteria.add(Restrictions.eq("shopId", shopId));
		return criteria.setFirstResult((currentPage - 1) * lineSize)
				.setMaxResults(lineSize).list();
	}

	@Override
	public int countfindAllByShopId(Class<T> t, String shopId) {
		return (int) this.getCurrentSession().createCriteria(t)
				.add(Restrictions.eq("shopId", shopId)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHql(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHql(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			int length = param.length;
			for (int i = 0; i < length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHql(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			int size = param.size();
			for (int i = 0; i < size; i++) {
				query.setParameter(i, param.get(i));
			}
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHqlByPage(String hql, Object[] param, int currentPage,
			int lineSize) {
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (lineSize < 1) {
			lineSize = 20;
		}
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			int length = param.length;
			for (int i = 0; i < length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.setFirstResult((currentPage - 1) * lineSize)
				.setMaxResults(lineSize).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHqlByPage(String hql, List<Object> param,
			int currentPage, int lineSize) {
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (lineSize < 1) {
			lineSize = 20;
		}
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			int size = param.size();
			for (int i = 0; i < size; i++) {
				query.setParameter(i, param.get(i));
			}
		}
		return query.setFirstResult((currentPage - 1) * lineSize)
				.setMaxResults(lineSize).list();
	}

	@Override
	public Long count(String hql) {
		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	@Override
	public Long count(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			int length = param.length;
			for (int i = 0; i < length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return (Long) query.uniqueResult();
	}

	@Override
	public Long count(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			int size = param.size();
			for (int i = 0; i < size; i++) {
				query.setParameter(i, param.get(i));
			}
		}
		return (Long) query.uniqueResult();
	}

	@Override
	public Integer executeHql(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public Integer executeHql(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			int length = param.length;
			for (int i = 0; i < length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.executeUpdate();
	}

	@Override
	public Integer executeHql(String hql, List<Object> param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			int size = param.size();
			for (int i = 0; i < size; i++) {
				query.setParameter(i, param.get(i));
			}
		}
		return query.executeUpdate();
	}


	@Override
	public Long count(Class<T> t, Criterion criterion) {
		Criteria criteria=this.getCurrentSession().createCriteria(t);
		criteria.add(criterion);
		return (long) criteria.list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> t) {
		Criteria criteria = this.getCurrentSession().createCriteria(t);
		List<T> list = criteria.list();
		return list;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(Class<T> t,Criterion criterion, Order order) {
		return this.getCurrentSession().createCriteria(t)
				.add(criterion).addOrder(order).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteriaByPage(Class<T> t, Criterion criterion,Order order,
			int currentPage, int lineSize) {
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (lineSize < 1) {
			lineSize = 20;
		}
		
		Criteria criteria=this.getCurrentSession().createCriteria(t);
		criteria.add(criterion);
		criteria.addOrder(order);
		criteria.setMaxResults(lineSize);
		criteria.setFirstResult((currentPage-1)*lineSize);
		List<T>list=criteria.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOneByCriteria(Class<T> t, Criterion criterion) {
		List<T> list=this.getCurrentSession().createCriteria(t).add(criterion).list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(Class<T> t, Criterion criterion) {
		return this.getCurrentSession().createCriteria(t)
				.add(criterion).list();
	}

	@Override
	public Long count(Class<T> t) {
		Criteria criteria=this.getCurrentSession().createCriteria(t);
		return (long) criteria.list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteriaByPage(Class<T> t, Order order,
			int currentPage, int lineSize) {
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (lineSize < 1) {
			lineSize = 20;
		}
		Criteria criteria=this.getCurrentSession().createCriteria(t);
		criteria.addOrder(order);
		criteria.setMaxResults(lineSize);
		criteria.setFirstResult((currentPage-1)*lineSize);
		List<T>list=criteria.list();
		return list;
	}


}
