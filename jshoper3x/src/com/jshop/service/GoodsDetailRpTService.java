package com.jshop.service;

import com.jshop.entity.GoodsDetailRpT;

public interface GoodsDetailRpTService {
	/**
	 * 增加商品详细介绍
	 */
	public void saveGoodsDetailRpT(GoodsDetailRpT gdrt);
	/**
	 * 根据商品id获取商品详细介绍
	 * @param goodsid
	 * @return
	 */
	public GoodsDetailRpT findGoodsDetailRpBygoodsid(String goodsid);
	/**
	 * 更新商品详细介绍
	 * @param gdrt
	 */
	public void update(GoodsDetailRpT gdrt);
	
}
