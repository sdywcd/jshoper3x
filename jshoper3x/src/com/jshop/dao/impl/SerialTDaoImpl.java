package com.jshop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.SerialTDao;
import com.jshop.entity.SerialT;

/**
 * A data access object (DAO) providing persistence and search support for
 * SerialT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.SerialT
 * @author MyEclipse Persistence Tools
 */
@Repository("serialTDao")
public class SerialTDaoImpl extends BaseTDaoImpl<SerialT> implements SerialTDao {
	
	private static final Log log = LogFactory.getLog(SerialTDaoImpl.class);
	

	public SerialT findBybaseid(String biz) {
		log.debug("finding newestid by baseid");
		try {
			String queryString = "from SerialT as st where st.biz='" + biz + "'";
			List<SerialT> list = this.getHibernateTemplate().find(queryString);
			return list.get(0);
		} catch (RuntimeException re) {
			log.error("finding newestid failed", re);
			throw re;
		}
	}

	public void save(SerialT transientInstance) {
		log.debug("saving SerialT instance");
		try {
			this.getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int updateBybaseid(SerialT transientInstance) {
		log.debug("update newestid");
		try {
			String queryString = "update SerialT as st set st.lastid=st.lastid+st.increment where st.biz='" + transientInstance.getBiz() + "'";
			int i = this.getHibernateTemplate().bulkUpdate(queryString);
			if (i > 0) {
				return i;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("update newest failed", re);
			throw re;
		}
	}


}