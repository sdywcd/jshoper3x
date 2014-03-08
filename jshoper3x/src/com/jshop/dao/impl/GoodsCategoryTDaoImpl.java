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

import com.jshop.dao.GoodsCategoryTDao;
import com.jshop.entity.GoodsCategoryT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsCategoryT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsCategoryT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsCategoryTDao")
public class GoodsCategoryTDaoImpl extends BaseTDaoImpl<GoodsCategoryT> implements GoodsCategoryTDao {
	

	private static final Logger log = LoggerFactory.getLogger(GoodsCategoryTDaoImpl.class);
	public GoodsCategoryT findPathParentIdByParentId(String parentId) {
		log.debug("find by id GoodsCategoryT");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.parentId=:parentId";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, "parentId", parentId);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id GoodsCategoryT error", re);
			throw re;
		}

	}

	public List<GoodsCategoryT> findGoodsCategoryByGrade(String grade, String state) {
		log.debug("find all GoodsCategoryT by state");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.state=:state and gct.grade=:grade order by createtime desc";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "state", "grade" }, new Object[] { state, grade });
			return list;
		} catch (RuntimeException re) {
			log.error("find all GoodsCategoryT by state error", re);
			throw re;
		}
	}

	public int checkGoodscategoryName(String name) {
		log.debug("find by id checkGoodscategoryName");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.name=:name";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, "name", name);
			if (list != null && list.size() > 0) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("find by id checkGoodscategoryName error", re);
			throw re;
		}

	}

	public int checkGoodscategorySign(String sign) {
		log.debug("find by id checkGoodscategorySign");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.sign=:sign";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, "sign", sign);
			if (list != null && list.size() > 0) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("find by id checkGoodscategorySign error", re);
			throw re;
		}

	}

	public int countfindAllGoodsCategoryT(String state) {
		log.debug("countfindAllGoodsCategoryT");
		try {
			String queryString = "select count(*) from GoodsCategoryT as gct where gct.state=:state";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "state", state);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllGoodsCategoryT error", re);
			throw re;
		}
	}

	public int countfindAllGoodsCategoryTByGrade(String grade, String state) {
		log.debug("countfindAllGoodsCategoryTByGrade");
		try {
			String queryString = "select count(*) from GoodsCategoryT as gct where gct.grade=:grade and gct.state=:state";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "grade", "state" }, new Object[] { grade, state });
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllGoodsCategoryTByGrade error", re);
			throw re;
		}
	}

	public int delGoodscategoryT(final String goodsCategoryTid, final String state) {
		log.debug("delGoodscategoryT GoodsCategoryT");
		try {
			final String queryString = "update GoodsCategoryT as gct set gct.state=:state where gct.goodsCategoryTid=:goodsCategoryTid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("state", state);
					query.setParameter("goodsCategoryTid", goodsCategoryTid);
					i = query.executeUpdate();
					return 1;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  GoodsCategoryT error", re);
			throw re;
		}
		return 0;

	}

	@SuppressWarnings("unchecked")
	public List<GoodsCategoryT> findAllGoodsCategoryT(final int currentPage, final int lineSize, final String state) {
		log.debug("find all findAllGoodsCategoryT");
		try {
			List<GoodsCategoryT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsCategoryT as gct where gct.state=:state  order by grade asc,sort asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("state", state);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findAllGoodsCategoryT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsCategoryT> findAllGoodsCategoryTByGrade(final int currentPage, final int lineSize, final String grade, final String state) {
		log.debug("find all findAllGoodsCategoryTByGrade");
		try {
			List<GoodsCategoryT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsCategoryT as gct where gct.state=:state and gct.grade=:grade order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("state", state);
					query.setParameter("grade", grade);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findAllGoodsCategoryTByGrade error", re);
			throw re;
		}
	}

	public int updateGoodscategoryT(final GoodsCategoryT gct) {
		log.debug(" updateGoodscategoryT");
		try {
			this.getHibernateTemplate().update(gct);
			return 1;
		} catch (RuntimeException re) {
			log.error("updateGoodscategoryT error", re);
			throw re;
		}

	}

	public GoodsCategoryT findGoodscategoryBygoodscategoryId(String goodsCategoryTid) {
		log.debug("getting GoodsCategoryT instance with id: " + goodsCategoryTid);
		try {
			GoodsCategoryT instance = (GoodsCategoryT) this.getHibernateTemplate().get("com.jshop.entity.GoodsCategoryT", goodsCategoryTid);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int checkGoodscategoryNamewithoutMe(String goodsCategoryTid, String name) {
		log.debug("find by id checkGoodscategoryNameMe");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.name=:name and gct.goodsCategoryTid!=:goodsCategoryTid";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "name", "goodsCategoryTid" }, new Object[] { name, goodsCategoryTid });
			if (list != null && list.size() > 0) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("find by id checkGoodscategoryNameMe error", re);
			throw re;
		}
	}

	public int checkGoodscategorySignwithoutMe(String goodsCategoryTid, String sign) {
		log.debug("find by id checkGoodscategorySignMe");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.sign=:sign and gct.goodsCategoryTid!=:goodsCategoryTid";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "sign", "goodsCategoryTid" }, new Object[] { sign, goodsCategoryTid });
			if (list != null && list.size() > 0) {
				return 1;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("find by id checkGoodscategorySign error", re);
			throw re;
		}
	}

	public List<GoodsCategoryT> findGoodscategoryByparentId(String state, String parentId) {
		log.debug("find by id findGoodscategoryByparentId");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.parentId=:parentId and gct.state=:state";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "parentId", "state" }, new Object[] { parentId, state });
			return list;
		} catch (RuntimeException re) {
			log.error("find by id findGoodscategoryByparentId error", re);
			throw re;
		}
	}

	public List<GoodsCategoryT> findGoodscategoryByparentIdnull(String state) {
		log.debug("find by id findGoodscategoryByparentIdnull");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.parentId is null and gct.state=:state";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, "state", state);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id findGoodscategoryByparentIdnull error", re);
			throw re;
		}
	}

	public List<GoodsCategoryT> findAllGoodsCategoryBycreatorid(String creatorid) {
		log.debug("find by id findAllGoodsCategoryBycreatorid");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.creatorid=:creatorid and gct.state='1' order by grade asc";
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id findAllGoodsCategoryBycreatorid error", re);
			throw re;
		}
	}

	public int updateHtmlPath(final String goodsCategoryTid, final String htmlpath) {
		log.debug("updateHtmlPath");
		try {

			final String queryString = "update GoodsCategoryT as gct set gct.htmlpath=:htmlpath where gct.goodsCategoryTid=:goodsCategoryTid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsCategoryTid", goodsCategoryTid);
					query.setParameter("htmlpath", htmlpath);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  GoodsAttributeT error", re);
			throw re;
		}
		return 0;
	}

	public List<GoodsCategoryT> findAllGoodsCategoryT(String state) {
		log.debug("findAllGoodsCategoryT");
		try {
			String queryString = "from GoodsCategoryT as gct where gct.state=:state";
			@SuppressWarnings("unchecked")
			List<GoodsCategoryT> list = this.getHibernateTemplate().findByNamedParam(queryString, "state", state);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllGoodsCategoryT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsCategoryT> sortAllGoodsCategoryT(final int currentPage, final int lineSize, final String state, final String queryString) {
		log.debug("find all findAllGoodsCategoryT");
		try {
			List<GoodsCategoryT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("state", state);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findAllGoodsCategoryT error", re);
			throw re;
		}
	}

	@Override
	public List<GoodsCategoryT> findAllCategoryByNoTrem() {
		try {
			final String queryString="from GoodsCategoryT";
			@SuppressWarnings("unchecked")
			List<GoodsCategoryT> list =this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query= session.createQuery(queryString);
					List list=query.list();
					return list;
				}
			});
			if(list.size()>0){
				return list;
			}
			return null;
		} catch (RuntimeException e) {
			throw e;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public int delGoodscategoryT(final String[] strs) {
		log.debug("del delGoodscategoryT");
		try {

			final String queryString = "delete from GoodsCategoryT as gct where gct.goodsCategoryTid=:goodsCategoryTid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("goodsCategoryTid", s);
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
			log.error("del delGoodscategoryT failed", re);
			throw re;
		}
		return 0;
	}



	
	
	
	
}
