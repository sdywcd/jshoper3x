package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsSpecificationsRelationshipT;

public interface GoodsSpecificationsRelationshipTDao {

	
	/**
	 * 检测商品和商品规格关系
	 * @return
	 */
	public List<GoodsSpecificationsRelationshipT>checkSpecificationRelationshipByspecificationsid(String specificationsid );
	
	
	/**
	 * 通过goodssetid 查找规格
	 * @return
	 */
	public List<GoodsSpecificationsRelationshipT>checkSpecificationRelationshipBygoodssetid(String goodssetid);

	/**
	 * 增加商品规格
	 * @param goodsSetId
	 * @param specidicationsId
	 * @return
	 */
	public int addGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt);
	
	/**
	 * 更新商品规格
	 * @param goodsSetId
	 * @param specidicationsId
	 * @return
	 */
	public int updateGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt);
	
	/**
	 * 删除商品规格
	 * @param goodsSetId
	 * @return
	 */
	public int delGoodsAssociatedProductById(final String goodssetid);
	
	
	
	
}
