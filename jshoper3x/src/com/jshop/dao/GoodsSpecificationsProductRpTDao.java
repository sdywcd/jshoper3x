package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsSpecificationsProductRpT;

public interface GoodsSpecificationsProductRpTDao extends BaseTDao<GoodsSpecificationsProductRpT> {

	
	/**
	 * 检测商品和商品规格关系
	 * @return
	 */
	public List<GoodsSpecificationsProductRpT>checkSpecificationRelationshipByspecificationsid(String specificationsid );
	
	
	/**
	 * 通过goodssetid 查找规格
	 * @return
	 */
	public List<GoodsSpecificationsProductRpT>checkSpecificationRelationshipBygoodssetid(String goodsid);
	/**
	 * 通过productid 查找规格
	 * @return
	 */
	public List<GoodsSpecificationsProductRpT>checkSpecificationRelationshipByproductid(String productid);

	
	/**
	 * 更新商品规格
	 * @param goodsSetId
	 * @param specidicationsId
	 * @return
	 */
	public void updateGoodsAssociatedProductById(GoodsSpecificationsProductRpT gsrt);
	
	/**
	 * 删除商品规格
	 * @param goodsSetId
	 * @return
	 */
	public int delGoodsAssociatedProductById(final String goodsid);
	
	
	
	
}
