package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.jshop.dao.ArticleCategoryTDao;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.GoodsCategoryT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ArticleCategoryT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.ArticleCategoryT
 * @author MyEclipse Persistence Tools
 */
@Repository("articleCategoryTDao")
public class ArticleCategoryTDaoImpl extends BaseTDaoImpl<ArticleCategoryT> implements ArticleCategoryTDao {

	private static final Logger log = LoggerFactory.getLogger(ArticleCategoryTDaoImpl.class);


	public int checkArticleCategoryName(String name, String creatorid) {
		log.debug("checkArticleCategoryName");
		try {
			String queryString = "from ArticleCategoryT as act where act.name=:name and act.creatorid=:creatorid";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "name", "creatorid" }, new Object[] { name, creatorid });
			if (!list.isEmpty()) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkArticleCategoryName error", re);
			throw re;
		}
	}

	public int checkArticleCategoryNamewithoutMe(String articleCategoryTid, String name, String creatorid) {
		log.debug("checkArticleCategoryNamewithoutMe");
		try {
			String queryString = "from ArticleCategoryT as act where act.name=:name and act.articleCategoryTid!=:articleCategoryTid and act.creatorid=:creatorid";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "name", "articleCategoryTid", "creatorid" }, new Object[] { name, articleCategoryTid, creatorid });
			if (!list.isEmpty()) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkArticleCategoryNamewithoutMe error", re);
			throw re;
		}
	}

	public int checkArticleCategorySign(String sign, String creatorid) {
		log.debug("checkArticleCategorySign");
		try {
			String queryString = "from ArticleCategoryT as act where act.sign=:sign and act.creatorid=:creatorid";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "sign", "creatorid" }, new Object[] { sign, creatorid });
			if (!list.isEmpty()) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkArticleCategorySign error", re);
			throw re;
		}

	}

	public int checkArticleCategorySignwithoutMe(String articleCategoryTid, String sign, String creatorid) {
		log.debug("checkArticleCategorySignwithoutMe");
		try {
			String queryString = "from ArticleCategoryT as act where act.sign=:sign and act.articleCategoryTid!=:articleCategoryTid and act.creatorid=:creatorid";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "sign", "articleCategoryTid", "creatorid" }, new Object[] { sign, articleCategoryTid, creatorid });
			if (!list.isEmpty()) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkArticleCategorySignwithoutMe error", re);
			throw re;
		}
	}

	public int countfindAllArticleCategoryT(String status, String creatorid) {
		log.debug("countfindAllArticleCategoryT");
		try {
			String queryString = "select count(*) from ArticleCategoryT as act where act.status=:status and act.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "status", "creatorid" }, new Object[] { status, creatorid });
			if (!list.isEmpty()) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllArticleCategoryT error", re);
			throw re;
		}
	}

	public int countfindAllArticleCategoryTByGrade(String grade, String status, String creatorid) {
		log.debug("countfindAllArticleCategoryTByGrade");
		try {
			String queryString = "select count(*) from ArticleCategoryT as act where act.grade=:grade and act.status=:status and act.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "grade", "status", "creatorid" }, new Object[] { grade, status, creatorid });
			if (!list.isEmpty()) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllArticleCategoryTByGrade error", re);
			throw re;
		}
	}

	public void delArticleCategoryT(ArticleCategoryT act) {
		log.debug("delArticleCategoryT");
		try {
			this.getHibernateTemplate().update(act);

		} catch (RuntimeException re) {
			log.error("delArticleCategoryT error", re);
			throw re;
		}

	}

	@SuppressWarnings("unchecked")
	public List<ArticleCategoryT> findAllArticleCategoryT(final int currentPage, final int lineSize, final String status, final String creatorid) {
		log.debug("findAllArticleCategoryT");
		try {
			List<ArticleCategoryT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ArticleCategoryT as act where act.status=:status and act.creatorid=:creatorid  order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("status", status);
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
			log.error("findAllArticleCategoryT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ArticleCategoryT> findAllArticleCategoryTByGrade(final int currentPage, final int lineSize, final String status, final String grade, final String creatorid) {
		log.debug("findAllArticleCategoryTByGrade");
		try {
			List<ArticleCategoryT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ArticleCategoryT as act where act.status=:status and act.grade=:grade and act.creatorid=:creatorid order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("status", status);
					query.setParameter("grade", grade);
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
			log.error("findAllArticleCategoryTByGrade error", re);
			throw re;
		}
	}

	public ArticleCategoryT findArticleCategoryByarticleCategoryTid(String articleCategoryTid) {
		log.debug("getting GoodsCategoryT instance with id: " + articleCategoryTid);
		try {
			ArticleCategoryT instance = (ArticleCategoryT) this.getHibernateTemplate().get("com.jshop.entity.ArticleCategoryT", articleCategoryTid);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ArticleCategoryT> findArticleCategoryByGrade(String grade, String status, String creatorid) {
		log.debug("findArticleCategoryByGrade");
		try {
			String queryString = "from ArticleCategoryT as act where act.status=:status and act.grade=:grade and act.creatorid=:creatorid order by grade asc";
			List<ArticleCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "status", "grade", "creatorid" }, new Object[] { status, grade, creatorid });
			return list;
		} catch (RuntimeException re) {
			log.error("findArticleCategoryByGrade error", re);
			throw re;
		}
	}

	public List<ArticleCategoryT> findArticleCategoryByparentId(String status, String parentId, String creatorid) {
		log.debug("findArticleCategoryByparentId");
		try {
			String queryString = "from ArticleCategoryT as act where act.parentId=:parentId and act.status=:status and act.creatorid=:creatorid";
			List<ArticleCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "parentId", "status", "creatorid" }, new Object[] { parentId, status, creatorid });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findArticleCategoryByparentId error", re);
			throw re;
		}
	}

	public List<ArticleCategoryT> findArticleCategoryByparentIdnull(String status, String creatorid) {
		log.debug("findArticleCategoryByparentIdnull");
		try {
			String queryString = "from ArticleCategoryT as act where act.parentId is null and act.status=:status and act.creatorid=:creatorid";
			List<ArticleCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "status", "creatorid" }, new Object[] { status, creatorid });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findArticleCategoryByparentIdnull error", re);
			throw re;
		}
	}

	public ArticleCategoryT findPathParentIdByParentId(String parentId, String creatorid) {
		log.debug("findPathParentIdByParentId");
		try {
			String queryString = "from ArticleCategoryT as act where act.parentId=:parentId and act.creatorid=:creatorid";
			List<ArticleCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "parentId", "creatorid" }, new Object[] { parentId, creatorid });
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findPathParentIdByParentId error", re);
			throw re;
		}
	}


	public List<ArticleCategoryT> findAllArticleCategoryBycreatorid(String creatorid) {
		log.debug("findAllArticleCategoryBycreatorid");
		try {
			String queryString = "from ArticleCategoryT as act where  act.creatorid=:creatorid";
			List<ArticleCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllArticleCategoryBycreatorid error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ArticleCategoryT> findArticleCategoryByposition(final int lineSize, final String status, final String position, final String creatorid) {
		log.debug("findArticleCategoryByposition");
		try {
			List<ArticleCategoryT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ArticleCategoryT as act where act.status=:status and act.position=:position and act.creatorid=:creatorid order by sort asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setMaxResults(lineSize);
					query.setParameter("status", status);
					query.setParameter("position", position);
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
			log.error("findArticleCategoryByposition error", re);
			throw re;
		}
	}

	public List<ArticleCategoryT> findArticleCategoryByposition(final int lineSize, final String status, final String position) {
		log.debug("findArticleCategoryByposition");
		try {
			List<ArticleCategoryT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ArticleCategoryT as act where act.status=:status and act.position=:position  order by sort asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setMaxResults(lineSize);
					query.setParameter("status", status);
					query.setParameter("position", position);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findArticleCategoryByposition error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ArticleCategoryT> sortAllArticleCategoryT(final int currentPage, final int lineSize, final String status, final String creatorid, final String queryString) {
		log.debug("findAllArticleCategoryT");
		try {
			List<ArticleCategoryT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("status", status);
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
			log.error("findAllArticleCategoryT error", re);
			throw re;
		}
	}

	public List<ArticleCategoryT> findArticleCategoryByGrade(String grade, String status) {
		log.debug("findArticleCategoryByGrade");
		try {
			String queryString = "from ArticleCategoryT as act where act.status=:status and act.grade=:grade order by sort asc";
			List<ArticleCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "status", "grade" }, new Object[] { status, grade });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findArticleCategoryByGrade error", re);
			throw re;
		}
	}

	@Override
	public int checkArticleCategoryName(String name) {
		log.debug("checkArticleCategoryName");
		try {
			String queryString = "from ArticleCategoryT as act where act.name=:name";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString,"name", name);
			if (!list.isEmpty()) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkArticleCategoryName error", re);
			throw re;
		}
	}

	@Override
	public int checkArticleCategorySign(String sign) {
		log.debug("checkArticleCategorySign");
		try {
			String queryString = "from ArticleCategoryT as act where act.sign=:sign";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, "sign", sign);
			if (!list.isEmpty()) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkArticleCategorySign error", re);
			throw re;
		}
	}

	@Override
	public int checkArticleCategoryNamewithoutMe(String articleCategoryTid,
			String name) {
		log.debug("checkArticleCategoryNamewithoutMe");
		try {
			String queryString = "from ArticleCategoryT as act where act.name=:name and act.articleCategoryTid!=:articleCategoryTid";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "name", "articleCategoryTid" }, new Object[] { name, articleCategoryTid});
			if (!list.isEmpty()) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkArticleCategoryNamewithoutMe error", re);
			throw re;
		}
	}

	@Override
	public int checkArticleCategorySignwithoutMe(String articleCategoryTid,
			String sign) {
		log.debug("checkArticleCategorySignwithoutMe");
		try {
			String queryString = "from ArticleCategoryT as act where act.sign=:sign and act.articleCategoryTid!=:articleCategoryTid";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "sign", "articleCategoryTid"}, new Object[] { sign, articleCategoryTid });
			if (!list.isEmpty()) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("checkArticleCategorySignwithoutMe error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleCategoryT> findArticleCategoryByparentId(String status,
			String parentId) {
		log.debug("find by id findArticleCategoryByparentId");
		try {
			String queryString = "from ArticleCategoryT as act where act.parentId=:parentId and act.status=:status";
			List<ArticleCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "parentId", "status" }, new Object[] { parentId, status });
			return list;
		} catch (RuntimeException re) {
			log.error("find by id findArticleCategoryByparentId error", re);
			throw re;
		}
	}

	@Override
	public void delArticleCategoryT(final String strs[]) {
		log.debug("delArticleCategoryT");
		try {
			for(String s:strs){
				ArticleCategoryT articleCategoryT=this.getHibernateTemplate().load(ArticleCategoryT.class, s);
				this.getHibernateTemplate().delete(articleCategoryT);
			}
		} catch (RuntimeException re) {
			log.error("delArticleCategoryT failed", re);
			throw re;
		}
	
	}





}