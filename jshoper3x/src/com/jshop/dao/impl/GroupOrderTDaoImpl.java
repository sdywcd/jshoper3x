package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GroupOrderTDao;
import com.jshop.entity.GroupOrderT;

@Repository("groupOrderTDao")
public class GroupOrderTDaoImpl extends BaseTDaoImpl<GroupOrderT> implements GroupOrderTDao{
	private static final Log log = LogFactory.getLog(GroupOrderTDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupOrderT> findAllGroupOrderT(final int currentPage, final int lineSize) {
		final String queryString ="from GroupOrderT order by createtime desc";
		try {
			List<GroupOrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					List list= query.list();
					return list;
				}
			});
			if(list.size()>0){
				return list;
			}
			return null;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public int countfindAllGroupOrderT() {
		try {
			String queryString ="select count(*) from GroupOrderT";
			List list=this.getHibernateTemplate().find(queryString);
			if(list.size()>0){
				Object o=list.get(0);
				long l = (Long) o;
				return (int) l;			
			}
			return 0;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupOrderT> sortAllGroupOrderT(final int currentPage,final int lineSize,
			final String queryString) {
		try {
			List<GroupOrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					List list= query.list();
					return list;
				}
			});
			if(list.size()>0){
				return list;
			}
			return null;
		} catch (DataAccessException e) {
			throw e;
		}
	

	}

	@Override
	public GroupOrderT findgroupOrderDetailByorderid(String orderid) {
		try {
			GroupOrderT list = (GroupOrderT) this.getHibernateTemplate().get("com.jshop.entity.GroupOrderT", orderid);
			return list;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public int updateGroupOrderPayShippingState(final String orderid,
			final String orderstate, final String paystate, final String shippingstate) {
		try {
			final String queryString = "update GroupOrderT as o set o.orderstate=:orderstate,o.paystate=:paystate,o.shippingstate=:shippingstate where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("orderstate", orderstate);
					query.setParameter("paystate", paystate);
					query.setParameter("shippingstate", shippingstate);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (DataAccessException e) {
			throw e;
		}
		return 0;
	}

	@Override
	public int updateExpressnumberByGroupOrderId(final String orderid,
			final String expressnumber) {
		log.debug("update GroupOrderT UpdateExpressnumberByOrderId");
		try {

			final String queryString = "update GroupOrderT as o set o.expressnumber=:expressnumber where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("expressnumber", expressnumber);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  GroupOrderT UpdateExpressnumberByOrderId error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int updateInvoicenumberByOrderId(final String orderid,
			final String deliverynumber, final Date deliverytime) {
		log.debug("update OrderT UpdateInvoicenumberByOrderId");
		try {

			final String queryString = "update GroupOrderT as o set o.deliverynumber=:deliverynumber,o.deliverytime=:deliverytime where o.orderid=:orderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("deliverynumber", deliverynumber);
					query.setParameter("deliverytime", deliverytime);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  OrderT UpdateInvoicenumberByOrderId error", re);
			throw re;
		}
		return 0;
	}


	}
