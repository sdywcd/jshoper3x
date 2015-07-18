package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.TemplatesetTDao;
import com.jshop.entity.TemplatesetT;

/**
 * A data access object (DAO) providing persistence and search support for
 * TemplatesetT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.TemplatesetT
 * @author MyEclipse Persistence Tools
 */

@Repository("templatesetTDao")
public class TemplatesetTDaoImpl extends BaseTDaoImpl<TemplatesetT> implements TemplatesetTDao {
	
	private static final Logger log = LoggerFactory.getLogger(TemplatesetTDaoImpl.class);
	


	
}