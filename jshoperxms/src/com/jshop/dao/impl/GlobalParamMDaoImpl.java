package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	

	
}