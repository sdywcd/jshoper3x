package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsunitT;

public interface GoodsunitTDao {
	
	/**
	 * 增加商品单位
	 * @return
	 */
	public abstract int addGoodsunit(GoodsunitT u);
	/**
	 * 删除商品单位
	 * @param list
	 * @return
	 */
	public abstract int delGoodsunit(String [] list);
	/**
	 * 更新商品单位
	 * @param u
	 * @return
	 */
	public abstract int updateGoodsunit(GoodsunitT u);
	/**
	 * 查询所有商品单位
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsunitT>findAllGoodsunit(final int currentPage,final int lineSize);
	/**
	 * 统计所有商品单位
	 * @return
	 */
	public abstract int countfindAllGoodsunit();
	/**
	 * 根据id获取商品单位
	 * @param unitid
	 * @return
	 */
	public abstract GoodsunitT findGoodsunitById(String unitid);
	/**
	 * 查询所有商品单位json方式
	 * @return
	 */
	public abstract List<GoodsunitT>findAllGoodsunitjson();
	/**
	 * 根据排序方式进行排序
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<GoodsunitT>sortAllGoodsunit(final int currentPage,final int lineSize,String queryString);
}
