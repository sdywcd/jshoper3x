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

import com.jshop.dao.VirtualShippingAddressTDao;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.VirtualShippingAddressT;
@Repository("virtualShippingAddressTDao")
public class VirtualShippingAddressTDaoImpl extends BaseTDaoImpl<VirtualShippingAddressT> implements
		VirtualShippingAddressTDao {
	private static final Log log=LogFactory.getLog(VirtualShippingAddressTDaoImpl.class);


	@SuppressWarnings("unchecked")
	@Override
	public List<VirtualShippingAddressT> findVirtualShippingAddressTByIdAndState(
			final String virtualshippingaddressid, final String state) {
		log.debug("findVirtualShippingAddressTByIdAndState");
		try {
			List<VirtualShippingAddressT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from VirtualShippingAddressT as vsa where vsa.virtualshippingaddressid=:virtualshippingaddressid and vsa.state=:state order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("virtualshippingaddressid", virtualshippingaddressid);
					query.setParameter("state", state);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findVirtualShippingAddressTByIdAndState error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VirtualShippingAddressT> findVirtualShippingAddressTByStateAndOrderid(
			final String state, final String orderid) {
		log.debug("findVirtualShippingAddressTByStateAndOrderid");
		try {
			List<VirtualShippingAddressT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from VirtualShippingAddressT as vsa where vsa.state=:state and vsa.orderid=:orderid order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("state", state);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findVirtualShippingAddressTByStateAndOrderid error", re);
			throw re;
		}
	}

	@Override
	public int updateVirtualShippingAddressTByorderandstate(final String orderid,
			final String state) {
		log.debug("updateVirtualShippingAddressTByorderandstate state2");
		try {
			final String queryString = "update VirtualShippingAddressT as vsa set vsa.state=:state where vsa.orderid=:orderid ";
			Integer integer=(Integer)this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("orderid", orderid);
					query.setParameter("state", state);
					i = query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("updateVirtualShippingAddressTByorderandstate error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public VirtualShippingAddressT findVirtualShippingAddressTByOrderidandstate(
			final String orderid, final String state) {
		log.debug("findVirtualShippingAddressTByOrderidandstate");
		try {
			String queryString = "from VirtualShippingAddressT as vsa where vsa.orderid=:orderid and vsa.state=:state order by createtime desc";
			List<VirtualShippingAddressT> list=this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"orderid","state"}, new Object[]{orderid,state});
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findVirtualShippingAddressTByOrderidandstate error", re);
			throw re;
		}
	}

	@Override
	public int delVirtualShippingAddressT(final String[] strs) {
		log.debug("del delVirtualShippingAddressT");
		try {

			final String queryString = "delete from VirtualShippingAddressT as vsa where vsa.virtualshippingaddressid=:virtualshippingaddressid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("virtualshippingaddressid", s);
						i = query.executeUpdate();
						i++;
					}
					if (strs.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del delVirtualShippingAddressT failed", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int updateVirtualShippingAddressT(VirtualShippingAddressT vsa) {
		log.debug("update updateVirtualShippingAddressT");
		try {
			this.getHibernateTemplate().update(vsa);
			return 1;
		} catch (RuntimeException re) {
			log.error("update  updateVirtualShippingAddressT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VirtualShippingAddressT> findAllVirtualShippingAddressT() {
		log.debug(" all findAllVirtualShippingAddressT");
		try {
			String queryString = "from VirtualShippingAddressT";
			List<VirtualShippingAddressT> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error(" all findAllVirtualShippingAddressT error", re);
			throw re;
		}
	}

}
