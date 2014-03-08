
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

import com.jshop.dao.MemberRechargeRecordsTDao;
import com.jshop.entity.MemberRechargeRecordsT;
import com.jshop.entity.MemberRechargeT;

public class MemberRechargeRecordsTDaoImpl extends BaseTDaoImpl<MemberRechargeRecordsT> implements MemberRechargeRecordsTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberRechargeRecordsTDaoImpl.class);
	

	@Override
	public List<MemberRechargeRecordsT> findAllMemberRechargeRecordsT(
			final int currentPage, final int lineSize) {
		log.debug("findAllMemberRechargeRecordsT");
		try {
			List<MemberRechargeRecordsT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MemberRechargeRecordsT as mrrt order by createtime desc";

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
			log.error("findAllMemberRechargeRecordsT error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllMemberRechargeRecordsT() {
		log.debug("countfindAllMemberRechargeRecordsT");
		try {
			String queryString = "select count(*) from MemberRechargeRecordsT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllMemberRechargeRecordsT error", re);
			throw re;
		}
	}

	@Override
	public void delMemberRechargeRecordsT(String[] strs) {
		log.debug("delMemberRechargeRecordsT");
		try {
			for(String s:strs){
				MemberRechargeRecordsT memberRechargeRecordsT=this.getHibernateTemplate().load(MemberRechargeRecordsT.class,s);
				this.getHibernateTemplate().delete(memberRechargeRecordsT);
			}
		} catch (RuntimeException re) {
			log.error("delMemberRechargeRecordsT failed", re);
			throw re;
		}
	}

}

