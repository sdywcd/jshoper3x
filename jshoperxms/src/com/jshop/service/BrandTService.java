package com.jshop.service;

import com.jshop.entity.BrandT;
import com.jshop.entity.GoodsTypeBrandT;

public interface BrandTService extends BaseTService<BrandT>{


	/**
	 * 保存品牌及商品品牌和商品类型的关系
	 * @param brand
	 * @param goodsTypeBrandT
	 */
	public void saveBrandTransaction(BrandT brandT,GoodsTypeBrandT goodsTypeBrandT);
	
}
