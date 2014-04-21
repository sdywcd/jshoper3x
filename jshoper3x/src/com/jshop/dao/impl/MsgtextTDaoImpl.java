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

import com.jshop.dao.MsgtextTDao;
import com.jshop.entity.MsgtextT;

/**
 * A data access object (DAO) providing persistence and search support for
 * MsgtextT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.MsgtextT
 * @author MyEclipse Persistence Tools
 */
@Repository("msgtextTDao")
public class MsgtextTDaoImpl extends BaseTDaoImpl<MsgtextT> implements MsgtextTDao {

	private static final Log log = LogFactory.getLog(MsgtextTDaoImpl.class);


	public int countfindAllMsgtext() {
		log.debug("count all countfindAllMsgtext");
		try {
			String queryString = "select count(*) from MsgtextT";
			List<MsgtextT> list =  this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all MsgtextT error", re);
			throw re;
		}
	}

	public int delMsgtext(final String[] list) {
		log.debug("del DelMsgtext");
		try {

			final String queryString = "delete from MsgtextT as mt where mt.msgtextid=:msgtextid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("msgtextid", s);
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
			log.error("del DelMsgtext failed", re);
			throw re;
		}
		return 0;
	}

	public List<MsgtextT> findAllMsgtext(final int currentPage, final int lineSize) {
		log.debug("find all MsgtextT");
		try {
			List<MsgtextT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MsgtextT as mt  order by sendTime desc";

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
			log.error("find all MsgtextT ", re);
			throw re;
		}
	}

	public MsgtextT findMsgtextById(String id) {
		log.debug("getting findMsgtextById instance with id: " + id);
		try {
			MsgtextT list = (MsgtextT) this.getHibernateTemplate().get("com.jshop.entity.MsgtextT", id);
			return list;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int updateMsgtext(final MsgtextT mt) {
		log.debug("update UpdateMsgtext");
		try {

			final String queryString = "update OrderT as mt set mt.text=:text,mt.sendTime=:sendTime where mt.msgtextid=:msgtextid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("msgtextid", mt.getMsgtextid());
					query.setParameter("text", mt.getText());
					query.setParameter("sendTime", mt.getSendtime());
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  UpdateMsgtext error", re);
			throw re;
		}
		return 0;
	}
}