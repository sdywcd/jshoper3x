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

import com.jshop.dao.GoodsBelinkedTDao;
import com.jshop.entity.FavoriteT;
import com.jshop.entity.GoodsBelinkedT;
import com.jshop.entity.MemberGradeT;
@Repository("goodsBelinkedTDao")
public class GoodsBelinkedTDaoImpl extends BaseTDaoImpl<GoodsBelinkedT> implements GoodsBelinkedTDao {

	private static final Log log=LogFactory.getLog(GoodsBelinkedTDaoImpl.class);


	@Override
	public int updateGoodsBelinked(GoodsBelinkedT gbel) {
		log.debug("update GoodsBelinkedT");
		try {
			this.getHibernateTemplate().update(gbel);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsBelinkedT> findGoodsBelinkedBymaingoodsid(
			String maingoodsid) {
		log.debug("findGoodsBelinkedBymaingoodsid");
		try {
			String queryString = "from GoodsBelinkedT as gbel where gbel.maingoodsid=:maingoodsid";
			List<GoodsBelinkedT> list = this.getHibernateTemplate().findByNamedParam(queryString,"maingoodsid", maingoodsid);
			return list;
		} catch (RuntimeException re) {
			log.error("findGoodsBelinkedBymaingoodsid error", re);
			throw re;
		}
	}

	@Override
	public int delGoodsBelinkedBymaingoodsid(final String maingoodsid) {
		log.debug("delGoodsBelinkedBymaingoodsid");
		try {
			final String queryString = "delete from  GoodsBelinkedT as gbel where maingoodsid=:maingoodsid and sxlinkedgoodsid=:maingoodsid";
			Integer integer=(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("maingoodsid", maingoodsid);
					i = query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("delGoodsBelinkedBymaingoodsid error", re);
			throw re;
		}
	}

	@Override
	public int delGoodsBelinkedBymaingoodsidandsxlinkedgoodsid(
			final String maingoodsid, final String sxlinkedgoodsid) {
		log.debug("delGoodsBelinkedBymaingoodsidandsxlinkedgoodsid");
		try {
			final String queryString = "delete from  GoodsBelinkedT as gbel where maingoodsid=:maingoodsid and sxlinkedgoodsid=:sxlinkedgoodsid";
			Integer integer=(Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("maingoodsid", maingoodsid);
					query.setParameter("sxlinkedgoodsid", sxlinkedgoodsid);
					i = query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("delGoodsBelinkedBymaingoodsidandsxlinkedgoodsid error", re);
			throw re;
		}
	}

	@Override
	public List<GoodsBelinkedT> findAllGoodsBelinked(final int currentPage,
			final int lineSize) {
		log.debug("find all FavoriteT by userid");
		try {
			List<GoodsBelinkedT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsBelinkedT  order by createtime desc";

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
			log.error("find all GoodsBelinkedT by userid error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllGoodsBelinked() {
		log.debug("count all countfindAllGoodsBelinked");
		try {
			String queryString = "select count(*) from GoodsBelinkedT ";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllGoodsBelinked error", re);
			throw re;
		}
	}

	@Override
	public void delGoodsBelinked(String[] strs) {
		log.debug("del delGoodsBelinked");
		try {
			for(String s:strs){
				GoodsBelinkedT goodsBelinkedT=this.getHibernateTemplate().load(GoodsBelinkedT.class,s);
				this.getHibernateTemplate().delete(goodsBelinkedT);
			}
		} catch (RuntimeException re) {
			log.error("del delGoodsBelinked failed", re);
			throw re;
		}
	}


	

}
