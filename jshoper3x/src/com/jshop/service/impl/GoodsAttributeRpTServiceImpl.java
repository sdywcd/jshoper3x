package com.jshop.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsAttributeRpTDao;
import com.jshop.entity.GoodsAttributeRpT;
import com.jshop.service.GoodsAttributeRpTService;

@Service("goodsAttributeRpTService")
@Scope("prototype")
public class GoodsAttributeRpTServiceImpl implements GoodsAttributeRpTService {
	@Resource
	private GoodsAttributeRpTDao goodsAttributeRpTDao;

	public GoodsAttributeRpTDao getGoodsAttributeRpTDao() {
		return goodsAttributeRpTDao;
	}

	public void setGoodsAttributeRpTDao(GoodsAttributeRpTDao goodsAttributeRpTDao) {
		this.goodsAttributeRpTDao = goodsAttributeRpTDao;
	}

	@Override
	public void saveGoodsAttributeRpT(GoodsAttributeRpT gart) {
		this.getGoodsAttributeRpTDao().saveGoodsAttributeRpT(gart);
	}

}
