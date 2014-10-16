package com.jshop.service;

import java.util.List;

import com.jshop.entity.GoodsCardsPasswordT;

public interface GoodsCardsPasswordTService extends BaseTService<GoodsCardsPasswordT>{
	/**
	 * 根据卡获取密钥
	 * @param currentPage
	 * @param lineSize
	 * @param goodsCardsId
	 * @return
	 */
	public List<GoodsCardsPasswordT>findGoodsCardsPasswordByGoodsCardsId(int currentPage,int lineSize,String goodsCardsId);
	/**
	 * 统计根据卡获取密钥
	 * @param goodsCardsId
	 * @return
	 */
	public int countfindGoodsCardsPasswordByGoodsCardsId(String goodsCardsId);
	
}
