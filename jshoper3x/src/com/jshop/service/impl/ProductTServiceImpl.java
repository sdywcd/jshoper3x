package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.ProductTDao;
import com.jshop.entity.GoodsSpecificationsProductRpT;
import com.jshop.entity.ProductT;
import com.jshop.service.GoodsSpecificationsProductRpTService;
import com.jshop.service.ProductTService;

@Service("productTService")
@Scope("prototype")
public class ProductTServiceImpl implements ProductTService {
	@Resource
	private ProductTDao productTDao;
	@Resource
	private GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService;
	
	public GoodsSpecificationsProductRpTService getGoodsSpecificationsProductRpTService() {
		return goodsSpecificationsProductRpTService;
	}

	public void setGoodsSpecificationsProductRpTService(
			GoodsSpecificationsProductRpTService goodsSpecificationsProductRpTService) {
		this.goodsSpecificationsProductRpTService = goodsSpecificationsProductRpTService;
	}

	public ProductTDao getProductTDao() {
		return productTDao;
	}

	public void setProductTDao(ProductTDao productTDao) {
		this.productTDao = productTDao;
	}

	public int saveProductT(ProductT pt) {
		return this.getProductTDao().saveProductT(pt);
	}

	public int countfindAllProductT(String creatorid) {
		return this.getProductTDao().countfindAllProductT(creatorid);
	}

	public List<ProductT> findAllProductT(int currentPage, int lineSize, String creatorid) {
		return this.getProductTDao().findAllProductT(currentPage, lineSize, creatorid);
	}

	public List<ProductT> findAllProductTByGoodsid(String creatorid, String goodsid) {
		return this.getProductTDao().findAllProductTByGoodsid(creatorid, goodsid);
	}

	public void updateProductT(ProductT pt) {
		this.getProductTDao().updateProductT(pt);
	}

	public List<ProductT> findProductTByproductid(String creatorid, String productid) {
		return this.getProductTDao().findProductTByproductid(creatorid, productid);
	}

	public int delProductTBygoodsid(String goodsid, String creatorid) {
		return this.getProductTDao().delProductTBygoodsid(goodsid, creatorid);
	}

	public List<ProductT> sortAllProductT(int currentPage, int lineSize,  String queryString) {

		return this.getProductTDao().sortAllProductT(currentPage, lineSize,  queryString);
	}

	@Override
	public int delProductTByproductid(String productid) {
		return this.getProductTDao().delProductTByproductid(productid);
	}

	@Override
	public List<ProductT> findProductTByGoodsid(String goodsid) {
		return this.getProductTDao().findProductTByGoodsid(goodsid);
	}

	@Override
	public List<ProductT> findAllProductT(int currentPage, int lineSize) {
		return this.getProductTDao().findAllProductT(currentPage, lineSize);
	}

	@Override
	public int countfineAllProductT() {
		return this.getProductTDao().countfineAllProductT();
	}

	@Override
	public ProductT findProductByProductid(String productid) {
		return this.getProductTDao().findProductByProductid(productid);
	}

	@Override
	public int delProductT(String[] strs) {
		return this.getProductTDao().delProductT(strs);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveProductProcess(ProductT pt,
			GoodsSpecificationsProductRpT gsrt) {
		this.getProductTDao().saveProductT(pt);
		this.getGoodsSpecificationsProductRpTService().addGoodsAssociatedProductById(gsrt);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateProductProcess(ProductT pt,
			GoodsSpecificationsProductRpT gsrt) {
		this.getProductTDao().updateProductT(pt);
		this.getGoodsSpecificationsProductRpTService().updateGoodsAssociatedProductById(gsrt);
		
	}

	@Override
	public List<ProductT> findProductByproductName(String productName,
			int lineSize) {
		return this.getProductTDao().findProductByproductName(productName, lineSize);
	}

}
