package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsCategoryTDao;
import com.jshop.entity.GoodsCategoryT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsCategoryT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsCategoryT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsCategoryTDao")
public class GoodsCategoryTDaoImpl extends BaseTDaoImpl<GoodsCategoryT> implements GoodsCategoryTDao {
	

	private static final Logger log = LoggerFactory.getLogger(GoodsCategoryTDaoImpl.class);

	
}
