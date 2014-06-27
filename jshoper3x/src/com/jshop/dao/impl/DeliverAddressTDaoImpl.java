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

import com.jshop.dao.DeliverAddressTDao;
import com.jshop.entity.DeliverAddressT;

/**
 * A data access object (DAO) providing persistence and search support for
 * DeliverAddressT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.DeliverAddressT
 * @author MyEclipse Persistence Tools
 */
@Repository("deliverAddressTDao")
public class DeliverAddressTDaoImpl extends BaseTDaoImpl<DeliverAddressT> implements DeliverAddressTDao {
	

	private static final Log log = LogFactory.getLog(DeliverAddressTDaoImpl.class);
	
	public int delDeliverAddress(final String[] list) {
		log.debug("del DeliverAddressT");
		try {

			final String queryString = "delete from DeliverAddressT as d where d.addressid=:addressid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session arg0)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					return null;
				}
			});
		} catch (RuntimeException re) {
			log.error("del DeliverAddressT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<DeliverAddressT> findAllDeliverAddress() {
		log.debug("find all DeliverAddressT");
		try {
			String queryString = "from DeliverAddressT order by createtime desc";
			List<DeliverAddressT> list = this.getHibernateTemplate().find(queryString);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all DeliverAddressT  error", re);
			throw re;
		}
	}

	public int updateDeliverAddress(DeliverAddressT d) {
		log.debug("update DeliverAddressT");
		try {
			this.getHibernateTemplate().update(d);
			return 1;
		} catch (RuntimeException re) {
			log.error("update  DeliverAddressT error", re);
			throw re;
		}
	}

	public List<DeliverAddressT> findDeliverAddressBymemberid(String memberid) {
		log.debug("find all DeliverAddressT by memberid");
		try {
			String queryString = "from DeliverAddressT as d where d.memberid=:memberid order by createtime desc";
			List<DeliverAddressT> list = this.getHibernateTemplate().findByNamedParam(queryString, "memberid", memberid);
			return list;
		} catch (RuntimeException re) {
			log.error("find all DeliverAddressT  error", re);
			throw re;

		}
	}

	public DeliverAddressT findDeliverAddressById(String addressid) {
		log.debug("find all DeliverAddressT by addressid");
		try {
			String queryString = "from DeliverAddressT as d where d.addressid=:addressid order by createtime desc";
			List<DeliverAddressT> list = this.getHibernateTemplate().findByNamedParam(queryString, "addressid", addressid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all DeliverAddressT  error", re);
			throw re;
		}
	}

}