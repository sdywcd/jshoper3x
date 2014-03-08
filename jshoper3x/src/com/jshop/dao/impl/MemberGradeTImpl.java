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

import com.jshop.dao.MemberGradeTDao;
import com.jshop.entity.MemberGradeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GradeT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.GradeT
 * @author MyEclipse Persistence Tools
 */
@Repository("memberGradeTDao")
public class MemberGradeTImpl extends BaseTDaoImpl<MemberGradeT> implements MemberGradeTDao {
	
	private static final Log log = LogFactory.getLog(MemberGradeTImpl.class);
	
	public int countfindAllMemberGradeT() {
		log.debug("count all MemberGradeT");
		try {
			String queryString = "select count(*) from MemberGradeT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all MemberGradeT error", re);
			throw re;
		}
	}

	public void delMemberGradeT(final String[] strs) {
		log.debug("del MemberGradeT");
		try {
			for(String s:strs){
				MemberGradeT memberGradeT=this.getHibernateTemplate().load(MemberGradeT.class,s);
				this.getHibernateTemplate().delete(memberGradeT);
			}
		} catch (RuntimeException re) {
			log.error("del MemberGradeT failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MemberGradeT> findAllMemberGradeT(final int currentPage, final int lineSize) {
		log.debug("find all MemberGradeT");
		try {
			List<MemberGradeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MemberGradeT  order by createtime desc";

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
			log.error("find all MemberGradeT error", re);
			throw re;
		}
	}

	public MemberGradeT findMemberGradeTById(String id) {
		log.debug("find by id MemberGradeT");
		try {
			String queryString = "from MemberGradeT as gt where gt.id=:id";
			List<MemberGradeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "id", id);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id MemberGradeT error", re);
			throw re;
		}
	}

	public void updateMemberGradeTById(MemberGradeT mgt) {
		log.debug("update MemberGradeT");
		try {
			this.getHibernateTemplate().update(mgt);
		} catch (RuntimeException re) {
			log.error("update  MemberGradeT error", re);
			throw re;
		}
	}

	@Override
	public List<MemberGradeT> findAllMemberGradeT() {
		log.debug("findAllMemberGradeT");
		try {
			String queryString = "from MemberGradeT";
			List<MemberGradeT> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id findAllMemberGradeT error", re);
			throw re;
		}
	}
	
	
	
	
	
}