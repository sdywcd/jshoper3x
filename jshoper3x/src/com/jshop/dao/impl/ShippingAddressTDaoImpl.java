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

import com.jshop.dao.ShippingAddressTDao;
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.entity.ShippingAddressT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShippingAddressT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.ShippingAddressT
 * @author MyEclipse Persistence Tools
 */
@Repository("shippingAddressTDao")
public class ShippingAddressTDaoImpl extends BaseTDaoImpl<ShippingAddressT> implements ShippingAddressTDao {

	

	private static final Log log = LogFactory.getLog(ShippingAddressTDaoImpl.class);
	

	@SuppressWarnings("unchecked")
	public List<ShippingAddressT> findShippingAddressByDeliveraddressidAndstate(final String deliveraddressid, final String state, final String orderid) {
		log.debug("find all ShippingAddressT by deliveraddressid");
		try {
			List<ShippingAddressT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ShippingAddressT as st where st.deliveraddressid=:deliveraddressid and st.state=:state and st.orderid=:orderid order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("deliveraddressid", deliveraddressid);
					query.setParameter("state", state);
					query.setParameter("orderid", orderid);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all ShippingAddressT by deliveraddressid error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ShippingAddressT> findShippingAddressByIdAndState(final String shippingaddressid, final String state) {
		log.debug("find all ShippingAddressT by shippingaddressid");
		try {
			List<ShippingAddressT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ShippingAddressT as st where st.shippingaddressid=:shippingaddressid and st.state=:state order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("shippingaddressid", shippingaddressid);
					query.setParameter("state", state);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all ShippingAddressT by shippingaddressid error", re);
			throw re;
		}
	}

	public int updateShippingAddressByorderandstate(final String orderid, final String state) {
		log.debug("update ShippingAddressT state2");
		try {
			final String queryString = "update ShippingAddressT as st set st.state=:state where st.orderid=:orderid ";
			Integer integer=this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("state", state);
					return query.executeUpdate();
				}
			});
		} catch (RuntimeException re) {
			log.error("update  ShippingAddressT state2 error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public ShippingAddressT findShippingAddressByOrderid(final String orderid, final String state) {
		log.debug("find all findShippingAddressByOrderid by shippingaddressid");
		try {
			List<ShippingAddressT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ShippingAddressT as st where st.orderid=:orderid and st.state=:state order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("state", state);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findShippingAddressByOrderid by shippingaddressid error", re);
			throw re;
		}
	}

	@Override
	public List<ShippingAddressT> findShippingAddressByOrderId(String orderid) {
		log.debug("find all findShippingAddressByOrderid by orderid");
		try {
			String queryString = "from ShippingAddressT as st where st.orderid=:orderid";
			List<ShippingAddressT> list = this.getHibernateTemplate().findByNamedParam(queryString, "orderid", orderid);
			return list;
		} catch (RuntimeException re) {
			log.error("find all findShippingAddressByOrderid by orderid error", re);
			throw re;
		}
	}
}