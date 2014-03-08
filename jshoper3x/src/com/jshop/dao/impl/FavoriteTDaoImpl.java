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

import com.jshop.dao.FavoriteTDao;
import com.jshop.entity.FavoriteT;

/**
 * A data access object (DAO) providing persistence and search support for
 * FavoriteT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.FavoriteT
 * @author MyEclipse Persistence Tools
 */
@Repository("favoriteTDao")
public class FavoriteTDaoImpl extends BaseTDaoImpl<FavoriteT> implements FavoriteTDao {
	
	private static final Log log = LogFactory.getLog(FavoriteTDaoImpl.class);

	public int countfindAllFavoriteByUserid(String userid) {
		log.debug("count all FavoriteT");
		try {
			String queryString = "select count(*) from FavoriteT as f where f.userid=:userid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "userid", userid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all FavoriteT error", re);
			throw re;
		}
	}

	public int delFavorite(final String[] list) {
		log.debug("del FavoriteT");
		try {

			final String queryString = "delete from FavoriteT as f where f.favoriteid=:favoriteid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("favoriteid", s);
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
			log.error("del FavoriteT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<FavoriteT> findAllFavoriteByUserid(final String userid, final int currentPage, final int lineSize) {
		log.debug("find all FavoriteT by userid");
		try {
			List<FavoriteT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from FavoriteT as f where f.userid=:userid order by addtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("userid", userid);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all FavoriteT by userid error", re);
			throw re;
		}
	}
}