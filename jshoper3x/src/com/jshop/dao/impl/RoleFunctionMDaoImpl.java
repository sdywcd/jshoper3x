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

import com.jshop.dao.RoleFunctionMDao;
import com.jshop.entity.RoleFunctionM;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoleFunctionM entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.RoleFunctionM
 * @author MyEclipse Persistence Tools
 */
@Repository("roleFunctionMDao")
public class RoleFunctionMDaoImpl extends BaseTDaoImpl<RoleFunctionM> implements RoleFunctionMDao {
	private static final Logger log = LoggerFactory.getLogger(RoleFunctionMDaoImpl.class);

	public List<RoleFunctionM> findAllRoleFunctionMByroleid(String roleid) {
		log.debug("findAllRoleFunctionMByroleid");
		try {
			String queryString = "from RoleFunctionM as rfm where rfm.roleid=:roleid";
			List<RoleFunctionM> list = this.getHibernateTemplate().findByNamedParam(queryString, "roleid", roleid);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllRoleFunctionMByroleid error", re);
			throw re;
		}
	}

	public int delRoleFunctionM(final String roleid) {
		log.debug("delRoleFunctionM");
		try {

			final String queryString = "delete from RoleFunctionM as rfm where rfm.roleid=:roleid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					query.setParameter("roleid", roleid);
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
	
	
	
	
}