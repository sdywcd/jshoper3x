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

import com.jshop.dao.LogisticsBusinessTDao;
import com.jshop.entity.LogisticsBusinessT;

/**
 * A data access object (DAO) providing persistence and search support for
 * LogisticsBusinessT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.LogisticsBusinessT
 * @author MyEclipse Persistence Tools
 */

@Repository("logisticsBusinessTDao")
public class LogisticsBusinessTDaoImpl extends BaseTDaoImpl<LogisticsBusinessT> implements LogisticsBusinessTDao {
	

	private static final Log log = LogFactory.getLog(LogisticsBusinessTDaoImpl.class);
	
	public int countfindAllLogisticsBusiness() {
		log.debug("count all LogisticsBusinessT");
		try {
			String queryString = "select count(*) from LogisticsBusinessT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all LogisticsBusinessT error", re);
			throw re;
		}
	}

	public int delLogisticsBusiness(final String[] list) {
		log.debug("del LogisticsBusinessT");
		try {

			final String queryString = "delete from LogisticsBusinessT as lb where lb.logisticsid=:logisticsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("logisticsid", s);
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
			log.error("del brandt failed", re);
			throw re;
		}
		return 0;
	}

	public List<LogisticsBusinessT> findAllLogisticsBusiness(final int currentPage, final int lineSize) {
		log.debug("find all LogisticsBusinessT");
		try {
			List<LogisticsBusinessT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from LogisticsBusinessT  order by createtime desc";

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
			log.error("find all LogisticsBusinessT error", re);
			throw re;
		}
	}

	public LogisticsBusinessT findLogisticsBusinessById(String logisticsid) {
		log.debug("find by id LogisticsBusinessT");
		try {
			String queryString = "from LogisticsBusinessT as lb where lb.logisticsid=:logisticsid";
			List<LogisticsBusinessT> list = this.getHibernateTemplate().findByNamedParam(queryString, "logisticsid", logisticsid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id brand error", re);
			throw re;
		}
	}

	public int updateLogisticsBusiness(final LogisticsBusinessT lb) {
		log.debug("update LogisticsBusinessT");
		try {
			final String queryString = "update LogisticsBusinessT as lb set lb.logisticsname=:logisticsname,lb.address=:address,lb.contractor=:contractor,lb.telno=:telno,lb.mobile=:mobile,lb.faxno=:faxno,lb.email=:email,lb.receiver=:receiver,lb.bankaddress=:bankaddress,lb.bankaccount=:bankaccount,lb.createtime=:createtime,lb.creatorid=:creatorid,lb.des=:des,lb.insure=:insure,lb.isCod=:isCod,lb.visible=:visible,lb.state=:state,lb.city=:city,lb.website=:website,lb.sendrange=:sendrange where lb.logisticsid=:logisticsid ";
			Integer integer=(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("logisticsid", lb.getLogisticsid());
					query.setParameter("logisticsname", lb.getLogisticsname());
					query.setParameter("address", lb.getAddress());
					query.setParameter("contractor", lb.getContractor());
					query.setParameter("telno", lb.getTelno());
					query.setParameter("mobile", lb.getMobile());
					query.setParameter("faxno", lb.getFaxno());
					query.setParameter("email", lb.getEmail());
					query.setParameter("receiver", lb.getReceiver());
					query.setParameter("bankaddress", lb.getBankaddress());
					query.setParameter("bankaccount", lb.getBankaccount());
					query.setParameter("createtime", lb.getCreatetime());
					query.setParameter("creatorid", lb.getCreatorid());
					query.setParameter("des", lb.getDes());
					query.setParameter("insure", lb.getInsure());
					query.setParameter("isCod", lb.getIsCod());
					query.setParameter("visible", lb.getVisible());
					query.setParameter("state", lb.getState());
					query.setParameter("city", lb.getCity());
					query.setParameter("website", lb.getWebsite());
					query.setParameter("sendrange", lb.getSendrange());
					return query.executeUpdate();
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("update  BrandT error", re);
			throw re;
		}
	}

	public List<LogisticsBusinessT> findAllLogisticsBusiness(String state) {
		log.debug("find  LogisticsBusinessT");
		try {
			String queryString = "from LogisticsBusinessT as lb where lb.state=:state";
			List<LogisticsBusinessT> list = this.getHibernateTemplate().findByNamedParam(queryString, "state", state);
			return list;
		} catch (RuntimeException re) {
			log.error("find LogisticsBusinessT error", re);
			throw re;
		}
	}

	public List<LogisticsBusinessT> findAllLogisticsBusinessTjson() {
		log.debug("find  LogisticsBusinessT");
		try {
			String queryString = "from LogisticsBusinessT as lb where lb.state='1'";
			List<LogisticsBusinessT> list = this.getHibernateTemplate().find(queryString);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find LogisticsBusinessT error", re);
			throw re;
		}
	}

	@Override
	public List<LogisticsBusinessT> findLogisticsBusiness(String visible) {
		log.debug("find  LogisticsBusinessT");
		try {
			String queryString = "from LogisticsBusinessT as lb where lb.visible=:visible";
			List<LogisticsBusinessT> list = this.getHibernateTemplate().findByNamedParam(queryString, "visible", visible);
			return list;
		} catch (RuntimeException re) {
			log.error("find LogisticsBusinessT error", re);
			throw re;
		}
	}
}