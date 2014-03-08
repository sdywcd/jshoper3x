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

import com.jshop.dao.GlobalParamMDao;
import com.jshop.entity.GlobalParamM;

/**
 * A data access object (DAO) providing persistence and search support for
 * GlobalParamM entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GlobalParamM
 * @author MyEclipse Persistence Tools
 */
@Repository("globalParamMDao")
public class GlobalParamMDaoImpl extends BaseTDaoImpl<GlobalParamM> implements GlobalParamMDao {
	

	private static final Logger log = LoggerFactory.getLogger(GlobalParamMDaoImpl.class);
	

	public GlobalParamM findValueByKey(String key) {
		log.debug("find by id findValueByKey");
		try {
			String queryString = "from GlobalParamM as gm where gm.gkey=:key";
			List<GlobalParamM> list = this.getHibernateTemplate().findByNamedParam(queryString, "key", key);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id findValueByKey error", re);
			throw re;
		}
	}

	public void updateGolbalParamByKey(final GlobalParamM gm) {
		log.debug("update UpdateGolbalParamByKey");
		try {
			this.getHibernateTemplate().update(gm);
		} catch (RuntimeException re) {
			log.error("update  UpdateGolbalParamByKey error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GlobalParamM> findAllGlobalParam() {
		log.debug("find all findAllGlobalParam");
		try {
			String queryString = "from GlobalParamM";
			List<GlobalParamM> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find all findAllGlobalParam error", re);
			throw re;
		}
	}
}