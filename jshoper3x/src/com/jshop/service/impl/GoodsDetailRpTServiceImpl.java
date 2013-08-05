package com.jshop.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsDetailRpTDao;
import com.jshop.entity.GoodsDetailRpT;
import com.jshop.service.GoodsDetailRpTService;
@Service("goodsDetailRpTService")
@Scope("prototype")
public class GoodsDetailRpTServiceImpl implements GoodsDetailRpTService {
	@Resource
	private GoodsDetailRpTDao goodsDetailRpTDao;
	
	public GoodsDetailRpTDao getGoodsDetailRpTDao() {
		return goodsDetailRpTDao;
	}

	public void setGoodsDetailRpTDao(GoodsDetailRpTDao goodsDetailRpTDao) {
		this.goodsDetailRpTDao = goodsDetailRpTDao;
	}

	@Override
	public void saveGoodsDetailRpT(GoodsDetailRpT gdrt) {
		this.getGoodsDetailRpTDao().saveGoodsDetailRpT(gdrt);
	}

	@Override
	public GoodsDetailRpT findGoodsDetailRpBygoodsid(String goodsid) {
		return this.getGoodsDetailRpTDao().findGoodsDetailRpBygoodsid(goodsid);
	}

}
