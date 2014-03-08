package com.jshop.service;

import java.util.List;

import com.jshop.entity.BrandT;
import com.jshop.entity.GoodsTypeBrandT;
import com.taobao.api.domain.Brand;

public interface BrandTService extends BaseTService<BrandT>{


	/**
	 * 删除商品品牌
	 * 
	 * @param brandid
	 * @return
	 */
	public void delBrandt(String[] list, String creatorid);

	/**
	 * 更新商品品牌
	 * 
	 * @param bt
	 * @return
	 */
	public void updateBrandt(BrandT bt);

	/**
	 * 查询所有商品品牌
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<BrandT> findAllBrandt(final int currentPage,
			final int lineSize, final String creatorid);

	/**
	 * 统计所有商品品牌
	 * 
	 * @return
	 */
	public int countfindAllBrandt(String creatorid);

	/**
	 * 根据id获取商品品牌
	 * 
	 * @param brandid
	 * @return
	 */
	public BrandT findBrandById(String brandid);

	/**
	 * 查询所有商品品牌json方式
	 * 
	 * @return
	 */
	public List<BrandT> findAllBrandt();

	/**
	 * 根据排序字段按照排序方式排序
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @param queryString
	 * @return
	 */
	public List<BrandT> sortAllBrandt(final int currentPage,
			final int lineSize, final String creatorid, final String queryString);
	/**
	 * 保存品牌及商品品牌和商品类型的关系
	 * @param brand
	 * @param goodsTypeBrandT
	 */
	public void saveBrandTransaction(BrandT brandT,GoodsTypeBrandT goodsTypeBrandT);
	
}
