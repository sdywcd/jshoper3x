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

import com.jshop.dao.LogisticsbusinessareaTDao;
import com.jshop.entity.LogisticsbusinessareaT;

/**
 * A data access object (DAO) providing persistence and search support for
 * LogisticsbusinessareaT entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.LogisticsbusinessareaT
 * @author MyEclipse Persistence Tools
 */
@Repository("logisticsbusinessareaTDao")
public class LogisticsbusinessareaTDaoImpl extends BaseTDaoImpl<LogisticsbusinessareaT> implements LogisticsbusinessareaTDao {
	

	private static final Log log = LogFactory.getLog(LogisticsbusinessareaTDaoImpl.class);
	public int countfindAllLogisticsbusinessareaT() {
		log.debug("count all LogisticsbusinessareaT");
		try {
			String queryString = "select count(*) from LogisticsbusinessareaT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all LogisticsbusinessareaT error", re);
			throw re;
		}
	}

	public int delLogisticsbusinessarea(final String[] list) {
		log.debug("del LogisticsbusinessareaT");
		try {

			final String queryString = "delete from LogisticsbusinessareaT as lba where lba.logbusareaid=:logbusareaid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("logbusareaid", s);
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
			log.error("del LogisticsbusinessareaT failed", re);
			throw re;
		}
		return 0;
	}

	public List<LogisticsbusinessareaT> findAllLogisticsbusinessareaT(final int currentPage, final int lineSize) {
		log.debug("find all LogisticsbusinessareaT");
		try {
			List<LogisticsbusinessareaT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from LogisticsbusinessareaT";

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
			log.error("find all LogisticsbusinessareaT error", re);
			throw re;
		}
	}

	public LogisticsbusinessareaT findLogisticsbusinessareaTById(String logbusareaid) {
		log.debug("find by id LogisticsbusinessareaT");
		try {
			String queryString = "from LogisticsbusinessareaT as lba where lba.logbusareaid=:logbusareaid";
			List<LogisticsbusinessareaT> list = this.getHibernateTemplate().findByNamedParam(queryString, "logbusareaid", logbusareaid);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id LogisticsbusinessareaT error", re);
			throw re;
		}
	}

	public int updateLogisticsbusinessarea(final LogisticsbusinessareaT lba) {
		log.debug("update LogisticsbusinessareaT");
		try {
			final String queryString = "update LogisticsbusinessareaT as lba set lba.logisticsid=:logisticsid,lba.logisticsname=:logisticsname,lba.costway=:costway,lba.normalcost=:normalcost,lba.normalvalue=:normalvalue,lba.overcost=:overcost,lba.overvalue=:overvalue,lba.sendarea=:sendarea,lba.state=:state where lba.logbusareaid=:logbusareaid ";
			Integer integer=(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("logbusareaid", lba.getLogbusareaid());
					query.setParameter("logisticsid", lba.getLogisticsid());
					query.setParameter("logisticsname", lba.getLogisticsname());
					query.setParameter("costway", lba.getCostway());
					query.setParameter("normalvalue", lba.getNormalvalue());
					query.setParameter("normalcost", lba.getNormalcost());
					query.setParameter("overcost", lba.getOvercost());
					query.setParameter("overvalue", lba.getOvervalue());
					query.setParameter("sendarea", lba.getSendarea());
					query.setParameter("state", lba.getState());
					return query.executeUpdate();
					
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("update  LogisticsbusinessareaT error", re);
			throw re;
		}
	}

	public int updateLogisticsbusinessareaBystate(final String[] list, final String state) {
		log.debug("update LogisticsbusinessareaT state");
		try {

			final String queryString = "update LogisticsbusinessareaT as lba set lba.state=:state where lba.logbusareaid=:logbusareaid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("logbusareaid", s);
						query.setParameter("state", state);
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
			log.error("del LogisticsbusinessareaT failed", re);
			throw re;
		}
		return 0;
	}

	public List<LogisticsbusinessareaT> findAllLogisticsbusinessareaTBylogisticsid(String logisticsid) {
		log.debug("find  LogisticsbusinessareaT by logisticsid");
		try {
			String queryString = "from LogisticsbusinessareaT as lba where lba.logisticsid=:logisticsid";
			List<LogisticsbusinessareaT> list = this.getHibernateTemplate().findByNamedParam(queryString, "logisticsid", logisticsid);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id LogisticsbusinessareaT error", re);
			throw re;
		}
	}
}