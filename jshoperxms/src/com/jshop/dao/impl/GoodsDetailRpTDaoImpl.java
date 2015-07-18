package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsDetailRpTDao;
import com.jshop.entity.GoodsDetailRpT;

@Repository("goodsDetailRpTDao")
public class GoodsDetailRpTDaoImpl extends BaseTDaoImpl<GoodsDetailRpT>
		implements GoodsDetailRpTDao {
	private static final Logger log = LoggerFactory
			.getLogger(ArticleCategoryTDaoImpl.class);



}
