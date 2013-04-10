package com.jshop.service;

import java.util.List;

import com.jshop.entity.GoodsAttributeT;

public interface GoodsAttributeTService {

	/**
	 * 增加商品参数
	 * @param gat
	 * @return
	 */
	public abstract int addGoodsAttributeT(GoodsAttributeT gat);
	/**
	 * 更新商品参数
	 * @param gat
	 * @return
	 */
	public abstract int updateGoodsAttributeT(GoodsAttributeT gat);
	
	/**
	 * 根据goodstypeid获取参数
	 * @param goodsattributeid
	 * @return
	 */
	public abstract GoodsAttributeT findGoodsAttributeTBygoodstypeId(String goodstypeid);
	/**
	 * 获取所有的商品参数
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsAttributeT>findAllGoodsAttributeT(final int currentPage,final int lineSize);
	/**
	 * 统计说去所有的商品参数
	 * @return
	 */
	public abstract int countfindAllGoodsAttributeT();
	/**
	 * 删除商品参数
	 * @param list
	 * @return
	 */
	public abstract int delGoodsAttributeT(String []list);
	/**
	 * 根据商品类型名称获取商品参数
	 * @param goodsTypeName
	 * @return
	 */
	public abstract List<GoodsAttributeT> findGoodsAttributeTByGoodsTypeName(String goodsTypeName);
	/**
	 * 根据商品类型名称获取商品属性参数
	 * @param goodsTypeName
	 * @return
	 */
	public abstract List<GoodsAttributeT> findGoodsAttributeTBygoodsTypeId(String goodsTypeId);
	/**
	 * 根据排序方式进行排序
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<GoodsAttributeT>sortAllGoodsAttributeT(final int currentPage,final int lineSize,String queryString);
	/**
	 * 更新商品参数表中的商品类型名称
	 * @param goodsTypeName
	 * @param goodsTypeId
	 * @return
	 */
	public abstract int updateGoodsAttributeTgoodsTypeName(String goodsTypeName,String goodsTypeId);
	/**
	 * 根据id更新是否支持检索
	 * @param goodsattributeid
	 * @param issearch
	 * @return
	 */
	public abstract int updateGoodsAttributeissearchBygoodsattributeid(String[] goodsattributeid,String issearch);
	/**
	 * 根据id更新是否支持关联检索
	 * @param goodsattributeid
	 * @param issametolink
	 * @return
	 */
	public abstract int updateGoodsAttributeissametolinkBygoodsattributeid(String[] goodsattributeid,String issametolink);
	
	
	
}
