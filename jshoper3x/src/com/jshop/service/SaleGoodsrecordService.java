package com.jshop.service;

import java.util.Date;
import java.util.List;

import com.jshop.entity.SaleGoodsrecordT;

public interface SaleGoodsrecordService {

	public abstract int addSaleGoodsrecord(SaleGoodsrecordT salegoodsrecordt);

	public abstract int updateSaleGoodsrecord(SaleGoodsrecordT salegoodsrecordt);

	public abstract int deleteSaleGoodsrecord(final String[] list);

	public abstract List<SaleGoodsrecordT> findallSaleGoodsrecord(
			final int currentPage, final int lineSize);

	public abstract List<SaleGoodsrecordT> sortAllSaleGoodsrecord(
			final int currentPage, final int lineSize, final String queryString);

	public abstract int countAllSaleGoodsrecordT();

	public abstract SaleGoodsrecordT findrecordbysalegoodsid(String salegoodsid);
	
	public abstract int updateSaleGoodsrecordByHiprice(SaleGoodsrecordT salegoodsrecordt);
	
	
	
	
	public abstract int updateSaleGoodsrecordHtmlPath(String htmlpath,String salerecordid);
	
	
	public abstract SaleGoodsrecordT findsalerecordid(String salerecordid);
	
	
	public abstract int addrecordByhiprice(SaleGoodsrecordT salegoodsrecordt);
	
	public abstract double hiprice(String salegoodsid);
	
	
	public abstract List<SaleGoodsrecordT> findAllSaleGoodsrecordT();
	
	
	public abstract int findjoinnumber(String salegoodsid);
	
	
	
	public abstract List<SaleGoodsrecordT> findbyEndingtime(Date endingtime);
	


}