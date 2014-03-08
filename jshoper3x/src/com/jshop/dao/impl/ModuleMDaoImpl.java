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

import com.jshop.dao.ModuleMDao;
import com.jshop.entity.ModuleM;

/**
 * A data access object (DAO) providing persistence and search support for
 * ModuleM entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.ModuleM
 * @author MyEclipse Persistence Tools
 */
@Repository("moduleMDao")
public class ModuleMDaoImpl extends BaseTDaoImpl<ModuleM> implements ModuleMDao {
	private static final Logger log = LoggerFactory.getLogger(ModuleMDaoImpl.class);

	public int delModuleM(final String[] strs) {
		log.debug("delModuleM");
		try {

			final String queryString = "delete from ModuleM as mm where mm.id=:id";
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
			log.error("delModuleM failed", re);
			throw re;
		}
		return 0;
	}

	public ModuleM findModuleMById(String id) {
		log.debug("findModuleMById");
		try {
			ModuleM instance = (ModuleM) this.getHibernateTemplate().get("com.jshop.entity.ModuleM", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("findModuleMById failed", re);
			throw re;
		}
	}

	public void updateModuleM(ModuleM mm) {
		log.debug("updateModuleM");
		try {
			this.getHibernateTemplate().update(mm);
		} catch (RuntimeException re) {
			log.error("updateModuleM failed", re);
			throw re;
		}
	}

	public List<ModuleM> findAllModuleM() {
		log.debug("findAllModuleM");
		try {
			String queryString = "from ModuleM";
			List<ModuleM> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("findAllModuleM error", re);
			throw re;
		}
	}

}