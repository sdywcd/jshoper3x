package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsCardsTDao;
import com.jshop.entity.GoodsCardsT;

@Repository("goodsCardsTDao")
public class GoodsCardsTDaoImpl extends BaseTDaoImpl<GoodsCardsT> implements GoodsCardsTDao{
	private static final Logger log = LoggerFactory.getLogger(GoodsCardsTDaoImpl.class);

}
