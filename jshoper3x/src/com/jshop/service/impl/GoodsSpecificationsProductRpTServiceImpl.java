package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsSpecificationsProductRpTDao;
import com.jshop.entity.GoodsSpecificationsProductRpT;
import com.jshop.service.GoodsSpecificationsProductRpTService;

@Service("goodsSpecificationsProductRpTService")
@Scope("prototype")
public class GoodsSpecificationsProductRpTServiceImpl extends
		BaseTServiceImpl<GoodsSpecificationsProductRpT> implements
		GoodsSpecificationsProductRpTService {
	@Resource
	private GoodsSpecificationsProductRpTDao goodsSpecificationsProductRpTDao;

	public GoodsSpecificationsProductRpTDao getGoodsSpecificationsProductRpTDao() {
		return goodsSpecificationsProductRpTDao;
	}

	public void setGoodsSpecificationsProductRpTDao(
			GoodsSpecificationsProductRpTDao goodsSpecificationsProductRpTDao) {
		this.goodsSpecificationsProductRpTDao = goodsSpecificationsProductRpTDao;
	}

	@Override
	public List<GoodsSpecificationsProductRpT> checkSpecificationRelationshipByspecificationsid(
			String specificationsid) {
		return this.getGoodsSpecificationsProductRpTDao()
				.checkSpecificationRelationshipByspecificationsid(
						specificationsid);
	}

	@Override
	public List<GoodsSpecificationsProductRpT> checkSpecificationRelationshipBygoodssetid(
			String goodsid) {
		return this.getGoodsSpecificationsProductRpTDao()
				.checkSpecificationRelationshipBygoodssetid(goodsid);
	}

	@Override
	public void updateGoodsAssociatedProductById(
			GoodsSpecificationsProductRpT gsrt) {
		this.getGoodsSpecificationsProductRpTDao()
				.updateGoodsAssociatedProductById(gsrt);

	}

	@Override
	public int delGoodsAssociatedProductById(String goodsid) {
		return this.getGoodsSpecificationsProductRpTDao()
				.delGoodsAssociatedProductById(goodsid);
	}

	@Override
	public List<GoodsSpecificationsProductRpT> checkSpecificationRelationshipByproductid(
			String productid) {
		return this.getGoodsSpecificationsProductRpTDao()
				.checkSpecificationRelationshipByproductid(productid);
	}

}
