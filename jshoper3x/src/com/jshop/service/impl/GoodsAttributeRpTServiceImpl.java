package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsAttributeRpTDao;
import com.jshop.entity.GoodsAttributeRpT;
import com.jshop.service.GoodsAttributeRpTService;

@Service("goodsAttributeRpTService")
@Scope("prototype")
public class GoodsAttributeRpTServiceImpl extends BaseTServiceImpl<GoodsAttributeRpT> implements GoodsAttributeRpTService {
	@Resource
	private GoodsAttributeRpTDao goodsAttributeRpTDao;

	public GoodsAttributeRpTDao getGoodsAttributeRpTDao() {
		return goodsAttributeRpTDao;
	}

	public void setGoodsAttributeRpTDao(GoodsAttributeRpTDao goodsAttributeRpTDao) {
		this.goodsAttributeRpTDao = goodsAttributeRpTDao;
	}

	@Override
	public List<GoodsAttributeRpT> findGoodsAttributeRpTBygoodsid(String goodsid) {
		return this.getGoodsAttributeRpTDao().findGoodsAttributeRpTBygoodsid(goodsid);
	}

	@Override
	public void delByProperty(String property, Object entity) {
		this.getGoodsAttributeRpTDao().delByProperty(property, entity);
	}

	@Override
	public int delBygoodsid(String goodsid) {
		return this.getGoodsAttributeRpTDao().delBygoodsid(goodsid);
	}

	@Override
	public List<GoodsAttributeRpT> findGoodsIdsByAttr(String attrval) {
		return this.getGoodsAttributeRpTDao().findGoodsIdsByAttr(attrval);
	}

}
