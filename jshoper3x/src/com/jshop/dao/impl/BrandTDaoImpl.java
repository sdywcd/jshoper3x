package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.BrandTDao;
import com.jshop.entity.BrandT;

/**
 * A data access object (DAO) providing persistence and search support for
 * BrandT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.BrandT
 * @author MyEclipse Persistence Tools
 */
@Repository("brandTDao")
public class BrandTDaoImpl<T> extends BaseTDaoImpl<BrandT> implements BrandTDao {
	
	private static final Log log = LogFactory.getLog(BrandTDaoImpl.class);
	

	public void delBrandt(final String[] strs, final String creatorid) {
		log.debug("del brandt");
		try {
			final String queryString = "from BrandT as bt where bt.brandid=:brandid and bt.creatorid=:creatorid";
			for(String s:strs){
				List<BrandT>list=this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"brandid","creatorid"}, new Object[]{s,creatorid});
				this.getHibernateTemplate().delete(list.get(0));
			}
		} catch (RuntimeException re) {
			log.error("del brandt failed", re);
			throw re;
		}
	}

	public void updateBrandt(final BrandT bt) {
		log.debug("update BrandT");
		try {
			this.getHibernateTemplate().update(bt);
		} catch (RuntimeException re) {
			log.error("update  BrandT error", re);
			throw re;
		}
	}

	public int countfindAllBrandt(String creatorid) {
		log.debug("count all brand");
		try {
			String queryString = "select count(*) from BrandT as bt where bt.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all brand error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<BrandT> findAllBrandt(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("find all brand");
		try {
			List<BrandT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from BrandT as bt where bt.creatorid=:creatorid order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all brand error", re);
			throw re;
		}
	}

	public List<BrandT> findAllBrandt() {
		log.debug("find all brandt json");
		try {
			String queryString = "from BrandT as bt order by createtime desc";
			List<BrandT> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find all brandt json error", re);
			throw re;
		}
	}

	public BrandT findBrandById(String brandid) {
		log.debug("find by id brand");
		try {
			String queryString = "from BrandT as bt where bt.brandid=:brandid";
			List<BrandT> list = this.getHibernateTemplate().findByNamedParam(queryString, "brandid", brandid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id brand error", re);
			throw re;
		}

	}

	@SuppressWarnings("unchecked")
	public List<BrandT> sortAllBrandt(final int currentPage, final int lineSize,
				final String creatorid, final String queryString) {		
			try {
				List<BrandT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(queryString);
						query.setFirstResult((currentPage - 1) * lineSize);
						query.setMaxResults(lineSize);
						query.setParameter("creatorid", creatorid);
						List list = query.list();
						return list;

					}
				});
				if (list.size() > 0 && list != null) {
					return list;
				}				
			} catch (Exception e) {
				// TODO: handle exception
			}			
			return null;
		}
}