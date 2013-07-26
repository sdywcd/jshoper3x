package com.jshop.service;

import java.util.List;

import com.jshop.entity.BrandT;

public interface BrandTService {

	/**
	 * 增加商品品牌
	 * @param bt
	 * @return
	 */
	public  int addBrandt(BrandT bt);
	/**
	 * 删除商品品牌
	 * @param brandid
	 * @return
	 */
	public  int delBrandt(String[] list,String creatorid);
	/**
	 * 更新商品品牌
	 * @param bt
	 * @return
	 */
	public  void updateBrandt(BrandT bt);
	/**
	 * 查询所有商品品牌
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public  List<BrandT>findAllBrandt(final int currentPage,final int lineSize,final String creatorid);
	/**
	 * 统计所有商品品牌
	 * @return
	 */
	public  int countfindAllBrandt(String creatorid);
	
	/**
	 * 根据id获取商品品牌
	 * @param brandid
	 * @return
	 */
	public  BrandT findBrandById(String brandid);
	/**
	 * 查询所有商品品牌json方式
	 * @return
	 */
	public  List<BrandT>findAllBrandt();
	/**
	 * 根据排序字段按照排序方式排序
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @param queryString
	 * @return
	 */
	public  List<BrandT>sortAllBrandt(final int currentPage,final int lineSize,final String creatorid,final String queryString);

	
}
