package com.jshop.service;

import java.util.List;

import com.jshop.entity.SaleGoodsrecordT;
import com.jshop.entity.SalegoodsT;

public interface SaleGoodsTService {

	// 制定日志
	/**
	 * 
	 * 添加拍卖商品
	 * */
	public abstract int addsalegoods(SalegoodsT salegoodst);

	public abstract int updatesalegoods(final SalegoodsT salegoodst);

	public abstract List<SalegoodsT> findallsalegoods(final int currentPage,
			final int lineSize);

	public abstract SalegoodsT findsalegoodsById(String salegoodsid);

	public abstract List<SalegoodsT> findsalegoodsByNumber(
			String salegoodsnumber);

	public abstract int deletesalegoods(final String salegoodsnumber);

	public abstract int deletesalegoodsT(final String[] list);

	public abstract List<SalegoodsT> findsalegoodsByBegintime(
			java.util.Date begingtime);
	public abstract int countAllSalegoodsT();

	public abstract List<SalegoodsT> sortAllSalegoods(final int currentPage,
			final int lineSize, final String queryString);
	/**
	 * 根据状态查询
	 * */
	public List<SalegoodsT> findBysalegoodsState(final String salegoodsstate);
	
	public List<SalegoodsT> findAllSalegoods(String salegoodsstate);
	
	
	public int updateSalegoodsHtmlPath(final String htmlpath, final String salegoodsid);


}