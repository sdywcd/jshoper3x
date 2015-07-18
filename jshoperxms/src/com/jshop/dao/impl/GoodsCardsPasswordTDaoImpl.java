package com.jshop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsCardsPasswordTDao;
import com.jshop.entity.GoodsCardsPasswordT;
@Repository("goodsCardsPasswordTDao")
public class GoodsCardsPasswordTDaoImpl extends BaseTDaoImpl<GoodsCardsPasswordT> implements GoodsCardsPasswordTDao{

	private static final Logger log = LoggerFactory.getLogger(GoodsCardsPasswordTDaoImpl.class);


}
