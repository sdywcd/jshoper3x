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

import com.jshop.dao.InvoicetempleteTDao;
import com.jshop.entity.InvoicetempleteT;

/**
 * A data access object (DAO) providing persistence and search support for
 * InvoicetempleteT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.InvoicetempleteT
 * @author MyEclipse Persistence Tools
 */
@Repository("invoicetempleteTDao")
public class InvoicetempleteTDaoImpl extends BaseTDaoImpl<InvoicetempleteT> implements InvoicetempleteTDao {


	private static final Log log = LogFactory.getLog(InvoicetempleteTDaoImpl.class);


	public int countfindAllInvoicetempleteT() {
		log.debug("count all countfindAllInvoicetempleteT");
		try {
			String queryString = "select count(*) from InvoicetempleteT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllInvoicetempleteT error", re);
			throw re;
		}
	}

	public int delInvoiceTemplete(final String[] list) {
		log.debug("del DelInvoiceTemplete");
		try {

			final String queryString = "delete from InvoicetempleteT as it where it.invoicetempleteid=:invoicetempleteid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("invoicetempleteid", s);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del DelInvoiceTemplete failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<InvoicetempleteT> findAllInvoicetempleteT(final int currentPage, final int lineSize) {
		log.debug("find all findAllInvoicetempleteT");
		try {
			List<InvoicetempleteT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from InvoicetempleteT";

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
			log.error("find all findAllInvoicetempleteT error", re);
			throw re;
		}
	}

	public int updateInvoicetempleteT(final InvoicetempleteT it) {
		log.debug("update InvoicetempleteT");
		try {

			final String queryString = "update InvoicetempleteT as it set it.logisticsid=:logisticsid,it.state=:state,it.code=:code where it.invoicetempleteid=:invoicetempleteid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("invoicetempleteid", it.getInvoicetempleteid());
					query.setParameter("logisticsid", it.getLogisticsid());
					query.setParameter("state", it.getState());
					query.setParameter("code", it.getCode());
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  InvoicetempleteT error", re);
			throw re;
		}
		return 0;
	}

	public InvoicetempleteT findInvoicetempleteById(String invoicetempleteid) {
		log.debug("find by id findInvoicetempleteById");
		try {
			String queryString = "from InvoicetempleteT as it where it.invoicetempleteid=:invoicetempleteid";
			List<InvoicetempleteT> list = this.getHibernateTemplate().findByNamedParam(queryString, "invoicetempleteid", invoicetempleteid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id findInvoicetempleteById error", re);
			throw re;
		}
	}

	public InvoicetempleteT findInvoicetempleteByState(String state) {
		log.debug("find by id findInvoicetempleteByState");
		try {
			String queryString = "from InvoicetempleteT as it where it.state=:state";
			List<InvoicetempleteT> list = this.getHibernateTemplate().findByNamedParam(queryString, "state", state);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id findInvoicetempleteByState error", re);
			throw re;
		}
	}
}