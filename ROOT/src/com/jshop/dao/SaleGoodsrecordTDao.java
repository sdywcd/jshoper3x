package com.jshop.dao;

import java.util.Date;
import java.util.List;

import com.jshop.entity.SaleGoodsrecordT;
import com.jshop.entity.SalegoodsT;


public interface SaleGoodsrecordTDao {
	/**
	 * 添加拍买记录
	 * */
	public int addSaleGoodsrecord(final SaleGoodsrecordT salegoodsrecordt);
	/***
	 * 修改拍买记录
	 * 
	 * */
	public int updateSaleGoodsrecord(final SaleGoodsrecordT salegoodsrecordt);
	
	/**
	 * 删除拍买记录(集合)
	 * 
	 * */
	public int deleteSaleGoodsrecord(final String[] list);
	
	/**
	 * 根据编号查询拍买数据
	 * */
	public SaleGoodsrecordT findSaleGoodsrecordByid(String salerecordid);
	
	
	/**
	 * 查询所有拍买记录（分页）
	 * */
	public List<SaleGoodsrecordT> findallSaleGoodsrecord(final int currentPage,final int lineSize);
	/**
	 * 查询所有拍买商品的条目
	 * */

	public int countAllSaleGoodsrecordT();
	/**
	 * 根据字段，按照排序方式排序
	 * */
	public List<SaleGoodsrecordT> sortAllSaleGoodsrecord(final int currentPage,final int lineSize,final String queryString);

	/**
	 * 更新最高价
	 * */
	public int updateSaleGoodsrecordByHiprice(SaleGoodsrecordT salegoodsrecordt);
	
	/**
	 * 根据添加拍卖里面状态来添加到记录
	 * */
	public int addSaleGoodsrecordBystate(final SaleGoodsrecordT salegoodsrecordt);
	

	
	/**
	 * 根据Selegoodsid来跟新信息
	 * */
	/*public int updateSaleGoodsrecordBySalegoodsid(final String salegoodsid);
	*/
	public int updateSaleGoodsrecordHtmlPath(String htmlpath,String salerecordid);
	
	
	public SaleGoodsrecordT findrecordbysalegoodsid(String salegoodsid);
	
	/**
	 * 添加用户拍卖记录
	 * */
	public int addrecordByhiprice(SaleGoodsrecordT salegoodsrecordt);
	
	
	/**
	 *查询当前最高价 
	 * */
	public double hiprice(String salegoodsid);
	
	public List<SaleGoodsrecordT> findAllSaleGoodsrecordT();
	
	/**
	 * 
	 * 查询有多少用户参加拍卖
	 * */
	public int findjoinnumber(String salegoodsid);
	
	/**
	 * 根据结束时间查询最终成交用户
	 * 
	 * */
	public List<SaleGoodsrecordT> findbyEndingtime(Date endingtime);
	
	
}
