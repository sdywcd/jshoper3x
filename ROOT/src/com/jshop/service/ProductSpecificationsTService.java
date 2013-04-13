package com.jshop.service;

import java.util.List;

import com.jshop.entity.ProductSpecificationsT;

public interface ProductSpecificationsTService {

	
	/**
	 *增加商品规格
	 * @param pst
	 */
	public abstract void addProductSpecification(ProductSpecificationsT pst);

	/**
	 * 更新商品规格
	 * @param pst
	 */
	public abstract int updateProductSpecification(ProductSpecificationsT pst);

	/**
	 * 更具规格id获取规格值
	 * @param specificationsid
	 * @return
	 */
	public abstract ProductSpecificationsT findProductSpecificationsTByspecificationsid(String specificationsid);
	/**
	 * 查询所有商品规格
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<ProductSpecificationsT>findAllProductSpecificationsT(final int currentPage,final int lineSize);
	/**
	 * 统计查询所有商品规格
	 * @return
	 */
	public abstract int countfindAllProductSpecificationsT();
	/**
	 * 删除商品规格
	 * @param list
	 * @return
	 */
	public abstract int delProductSpecification(String []list);

	/**
	 * 不分页查询所有商品规格
	 * @return
	 */
	public abstract List<ProductSpecificationsT>findAllProductSpecificationsTWithoutPage();
	
	/**
	 * 根据排序方式进行排序
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<ProductSpecificationsT>sortAllProductSpecificationsT(final int currentPage,final int lineSize,String queryString);
	
	
	
	
	
	
}
