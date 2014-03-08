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

import com.jshop.dao.ExpresstempleteTDao;
import com.jshop.entity.ExpresstempleteT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ExpresstempleteT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.ExpresstempleteT
 * @author MyEclipse Persistence Tools
 */
@Repository("expresstempleteTDao")
public class ExpresstempleteTDaoImpl extends BaseTDaoImpl<ExpresstempleteT> implements ExpresstempleteTDao {
	
	private static final Log log = LogFactory.getLog(ExpresstempleteTDaoImpl.class);
	

	public int delExpresstemplete(final String[] list) {
		log.debug("del ExpresstempleteT");
		try {

			final String queryString = "delete from ExpresstempleteT as et where et.expresstempleteid=:expresstempleteid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("expresstempleteid", s);
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
			log.error("del ExpresstempleteT failed", re);
			throw re;
		}
		return 0;
	}

	public ExpresstempleteT findExpresstempleteByLogisticsid(String logisticsid) {
		log.debug("find by id ExpresstempleteT");
		try {
			String queryString = "from ExpresstempleteT as et where et.logisticsid=:logisticsid";
			List<ExpresstempleteT> list = this.getHibernateTemplate().findByNamedParam(queryString, "logisticsid", logisticsid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id ExpresstempleteT error", re);
			throw re;
		}
	}

	public int updateExpresstemplete(final ExpresstempleteT et) {
		log.debug("update ExpresstempleteT");
		try {
			final String queryString = "update ExpresstempleteT as et set et.sendName=:sendName,et.sendCountry=:sendCountry,et.sendProvince=:sendProvince,et.sendCity=:sendCity,et.sendDistrict=:sendDistrict," + "et.sendStreet=:sendStreet,et.sendTelno=:sendTelno,et.sendMobile=:sendMobile,et.recipientName=:recipientName,et.recipientCountry=:recipientCountry,et.recipientProvince=:recipientProvince,et.recipientCity=:recipientCity," + "et.recipientDistrict=:recipientDistrict,et.recipientStreet=:recipientStreet,et.recipientTelno=:recipientTelno,et.recipientMobile=:recipientMobile,et.recipientPostcode=:recipientPostcode,et.year=:year,"
					+ "et.month=:month,et.day=:day,et.orderid=:orderid,et.notes=:notes,et.sendTime=:sendTime,et.rightTag=:rightTag,et.logisticsid=:logisticsid,et.state=:state,et.expressCss=:expressCss,et.expressImg=:expressImg,et.kindeditorCode=:kindeditorCode where et.expresstempleteid=:expresstempleteid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("expresstempleteid", et.getExpresstempleteid());
					query.setParameter("sendName", et.getSendName());
					query.setParameter("sendCountry", et.getSendCountry());
					query.setParameter("sendProvince", et.getSendProvince());
					query.setParameter("sendCity", et.getSendCity());
					query.setParameter("sendDistrict", et.getSendDistrict());
					query.setParameter("sendStreet", et.getSendStreet());
					query.setParameter("sendTelno", et.getSendTelno());
					query.setParameter("sendMobile", et.getSendMobile());
					query.setParameter("recipientName", et.getRecipientName());
					query.setParameter("recipientCountry", et.getRecipientCountry());
					query.setParameter("recipientProvince", et.getRecipientProvince());
					query.setParameter("recipientCity", et.getRecipientCity());
					query.setParameter("recipientDistrict", et.getRecipientDistrict());
					query.setParameter("recipientStreet", et.getRecipientStreet());
					query.setParameter("recipientTelno", et.getRecipientTelno());
					query.setParameter("recipientMobile", et.getRecipientMobile());
					query.setParameter("recipientPostcode", et.getRecipientPostcode());
					query.setParameter("year", et.getYear());
					query.setParameter("month", et.getMonth());
					query.setParameter("day", et.getDay());
					query.setParameter("orderid", et.getOrderid());
					query.setParameter("notes", et.getNotes());
					query.setParameter("sendTime", et.getSendTime());
					query.setParameter("rightTag", et.getRightTag());
					query.setParameter("logisticsid", et.getLogisticsid());
					query.setParameter("state", et.getState());
					query.setParameter("expressCss", et.getExpressCss());
					query.setParameter("expressImg", et.getExpressImg());
					query.setParameter("kindeditorCode", et.getKindeditorCode());
					i = query.executeUpdate();
					++i;
					return i;
				}
			});

		} catch (RuntimeException re) {
			log.error("update ExpresstempleteT error", re);
			throw re;
		}
		return 0;
	}

	public int countfindAllExpresstempleteT() {
		log.debug("count all ExpresstempleteT");
		try {
			String queryString = "select count(*) from ExpresstempleteT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all ExpresstempleteT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ExpresstempleteT> findAllExpresstempleteT(final int currentPage, final int lineSize) {
		log.debug("find all ExpresstempleteT");
		try {
			List<ExpresstempleteT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ExpresstempleteT";

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
			log.error("find all ExpresstempleteT error", re);
			throw re;
		}
	}

	public ExpresstempleteT findExpresstempleteBytempleteid(String expresstempleteid) {
		log.debug("find by id ExpresstempleteT");
		try {
			String queryString = "from ExpresstempleteT as et where et.expresstempleteid=:expresstempleteid";
			List<ExpresstempleteT> list = this.getHibernateTemplate().findByNamedParam(queryString, "expresstempleteid", expresstempleteid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id ExpresstempleteT error", re);
			throw re;
		}
	}
}