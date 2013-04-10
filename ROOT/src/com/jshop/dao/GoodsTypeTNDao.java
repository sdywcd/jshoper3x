package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsTypeTN;

public interface GoodsTypeTNDao {

	/**
	 * 增加商品类型
	 * @param gtn
	 * @return
	 */
	public abstract int addGoodsTypeTN(GoodsTypeTN gtn);
	/**
	 * 批量删除商品类型
	 * @param list
	 * @return
	 */
	public abstract int delGoodsTypeTN(String [] list);
	/**
	 * 更新商品类型
	 * @param gtn
	 * @return
	 */
	public abstract int updateGoodsTypeTN(GoodsTypeTN gtn);
	/**
	 * 查询所有商品类型
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsTypeTN>findAllGoodsTypeTN(final int currentPage,final int lineSize);
	/**
	 * 统计查询所有商品类型
	 * @return
	 */
	public abstract int countfindAllGoodsTypeTN();
	/**
	 * 根据id获取商品类型
	 * @param goodstypetnid
	 * @return
	 */
	public List<GoodsTypeTN> findGoodsTypeTNById(String goodsTypeId);
	/**
	 * 不分页查询所有商品类型
	 * @return
	 */
	public abstract List<GoodsTypeTN>findAllGoodsTypeTNNopage();
	/**
	 * 根据不同排序方式进行排序
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsTypeTN>sortAllGoodsTypeTN(final int currentPage,final int lineSize,String queryString);

}
