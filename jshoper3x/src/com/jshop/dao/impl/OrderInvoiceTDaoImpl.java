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

import com.jshop.dao.OrderInvoiceTDao;
import com.jshop.entity.OrderInvoiceT;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderInvoiceT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.OrderInvoiceT
 * @author MyEclipse Persistence Tools
 */
@Repository("orderInvoiceTDao")
public class OrderInvoiceTDaoImpl extends BaseTDaoImpl<OrderInvoiceT> implements OrderInvoiceTDao {
	

	private static final Log log = LogFactory.getLog(OrderInvoiceTDaoImpl.class);
	
	public int countfindAllOrderIvoice() {
		log.debug("count all countfindAllOrderIvoice");
		try {
			String queryString = "select count(*) from OrderInvoiceT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllOrderIvoice error", re);
			throw re;
		}
	}

	public int delOrderInvoice(final String[] list) {
		log.debug("del DelOrderInvoice");
		try {

			final String queryString = "delete from OrderInvoiceT as oi where oi.orderInvoiceid=:orderInvoiceid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("orderInvoiceid", s);
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
			log.error("del DelOrderInvoice failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<OrderInvoiceT> findAllOrderIvoice(final int currentPage, final int lineSize) {
		log.debug("find all OrderInvoiceT");
		try {
			List<OrderInvoiceT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from OrderInvoiceT  order by createtime desc";

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
			log.error("find all OrderInvoiceT error", re);
			throw re;
		}
	}

	public int updateOrderInvoiceState(final String[] orderinvoiceid, final String state) {
		log.debug("update UpdateOrderInvoiceState");
		try {

			final String queryString = "update OrderInvoiceT as oi set oi.state=:state where oi.orderInvoiceid=:orderInvoiceid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					for (String s : orderinvoiceid) {
						query.setParameter("orderInvoiceid", s);
						query.setParameter("state", state);
						i = query.executeUpdate();
						i++;
					}
					if (orderinvoiceid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("update  UpdateOrderInvoiceState error", re);
			throw re;
		}
		return 0;
	}
}