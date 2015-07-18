package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsAttributeRpTDao;
import com.jshop.entity.GoodsAttributeRpT;
@Repository("goodsAttributeRpTDao")
public class GoodsAttributeRpTDaoImpl extends BaseTDaoImpl<GoodsAttributeRpT>  implements GoodsAttributeRpTDao {
	private static final Logger log = LoggerFactory.getLogger(GoodsAttributeRpTDaoImpl.class);



}
