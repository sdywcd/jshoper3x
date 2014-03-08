package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.BrandTDao;
import com.jshop.entity.BrandT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.service.BrandTService;
import com.jshop.service.GoodsTypeBrandTService;

@Service("brandTService")
@Scope("prototype")
public class BrandTServiceImpl extends BaseTServiceImpl<BrandT>implements BrandTService {
	@Resource
	private BrandTDao brandTDao;
	
	private GoodsTypeBrandTService goodsTypeBrandTService;
	
	public GoodsTypeBrandTService getGoodsTypeBrandTService() {
		return goodsTypeBrandTService;
	}

	public void setGoodsTypeBrandTService(
			GoodsTypeBrandTService goodsTypeBrandTService) {
		this.goodsTypeBrandTService = goodsTypeBrandTService;
	}

	public BrandTDao getBrandTDao() {
		return brandTDao;
	}

	public void setBrandTDao(BrandTDao brandTDao) {
		this.brandTDao = brandTDao;
	}

	public void delBrandt(String[] strs, String creatorid) {
		this.getBrandTDao().delBrandt(strs, creatorid);
	}

	public void updateBrandt(BrandT bt) {
		this.getBrandTDao().updateBrandt(bt);
	}



	public int countfindAllBrandt(String creatorid) {
		return this.getBrandTDao().countfindAllBrandt(creatorid);
	}

	public List<BrandT> findAllBrandt(int currentPage, int lineSize,
			String creatorid) {
		return this.getBrandTDao().findAllBrandt(currentPage, lineSize,
				creatorid);
	}

	public BrandT findBrandById(String brandid) {
		return this.getBrandTDao().findBrandById(brandid);
	}

	public List<BrandT> findAllBrandt() {
		return this.getBrandTDao().findAllBrandt();
	}

	public List<BrandT> sortAllBrandt(int currentPage, int lineSize,
			String creatorid, String queryString) {

		return this.getBrandTDao().sortAllBrandt(currentPage, lineSize,
				creatorid, queryString);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveBrandTransaction(BrandT brand,
			GoodsTypeBrandT goodsTypeBrandT) {
		this.getBrandTDao().save(brand);
		this.getGoodsTypeBrandTService().save(goodsTypeBrandT);
		
	}
}
