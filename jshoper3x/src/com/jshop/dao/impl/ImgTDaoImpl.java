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

import com.jshop.dao.ImgTDao;
import com.jshop.entity.ImgT;

/**
 * A data access object (DAO) providing persistence and search support for ImgT
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.jshop.entity.ImgT
 * @author MyEclipse Persistence Tools
 */
@Repository("imgTDao")
public class ImgTDaoImpl extends BaseTDaoImpl<ImgT> implements ImgTDao {
	
	private static final Logger log = LoggerFactory.getLogger(ImgTDaoImpl.class);
	

	public int countfindAllImgT() {
		log.debug("countfindAllImgT");
		try {
			String queryString = "select count(*) from ImgT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllImgT error", re);
			throw re;
		}
	}

	public int delImgT(final String[] list) {
		log.debug("delImgT");
		try {

			final String queryString = "delete from ImgT as i where i.imgId=:imgId";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("imgId", s);
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
			log.error("delImgT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<ImgT> findAllImgT(final int currentPage, final int lineSize) {
		log.debug("findAllImgT");
		try {
			List<ImgT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ImgT order by createtime desc";

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
			log.error("findAllImgT error", re);
			throw re;
		}
	}

	public int updateImgT(final ImgT i) {
		log.debug("update ImgT");
		try {

			final String queryString = "update ImgT as i set i.des=:des,i.imgTypeId=:imgTypeId,i.imgTypeName=:imgTypeName,i.creatorid=:creatorid,i.createtime=:createtime where it.imgId=:imgId ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int j = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("des", i.getDes());
					query.setParameter("creatorid", i.getCreatorid());
					query.setParameter("createtime", i.getCreatetime());
					query.setParameter("imgTypeId", i.getImgTypeId());
					query.setParameter("imgTypeName", i.getImgTypeName());
					query.setParameter("imgId", i.getImgId());
					j = query.executeUpdate();
					++j;
					return j;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  ImgT error", re);
			throw re;
		}
		return 0;
	}

	public ImgT findImgTByImgName(String imgName) {
		log.debug("findImgTByImgName");
		try {
			String queryString = "from ImgT as it where it.imgName=:imgName";
			List<ImgT> list = this.getHibernateTemplate().findByNamedParam(queryString, "imgName", imgName);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id findImgTByImgName error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ImgT> findImgTByusedGoodsidandusedPositionId(String imgId) {
		log.debug("findImgTByusedGoodsidandusedPositionId");
		try {
			String queryString = "from ImgT as i  where i.imgId=:imgId";
			List<ImgT> list = this.getHibernateTemplate().findByNamedParam(queryString, "imgId", imgId);
			if (list != null && list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("findImgTByusedGoodsidandusedPositionId error", re);
			throw re;
		}
	}

	public List<ImgT> findImgTByusedGoodsid(String usedGoodsid) {
		log.debug("findImgTByusedGoodsid");
		try {
			String queryString = "from ImgT as i where i.usedGoodsid=:usedGoodsid";
			List<ImgT> list = this.getHibernateTemplate().findByNamedParam(queryString, "usedGoodsid", usedGoodsid);
			if (list != null && list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("findImgTByusedGoodsid error", re);
			throw re;
		}
	}

	public List<ImgT> findImgTByusedGoodsidandPositionIdisNull(String usedGoodsid) {
		log.debug("findImgTByusedGoodsidandPositionIdisNull");
		try {
			String queryString = "from ImgT as i where i.usedGoodsid=:usedGoodsid and i.usedPositionId is null";
			List<ImgT> list = this.getHibernateTemplate().findByNamedParam(queryString, "usedGoodsid", usedGoodsid);
			if (list != null && list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("findImgTByusedGoodsidandPositionIdisNull error", re);
			throw re;
		}
	}

	public int updateImgState(final String imgId, final String state) {
		log.debug("updateImgState");
		try {
			final String queryString = "update ImgT as i set i.state=:state,i.usedGoodsid=null where i.imgId=:imgId ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int j = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("state", state);
					query.setParameter("imgId", imgId);
					j = query.executeUpdate();
					++j;
					return j;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateImgState error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<ImgT> findAllImgTByImgName(final int currentPage, final int lineSize, final String imgName) {
		log.debug("findAllImgTByImgName");
		try {
			List<ImgT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from ImgT as i where i.imgName=:imgName order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("imgName", imgName);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findAllImgTByImgName error", re);
			throw re;
		}
	}

	public int countfindAllImgTByImgName(String imgName) {
		log.debug("countfindAllImgTByImgName");
		try {
			String queryString = "select count(*) from ImgT as i where i.imgName=:imgName";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "imgName", imgName);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllImgTByImgName error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ImgT> sortAllImgT(final int currentPage, final int lineSize, final String queryString) {
		log.debug("findAllImgT");
		try {
			List<ImgT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

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
			log.error("findAllImgT error", re);
			throw re;
		}
	}
}