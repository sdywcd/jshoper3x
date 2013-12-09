package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsAttributeRpT;

public interface GoodsAttributeRpTDao {

	/**
	 * 增加商品的属性
	 * @param gart
	 */
	public void saveGoodsAttributeRpT(GoodsAttributeRpT gart);
	/**
	 * 根据goodsid获取商品的属性
	 * @param goodsid
	 * @return
	 */
	public List<GoodsAttributeRpT>findGoodsAttributeRpTBygoodsid(String goodsid);
	/**
	 * 根据goodsid删除商品的属性关联
	 * @param goodsid
	 */
	public void delByProperty(String property,Object entity);
	/**
	 * 根据goodsid删除数据
	 * @param goodsid
	 */
	public int delBygoodsid(String goodsid);
}
