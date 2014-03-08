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

import com.jshop.dao.UserRoleMDao;
import com.jshop.entity.UserRoleM;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserRoleM entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.UserRoleM
 * @author MyEclipse Persistence Tools
 */
@Repository("userRoleMDao")
public class UserRoleMDaoImpl extends BaseTDaoImpl<UserRoleM> implements UserRoleMDao{
	private static final Logger log = LoggerFactory.getLogger(UserRoleMDaoImpl.class);

	

	public int delUserRoleM(final String userid) {
		log.debug("delRoleFunctionM");
		try {

			final String queryString = "delete from UserRoleM as rfm where rfm.userid=:userid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					query.setParameter("userid", userid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("delFunctionM failed", re);
			throw re;
		}
		return 0;
	}

	public List<UserRoleM> findUserRoleMByuserid(String userid) {
		log.debug("findUserRoleMByuserid");
		try {
			String queryString = "from UserRoleM as urm where urm.userid=:userid";
			List<UserRoleM> list = this.getHibernateTemplate().findByNamedParam(queryString, "userid", userid);
			return list;
		} catch (RuntimeException re) {
			log.error("findUserRoleMByuserid error", re);
			throw re;
		}
	}
	
}