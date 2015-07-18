package com.jshop.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.LogisticsBAreaTDao;
import com.jshop.entity.LogisticsbusinessareaT;

/**
 * A data access object (DAO) providing persistence and search support for
 * LogisticsbusinessareaT entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.LogisticsbusinessareaT
 * @author MyEclipse Persistence Tools
 */
@Repository("logisticsBAreaTDao")
public class LogisticsBAreaTDaoImpl extends BaseTDaoImpl<LogisticsbusinessareaT> implements LogisticsBAreaTDao {
	

	private static final Log log = LogFactory.getLog(LogisticsBAreaTDaoImpl.class);

}