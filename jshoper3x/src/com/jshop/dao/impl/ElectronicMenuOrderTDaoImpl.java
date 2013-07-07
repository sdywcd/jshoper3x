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

import com.jshop.dao.ElectronicMenuOrderTDao;
import com.jshop.entity.ElectronicMenuOrderT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ElectronicMenuOrderT entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.ElectronicMenuOrderT
 * @author MyEclipse Persistence Tools
 */
@Repository("electronicMenuOrderTDao")
public class ElectronicMenuOrderTDaoImpl extends HibernateDaoSupport implements ElectronicMenuOrderTDao {
	private static final Logger log = LoggerFactory.getLogger(ElectronicMenuOrderTDaoImpl.class);

	public int addElectronicMenuOrderT(ElectronicMenuOrderT eo) {
		log.debug("save ElectronicMenuOrderT");
		try {
			this.getHibernateTemplate().save(eo);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int countfindAllElectronicMenuOrderT() {
		log.debug("countfindAllElectronicMenuOrderT");
		try {
			String queryString = "select count(*) from ElectronicMenuOrderT ";
			List<ElectronicMenuOrderT> list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllElectronicMenuOrderT error", re);
			throw re;
		}
	}

	public int countsortAllElectronicMenuOrderTByshippingusername(String shippingusername) {
		log.debug("countsortAllElectronicMenuOrderTByshippingusername");
		try {
			String queryString = "select count(*) from ElectronicMenuOrderT as eo where eo.shippingusername=:shippingusername";
			List<ElectronicMenuOrderT> list = this.getHibernateTemplate().findByNamedParam(queryString, "shippingusername", shippingusername);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countsortAllElectronicMenuOrderTByshippingusername error", re);
			throw re;
		}
	}

	public int countsortAllTobeShippedElectronicMenuOrderT(String shippingstate) {
		log.debug("countsortAllTobeShippedElectronicMenuOrderT");
		try {
			String queryString = "select count(*) from ElectronicMenuOrderT as eo where eo.shippingstate=:shippingstate";
			List<ElectronicMenuOrderT> list = this.getHibernateTemplate().findByNamedParam(queryString, "shippingstate", shippingstate);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countsortAllTobeShippedElectronicMenuOrderT error", re);
			throw re;
		}
	}

	public List<ElectronicMenuOrderT> findAllElectronicMenuOrderTBytableNumberandstate(String tableNumber, String tablestate, String electronicorderstate) {
		log.debug("findAllElectronicMenuOrderTBytableNumberandstate");
		try {
			String queryString = "from ElectronicMenuOrderT as eo where eo.tableNumber=:tableNumber and eo.tablestate=:tablestate and eo.electronicorderstate=:electronicorderstate";
			List<ElectronicMenuOrderT> list = this.getHibernateTemplate().findByNamedParam(queryString,new String[]{"tableNumber","tablestate","electronicorderstate"}, new Object[]{tableNumber,tablestate,electronicorderstate});
			return list;
		} catch (RuntimeException re) {
			log.error("findAllElectronicMenuOrderTBytableNumberandstate error", re);
			throw re;
		}
	}

	public ElectronicMenuOrderT findElectronicMenuOrderTByelectronicMenuOrderid(String electronicMenuOrderid) {
		log.debug("findElectronicMenuOrderTByelectronicMenuOrderid");
		try {
			ElectronicMenuOrderT instance = (ElectronicMenuOrderT) this.getHibernateTemplate().get("com.jshop.entity.ElectronicMenuOrderT", electronicMenuOrderid);
			return instance;
		} catch (RuntimeException re) {
			log.error("findElectronicMenuOrderTByelectronicMenuOrderid failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ElectronicMenuOrderT> sortAllElectronicMenuOrderT(final int currentPage, final int lineSize, final String queryString) {
		log.debug("sortAllElectronicMenuOrderT");
		try {
			List<ElectronicMenuOrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("sortAllElectronicMenuOrderT failed",re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ElectronicMenuOrderT> sortAllTobeShippedElectronicMenuOrderT(final int currentPage, final int lineSize, final String shippingstate) {
		log.debug("sortAllTobeShippedElectronicMenuOrderT");
		try {
			List<ElectronicMenuOrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				String queryString = "from ElectronicMenuOrderT as eo  where eo.shippingstate=:shippingstate";
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("shippingstate", shippingstate);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("sortAllTobeShippedElectronicMenuOrderT error ", re);
			throw re;
		}
	}

	public void updateElectronicMenuOrderT(ElectronicMenuOrderT eo) {
		log.debug("updateElectronicMenuOrderT");
		try {
			this.getHibernateTemplate().update(eo);
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuOrderT failed", re);
			throw re;
		}
	}

	public int updateElectronicMenuOrderTelectronicorderstateByelectronicMenuOrderid(final String electronicMenuOrderid, final String electronicorderstate) {
		log.debug("updateElectronicMenuOrderTelectronicorderstateByelectronicMenuOrderid");
		try {
			final String queryString = "update ElectronicMenuOrderT as eo set eo.electronicorderstate=:electronicorderstate where eo.electronicMenuOrderid=:electronicMenuOrderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("electronicorderstate", electronicorderstate);
					query.setParameter("electronicMenuOrderid", electronicMenuOrderid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuOrderTelectronicorderstateByelectronicMenuOrderid error", re);
			throw re;
		}
		return 0;
	}

	public int updateElectronicMenuOrderTpayshippingstate(final String electronicMenuOrderid, final String electronicorderstate, final String paystate, final String shippingstate) {
		log.debug("updateElectronicMenuOrderTpayshippingstate");
		try {
			final String queryString = "update ElectronicMenuOrderT as eo set eo.electronicorderstate=:electronicorderstate,eo.paystate=:paystate,eo.shippingstate=:shippingstate where eo.electronicMenuOrderid=:electronicMenuOrderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("electronicorderstate", electronicorderstate);
					query.setParameter("electronicMenuOrderid", electronicMenuOrderid);
					query.setParameter("paystate", paystate);
					query.setParameter("shippingstate",shippingstate);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuOrderTpayshippingstate error", re);
			throw re;
		}
		return 0;
	}

	public int updateElectronicMenuOrderTpaystateByelectronicMenuOrderid(final String electronicMenuOrderid, final String paystate) {
		log.debug("updateElectronicMenuOrderTpaystateByelectronicMenuOrderid");
		try {
			final String queryString = "update ElectronicMenuOrderT as eo set eo.paystate=:paystate where eo.electronicMenuOrderid=:electronicMenuOrderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("electronicMenuOrderid", electronicMenuOrderid);
					query.setParameter("paystate", paystate);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuOrderTpaystateByelectronicMenuOrderid error", re);
			throw re;
		}
		return 0;
	}

	public int updateElectronicMenuOrderTshippingstateByelectronicMenuOrderid(final String electronicMenuOrderid, final String shippingstate) {
		log.debug("updateElectronicMenuOrderTshippingstateByelectronicMenuOrderid");
		try {
			final String queryString = "update ElectronicMenuOrderT as eo set eo.shippingstate=:shippingstate where eo.electronicMenuOrderid=:electronicMenuOrderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("electronicMenuOrderid", electronicMenuOrderid);
					query.setParameter("shippingstate", shippingstate);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateElectronicMenuOrderTshippingstateByelectronicMenuOrderid error", re);
			throw re;
		}
		return 0;
	}

	public int updateexpressnumberByelectronicMenuOrderid(final String electronicMenuOrderid, final String expressnumber) {
		log.debug("updateexpressnumberByelectronicMenuOrderid");
		try {
			final String queryString = "update ElectronicMenuOrderT as eo set eo.expressnumber=:expressnumber where eo.electronicMenuOrderid=:electronicMenuOrderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("electronicMenuOrderid", electronicMenuOrderid);
					query.setParameter("expressnumber", expressnumber);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateexpressnumberByelectronicMenuOrderid error", re);
			throw re;
		}
		return 0;
	}

	public int updateInvoiceByelectronicMenuOrderid(final String electronicMenuOrderid, final String invoice) {
		log.debug("updateInvoiceByelectronicMenuOrderid");
		try {
			final String queryString = "update ElectronicMenuOrderT as eo set eo.invoice=:invoice where eo.electronicMenuOrderid=:electronicMenuOrderid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("electronicMenuOrderid", electronicMenuOrderid);
					query.setParameter("invoice", invoice);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateInvoiceByelectronicMenuOrderid error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int updateElectronicMenuOrderElectrobicOrderState(
			final String electronicorderstate,final String tableNumber) {
		final String queryString="update ElectronicMenuOrderT as eo set eo.electronicorderstate=:electronicorderstate where eo.tableNumber=:tableNumber ";
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i=0;
					Query query= session.createQuery(queryString);
					query.setParameter("electronicorderstate", electronicorderstate);
					query.setParameter("tableNumber", tableNumber);
					i=query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException e) {
			throw e;
		}
		return 0;
	}

	@Override
	public List<ElectronicMenuOrderT> findElectronicMenuOrderTByelectronicMenuTablenumber(
			String tableNumber) {
		log.debug("findElectronicMenuOrderTByelectronicMenuTablenumber");
		try {
			String queryString = "from ElectronicMenuOrderT as eo where eo.tableNumber=:tableNumber";
			
			List<ElectronicMenuOrderT> list=(List<ElectronicMenuOrderT>) this.getHibernateTemplate().findByNamedParam(queryString, "tableNumber",tableNumber);
			return  list;
			
		} catch (RuntimeException re) {
			log.error("findElectronicMenuOrderTByelectronicMenuTablenumber failed", re);
			throw re;
		}
	}
	@Override
	public int updateElectronicMenuOrderPaystate(final String paystate,
			final String tableNumber) {
		final String queryString="update ElectronicMenuOrderT as eo set eo.paystate=:paystate where eo.tableNumber=:tableNumber ";
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i =0;
					Query query= session.createQuery(queryString);
					query.setParameter("paystate", paystate);
					query.setParameter("tableNumber", tableNumber);
					i=query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException e) {
			throw e;
		}
		return 0;
	}
	
	
}