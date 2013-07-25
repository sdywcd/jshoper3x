package com.jshop.dao;

import java.util.List;

import com.jshop.entity.ProductT;

public interface ProductTDao {

	/**
	 * 增加产品
	 * 
	 * @param pt
	 * @return
	 */
	public int saveProductT(ProductT pt);

	/**
	 * 查询所有产品
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @return
	 */
	public List<ProductT> findAllProductT(final int currentPage,
			final int lineSize, final String creatorid);

	/**
	 * 查询所有货物
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<ProductT>findAllProductT(final int currentPage,final int lineSize);
	
	/**
	 * 统计查询所有产品
	 * 
	 * @param creatorid
	 * @return
	 */
	public int countfindAllProductT(String creatorid);
	/**
	 * 统计查询所有货物
	 * @return
	 */
	public int countfineAllProductT();
	
	/**
	 * 根据商品id获取货品数据
	 * 
	 * @param creatorid
	 * @param goodsid
	 * @return
	 */
	public List<ProductT> findAllProductTByGoodsid(String creatorid,
			String goodsid);

	/**
	 * 根据goodsid更新产品
	 * 
	 * @param pt
	 * @return
	 */
	public int updateProductT(ProductT pt);

	/**
	 * 根据productid查询产品
	 * 
	 * @param creatorid
	 * @param productid
	 * @return
	 */
	public List<ProductT> findProductTByproductid(String creatorid,
			String productid);

	/**
	 * 根据 goodsid删除货品
	 * 
	 * @param goodsid
	 * @param creatorid
	 * @return
	 */
	public int delProductTBygoodsid(String goodsid, String creatorid);

	/**
	 * 根据排序方式进行排序
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @param queryString
	 * @return
	 */
	public List<ProductT> sortAllProductT(final int currentPage,
			final int lineSize, final String creatorid, String queryString);

	/**
	 * 根据产品id删除产品
	 * 
	 * @param productid
	 * @return
	 */
	public int delProductTByproductid(String productid);

	/**
	 * 根据商品id获取货品列表
	 * 
	 * @param goodsid
	 * @return
	 */
	public List<ProductT> findProductTByGoodsid(String goodsid);

}
