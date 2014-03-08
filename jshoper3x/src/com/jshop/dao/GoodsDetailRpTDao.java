package com.jshop.dao;

import com.jshop.entity.GoodsDetailRpT;

public interface GoodsDetailRpTDao extends BaseTDao<GoodsDetailRpT>{

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
