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

import com.jshop.dao.GoodsCommentTDao;
import com.jshop.entity.FunctionM;
import com.jshop.entity.GoodsCommentT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsCommentT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsCommentT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsCommentTDao")
public class GoodsCommentTDaoImpl extends BaseTDaoImpl<GoodsCommentT> implements GoodsCommentTDao {
	
	private static final Log log = LogFactory.getLog(GoodsCommentTDaoImpl.class);
	

	public int delGoodsComment(final String[] list) {
		log.debug("del GoodsCommentT");
		try {

			final String queryString = "delete from GoodsCommentT as gct where gct.commentid=:commentid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("commentid", s);
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
			log.error("del GoodsCommentT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsCommentT> findAllGoodsComment(final int currentPage, final int lineSize) {
		log.debug("find all findAllGoodsComment");
		try {
			List<GoodsCommentT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsCommentT  order by posttime desc";

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
			log.error("find all findAllGoodsComment error", re);
			throw re;
		}
	}

	public int countfindAllGoodsComment() {
		log.debug("count all countfindAllGoodsComment");
		try {
			String queryString = "select count(*) from GoodsCommentT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all brand error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsCommentT> findGoodsCommentByGoodsid(final String goodsid, final int currentPage, final int lineSize) {
		log.debug("find all GoodsCommentT by goodsid");
		try {
			List<GoodsCommentT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsCommentT as gct where gct.goodsid=:goodsid and gct.replyid='0' and gct.replyorcomment='1'  order by posttime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("goodsid", goodsid);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all GoodsCommentT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public int countfindGoodsCommentByGoodsid(final String goodsid) {
		log.debug("count all GoodsCommentT");
		try {
			String queryString = "select count(*) from GoodsCommentT as gct where gct.goodsid=:goodsid and gct.replyid='0' and gct.replyorcomment='1' and gct.state='1' ";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsid", goodsid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all brand error", re);
			throw re;
		}
	}

	public int updateGoodsCommentorReplyByState(final String state, final String[] list) {
		log.debug("del GoodsCommentT");
		try {

			final String queryString = "update GoodsCommentT  as gct set gct.state=:state where gct.commentid=:commentid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("state", state);
						query.setParameter("commentid", s);
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
			log.error("del GoodsCommentT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsCommentT> sortAllGoodsComment(final int currentPage, final int lineSize, final String queryString) {
		List<GoodsCommentT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				query.setFirstResult((currentPage - 1) * lineSize);
				query.setMaxResults(lineSize);
				List list = query.list();
				return list;
			}
		});
		return list;

	}

	@Override
	public GoodsCommentT findGoodsCommentById(String id) {
		log.debug("findGoodsCommentById");
		try {
			GoodsCommentT instance = (GoodsCommentT) this.getHibernateTemplate().get("com.jshop.entity.GoodsCommentT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("findGoodsCommentById failed", re);
			throw re;
		}
	}

	@Override
	public void updateGoodsComment(GoodsCommentT gct) {
		log.debug("updateGoodsComment");
		try {
			this.getHibernateTemplate().update(gct);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("updateGoodsComment failed", re);
			throw re;
		}
		
	}
}