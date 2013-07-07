package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.CouponTDao;
import com.jshop.entity.CouponT;

/**
 * A data access object (DAO) providing persistence and search support for
 * CouponT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.CouponT
 * @author MyEclipse Persistence Tools
 */
@Repository("couponTDao")
public class CouponTDaoImpl extends HibernateDaoSupport implements CouponTDao {
	
	private static final Logger log = LoggerFactory.getLogger(CouponTDaoImpl.class);

	public int countfindAllCoupon() {
		log.debug("count all countfindAllCoupon");
		try {
			String queryString = "select count(*) from CouponT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all CouponT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CouponT> findAllCoupon(final int currentPage, final int lineSize) {
		log.debug("find all findAllCoupon");
		try {
			List<CouponT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from CouponT  order by createtime desc";

				@SuppressWarnings("unchecked")
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all CouponT error", re);
			throw re;
		}
	}

	public void addCouponT(CouponT ct) {
		log.debug("save CouponT");
		try {
			this.getHibernateTemplate().save(ct);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
}