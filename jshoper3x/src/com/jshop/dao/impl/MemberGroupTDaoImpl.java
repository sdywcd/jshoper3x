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

import com.jshop.dao.MemberGroupTDao;
import com.jshop.entity.MemberGroupT;
import com.jshop.entity.TemplateT;

@Repository("memberGroupTDao")
public class MemberGroupTDaoImpl extends BaseTDaoImpl<MemberGroupT> implements MemberGroupTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberGroupTDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberGroupT> findAllMemberGroupT(final int currentPage, final int lineSize) {
		log.debug("find all MemberGroupT");
		try {
			List<MemberGroupT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MemberGroupT as mgt order by createtime desc";

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
			log.error("find all MemberGroupT error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllMemberGroupT() {
		log.debug("count all MemberGroupT");
		try {
			String queryString = "select count(*) from MemberGroupT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all MemberGroupT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberGroupT> findAllMemberGroupT(final int currentPage,
			final int lineSize, final String creatorid) {
		log.debug("find all MemberGroupT");
		try {
			List<MemberGroupT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MemberGroupT as mgt where mgt.creatorid=:creatorid order by createtime desc";

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
			log.error("find all MemberGroupT error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllMemberGroupT(String creatorid) {
		log.debug("countfindAllMemberGroupT");
		try {
			String queryString = "select count(*) from MemberGroupT as mgt where mgt.creatorid=:creatorid";
			List<MemberGroupT> list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllMemberGroupT error", re);
			throw re;
		}
	}

	@Override
	public void updateMemberGroupT(MemberGroupT mgt) {
		log.debug("update MemberGroupT");
		try {
			this.getHibernateTemplate().update(mgt);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	

	@Override
	public MemberGroupT findMemberGroupTById(String id) {
		log.debug("findMemberGroupTById");
		try {
			String queryString = "from MemberGroupT as mgt where mgt.id=:id";
			List<MemberGroupT> list = this.getHibernateTemplate().findByNamedParam(queryString, "id", id);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findMemberGroupTById error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int delMemberGroupT(final String[] strs) {
		log.debug("delMemberGroupT");
		try {
			final String queryString = "delete from MemberGroupT as mgt where mgt.id=:id";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("id", s);
						i = query.executeUpdate();
					}
					if (strs.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("delMemberGroupT", re);
			throw re;
		}
		return 0;
	}

	@Override
	public List<MemberGroupT> findMemberGroupTByname(String name) {
		log.debug("findMemberGroupTByname");
		try {
			String queryString = "from MemberGroupT as mgt where mgt.name=:name";
			List<MemberGroupT> list = this.getHibernateTemplate().findByNamedParam(queryString, "name", name);
			return list;
		} catch (RuntimeException re) {
			log.error("findMemberGroupTByname error", re);
			throw re;
		}
	}

	@Override
	public List<MemberGroupT> findAllMemberGroup(String status) {
		log.debug("findAllMemberGroup");
		try {
			String queryString = "from MemberGroupT as mgt where mgt.status=:status";
			List<MemberGroupT> list = this.getHibernateTemplate().findByNamedParam(queryString, "status", status);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllMemberGroup error", re);
			throw re;
		}
	}

}
