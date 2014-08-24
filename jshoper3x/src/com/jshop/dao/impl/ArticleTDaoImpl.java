package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.ArticleTDao;
import com.jshop.entity.ArticleT;
import com.jshop.entity.GoodsT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ArticleT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.ArticleT
 * @author MyEclipse Persistence Tools
 */
@Repository("articleTDao")
public class ArticleTDaoImpl extends BaseTDaoImpl<ArticleT> implements ArticleTDao {

	private static final Logger log = LoggerFactory.getLogger(ArticleTDaoImpl.class);


	public int countfindAllArticle(String creatorid) {
		log.debug("countfindAllArticle");
		try {
			String queryString = "select count(*) from ArticleT as at where  at.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllArticle error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ArticleT> findAllArticleT(final int currentPage, final int lineSize, final String creatorid) {
		log.debug("findAllArticleT");
		try {
			List<ArticleT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ArticleT as at where at.creatorid=:creatorid  order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findAllArticleT error", re);
			throw re;
		}
	}

	public ArticleT findArticleByarticleid(String articleid) {
		log.debug("getting ArticleT instance with id: " + articleid);
		try {
			ArticleT instance = (ArticleT) this.getHibernateTemplate().get("com.jshop.entity.ArticleT", articleid);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int updateArticleT(ArticleT at) {
		log.debug("updateArticleT");
		try {
			this.getHibernateTemplate().update(at);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("updateArticleTfailed", re);
			throw re;
		}
	}

	public void delArticleT(final String[] strs) {
		log.debug("delArticleT");
		try {
			for(String s:strs){
				ArticleT articleT=this.getHibernateTemplate().load(ArticleT.class, s);
				this.getHibernateTemplate().delete(articleT);
			}
		} catch (RuntimeException re) {
			log.error("delArticleT failed", re);
			throw re;
		}
	}

	public int updateHtmlPath(final String articleid, final String htmlPath) {
		log.debug("updateHtmlPath");
		try {

			final String queryString = "update ArticleT as at set at.htmlPath=:htmlPath where at.articleid=:articleid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("articleid", articleid);
					query.setParameter("htmlPath", htmlPath);

					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateHtmlPath error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int updateHtmlPath(final String articleid, final String htmlPath,
			final Date updatetime) {
		log.debug("updateHtmlPath");
		try {

			final String queryString = "update ArticleT as at set at.htmlPath=:htmlPath,updatetime=:updatetime where at.articleid=:articleid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("articleid", articleid);
					query.setParameter("htmlPath", htmlPath);
					query.setParameter("updatetime", updatetime);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateHtmlPath error", re);
			throw re;
		}
		return 0;
	}

	public List<ArticleT> findAllArticleBycreatorid(String creatorid) {
		log.debug("findAllArticleBycreatorid");
		try {
			String queryString = "from ArticleT as at where  at.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("countfindAllArticle error", re);
			throw re;
		}
	}

	public List<ArticleT> findAllArticleT(String status) {
		log.debug("findAllArticleT");
		try {
			String queryString = "from ArticleT as at where at.status=:status";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "status", status);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllArticleT error", re);
			throw re;
		}
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public List<ArticleT> sortAllArticleT(final int currentPage, final int lineSize, final String creatorid, final String queryString) {

		log.debug("findAllArticleT");
		try {
			List<ArticleT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findAllArticleT error", re);
			throw re;
		}

	}

	public int updateArticlepositionByarticleCategoryTid(final String articleCategoryTid, final String position) {
		log.debug("updateHtmlPath");
		try {
			final String queryString = "update ArticleT as at set at.position=:position where at.articleCategoryTid=:articleCategoryTid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("articleCategoryTid", articleCategoryTid);
					query.setParameter("position", position);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateHtmlPath error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int delArticleT(final String id) {
		log.debug("delArticleT");
		try {

			final String queryString = "delete from  ArticleT as at where at.articleid=:articleid ";
			Integer integer=(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("articleid", id);
					i = query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("delArticleT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleT> findAllArticleT(final int currentPage, final int lineSize) {
		log.debug("findAllArticleT");
		try {
			List<ArticleT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ArticleT order by createtime desc";

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
			log.error("findAllArticleT error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllArticle() {
		log.debug("countfindAllArticle");
		try {
			String queryString = "select count(*) from ArticleT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllArticle error", re);
			throw re;
		}
	}

	@Override
	public List<ArticleT> findArticlesByNavid(String navid, String status) {
		log.debug("findArticlesByNavid");
		try {
			String queryString = "from ArticleT as at where at.navid=:navid and at.status=:status";
			List<ArticleT> list = this.getHibernateTemplate().findByNamedParam(
					queryString, new String[] { "navid", "status" },
					new Object[] { navid, status });
			return list;
		} catch (RuntimeException re) {
			log.error("findArticlesByNavid error", re);
			throw re;
		}
	}

	@Override
	public List<ArticleT> findArticlesByLtypeid(String ltypeid, String status) {
		log.debug("findArticlesByLtypeid");
		try {
			String queryString = "from ArticleT as at where at.ltypeid=:ltypeid and at.status=:status";
			List<ArticleT> list = this.getHibernateTemplate().findByNamedParam(
					queryString, new String[] { "ltypeid", "status" },
					new Object[] { ltypeid, status });
			return list;
		} catch (RuntimeException re) {
			log.error("findArticlesByLtypeid error", re);
			throw re;
		}
	}

	@Override
	public List<ArticleT> findArticlesByStypeid(String stypeid, String status) {
		log.debug("findArticlesByStypeid");
		try {
			String queryString = "from ArticleT as at where at.stypeid=:stypeid and at.status=:status";
			List<ArticleT> list = this.getHibernateTemplate().findByNamedParam(
					queryString, new String[] { "stypeid", "status" },
					new Object[] { stypeid, status });
			return list;
		} catch (RuntimeException re) {
			log.error("findArticlesByStypeid error", re);
			throw re;
		}
	}

	
	
}