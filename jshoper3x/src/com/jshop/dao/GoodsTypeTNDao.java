package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsTypeTN;

public interface GoodsTypeTNDao extends BaseTDao<GoodsTypeTN>{


	/**
	 * 批量删除商品类型
	 * 
	 * @param list
	 * @return
	 */
	public int delGoodsTypeTN(String[] list);

	/**
	 * 更新商品类型
	 * 
	 * @param gtn
	 * @return
	 */
	public int updateGoodsTypeTN(GoodsTypeTN gtn);

	/**
	 * 查询所有商品类型
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<GoodsTypeTN> findAllGoodsTypeTN(final int currentPage,
			final int lineSize);

	/**
	 * 统计查询所有商品类型
	 * 
	 * @return
	 */
	public int countfindAllGoodsTypeTN();

	/**
	 * 根据id获取商品类型
	 * 
	 * @param goodstypetnid
	 * @return
	 */
	public List<GoodsTypeTN> findGoodsTypeTNById(String goodsTypeId);

	/**
	 * 不分页查询所有商品类型
	 * 
	 * @return
	 */
	public List<GoodsTypeTN> findAllGoodsTypeTNNopage();

	/**
	 * 根据不同排序方式进行排序
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<GoodsTypeTN> sortAllGoodsTypeTN(final int currentPage,
			final int lineSize, String queryString);

	/**
	 * 根据参数统计搜索结果计数
	 * 
	 * @param queryString
	 * @return
	 */
	public int countsortAllGoodsTypeTN(String queryString);

	/**
	 * 根据商品类型名称获取记录
	 * 
	 * @param name
	 * @return
	 */
	public List<GoodsTypeTN> findGoodsTypeTNByName(String name);

}
