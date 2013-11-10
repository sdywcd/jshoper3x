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

import com.jshop.dao.MemberRechargeTDao;
import com.jshop.entity.ArticleT;
import com.jshop.entity.MemberGradeT;
import com.jshop.entity.MemberRechargeT;
@Repository("memberRechargeTDao")
public class MemberRechargeTDaoImpl extends HibernateDaoSupport implements MemberRechargeTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberRechargeTDaoImpl.class);
	
	@Override
	public void saveMemberRechargeT(MemberRechargeT mrt) {
		log.debug("save MemberRechargeT");
		try {
			this.getHibernateTemplate().save(mrt);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public List<MemberRechargeT> findAllMemberRechargeT(final int currentPage,
			final int lineSize) {
		log.debug("findAllMemberRechargeT");
		try {
			List<MemberRechargeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MemberRechargeT as mrt order by createtime desc";

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
			log.error("findAllMemberRechargeT error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllMemberRechargeT() {
		log.debug("countfindAllMemberRechargeT");
		try {
			String queryString = "select count(*) from MemberRechargeT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllMemberRechargeT error", re);
			throw re;
		}
	}

	@Override
	public void updateMemberRechargeT(MemberRechargeT mrt) {
		log.debug("updateMemberRechargeT");
		try {
			this.getHibernateTemplate().update(mrt);
		} catch (RuntimeException re) {
			log.error("updateMemberRechargeT error", re);
			throw re;
		}

	}

	@Override
	public void delMemberRechargeT(String[] strs) {
		log.debug("delMemberRechargeT");
		try {
			for(String s:strs){
				MemberRechargeT memberRechargeT=this.getHibernateTemplate().load(MemberRechargeT.class,s);
				this.getHibernateTemplate().delete(memberRechargeT);
			}
		} catch (RuntimeException re) {
			log.error("delMemberRechargeT failed", re);
			throw re;
		}

	}

}
