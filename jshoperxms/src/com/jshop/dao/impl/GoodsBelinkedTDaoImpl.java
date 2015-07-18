package com.jshop.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsBelinkedTDao;
import com.jshop.entity.GoodsBelinkedT;
@Repository("goodsBelinkedTDao")
public class GoodsBelinkedTDaoImpl extends BaseTDaoImpl<GoodsBelinkedT> implements GoodsBelinkedTDao {

	private static final Log log=LogFactory.getLog(GoodsBelinkedTDaoImpl.class);

}
