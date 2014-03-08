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

import com.jshop.dao.RoleMDao;
import com.jshop.entity.ModuleM;
import com.jshop.entity.RoleM;

/**
 * A data access object (DAO) providing persistence and search support for RoleM
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.jshop.entity.RoleM
 * @author MyEclipse Persistence Tools
 */
@Repository("roleMDao")
public class RoleMDaoImpl extends BaseTDaoImpl<RoleM> implements RoleMDao {
	private static final Logger log = LoggerFactory.getLogger(RoleMDaoImpl.class);

	
	public int delRoleM(final String[] strs) {
		log.debug("delRoleM");
		try {

			final String queryString = "delete from RoleM as rm where rm.id=:id";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("id", s);
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
			log.error("delRoleM failed", re);
			throw re;
		}
		return 0;
	}

	public List<RoleM> findAllRoleM() {
		log.debug("findAllRoleM");
		try {
			String queryString = "from RoleM";
			List<RoleM> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllRoleM error", re);
			throw re;
		}
	}

	public RoleM findRoleMById(String id) {
		log.debug("findRoleMById");
		try {
			RoleM instance = (RoleM) this.getHibernateTemplate().get("com.jshop.entity.RoleM", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("findModuleMById failed", re);
			throw re;
		}
	}

	public void updateRoleM(RoleM rm) {
		log.debug("updateRoleM");
		try {
			this.getHibernateTemplate().update(rm);
		} catch (RuntimeException re) {
			log.error("updateRoleM failed", re);
			throw re;
		}
	}
	


}