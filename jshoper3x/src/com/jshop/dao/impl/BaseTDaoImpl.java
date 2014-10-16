package com.jshop.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.BaseTDao;
@Repository("baseTDao")
public class BaseTDaoImpl<T> extends HibernateDaoSupport implements BaseTDao<T> {
	private static final Logger log = LoggerFactory.getLogger(BaseTDaoImpl.class);


	@Override
	public void save(T t) {
		try{
			this.getHibernateTemplate().save(t);
		}catch(RuntimeException re){
			log.error("save "+t.getClass().getName()+" error", re);
			throw re;
		}
	}

	@Override
	public void update(T t) {
		try{
			this.getHibernateTemplate().update(t);
		}catch(RuntimeException re){
			log.error("update "+t.getClass().getName()+" error",re);
		}
		
	}

	@Override
	public void delete(T t) {
		try{
			this.getHibernateTemplate().delete(t);
		}catch(RuntimeException re){
			log.error("delete "+t.getClass().getName()+" error",re);
		}
	}
	
	@Override
	public T findByPK(Class<T>t, Serializable id) {
		return (T) this.getHibernateTemplate().get(t, id);
	
	}

	@Override
	public List<T> findAll(Class<T> t, String status) {
		log.debug("findAll"+t.getName());
		try {
			String queryString = "from "+t.getName()+" as t where t.status=:status";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "status", status);
			return list;
		} catch (RuntimeException re) {
			log.error("findAll"+t.getName()+"error", re);
			throw re;
		}
	}

	@Override
	public List<T> findAll(final Class<T> t, final int currentPage, final int lineSize) {
		log.debug("find all "+t.getName());
		try {
			List<T> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from "+t.getName()+" order by createtime desc";

				@SuppressWarnings("unchecked")
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List<T> list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all "+t.getName()+" error", re);
			throw re;
		}
	}

	@Override
	public int countfindAll(Class<T> t) {
		log.debug("countfindAll"+t.getName());
		try {
			String queryString = "select count(*) from "+t.getName();
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAll"+t.getName()+"error", re);
			throw re;
		}
	}

	@Override
	public int deleteAll(Class<T> t, final String[] ids) {
		log.debug("deleteAll"+t.getName());
		try {
			final String queryString = "delete from "+t.getName()+" as d where d.id=:id";
			Integer integer=(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i=0;
					for (String s : ids) {
						query.setParameter("id", s);
						i=query.executeUpdate();
					}
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("deleteAll"+t.getName()+"error", re);
			throw re;
		}
	}

	@Override
	public List<T> findAllByShopId(final Class<T> t, final String shopId, final int currentPage,
			final int lineSize) {
		log.debug("find all "+t.getName()+"by shopid");
		try {
			List<T> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from "+t.getName()+" as t where t.shopid=:shopid  order by createtime desc";

				@SuppressWarnings("unchecked")
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("shopid", shopId);
					List<T> list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all "+t.getName()+"by shopid error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllByShopId(Class<T> t, String shopId) {
		log.debug("countfindAll"+t.getName());
		try {
			String queryString = "select count(*) from "+t.getName()+" as t where t.shopid=:shopid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "shopid", shopId);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAll"+t.getName()+"error", re);
			throw re;
		}
	}

	@Override
	public void saveOrUpdateAll(List<T> t) {
		try{
			this.getHibernateTemplate().saveOrUpdateAll(t);
		}catch(RuntimeException re){
			log.error("save "+t.getClass().getName()+" error", re);
			throw re;
		}
	}

}
