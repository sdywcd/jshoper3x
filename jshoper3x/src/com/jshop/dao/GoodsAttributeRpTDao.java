package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsAttributeRpT;

public interface GoodsAttributeRpTDao {

	/**
	 * 增加商品的属性
	 * @param gart
	 */
	public void saveGoodsAttributeRpT(GoodsAttributeRpT gart);
	/**
	 * 根据goodsid获取商品的属性
	 * @param goodsid
	 * @return
	 */
	public List<GoodsAttributeRpT>findGoodsAttributeRpTBygoodsid(String goodsid);
	
	
}
