package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsSpecificationsRelationshipTDao;
import com.jshop.entity.GoodsSpecificationsRelationshipT;
import com.jshop.service.GoodsSpecificationsRelationshipTService;

@Service("goodsSpecificationsRelationshipTService")
@Scope("prototype")
public class GoodsSpecificationsRelationshipTServiceImpl implements GoodsSpecificationsRelationshipTService {
	@Resource
	private GoodsSpecificationsRelationshipTDao goodsSpecificationsRelationshipTDao;

	public GoodsSpecificationsRelationshipTDao getGoodsSpecificationsRelationshipTDao() {
		return goodsSpecificationsRelationshipTDao;
	}

	public void setGoodsSpecificationsRelationshipTDao(GoodsSpecificationsRelationshipTDao goodsSpecificationsRelationshipTDao) {
		this.goodsSpecificationsRelationshipTDao = goodsSpecificationsRelationshipTDao;
	}

	@Override
	public int addGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt) {

		return this.getGoodsSpecificationsRelationshipTDao().addGoodsAssociatedProductById(gsrt);
	}

	@Override
	public int updateGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt) {

		return this.getGoodsSpecificationsRelationshipTDao().updateGoodsAssociatedProductById(gsrt);

	}

	@Override
	public int delGoodsAssociatedProductById(final String goodssetid) {

		return this.getGoodsSpecificationsRelationshipTDao().delGoodsAssociatedProductById(goodssetid);
	}

	@Override
	public List<GoodsSpecificationsRelationshipT> checkSpecificationRelationshipBygoodssetid(String goodssetid) {

		return this.getGoodsSpecificationsRelationshipTDao().checkSpecificationRelationshipBygoodssetid(goodssetid);
	}

	@Override
	public List<GoodsSpecificationsRelationshipT> checkSpecificationRelationshipByspecificationsid(String specificationsid) {
		return this.getGoodsSpecificationsRelationshipTDao().checkSpecificationRelationshipByspecificationsid(specificationsid);
	}

}
