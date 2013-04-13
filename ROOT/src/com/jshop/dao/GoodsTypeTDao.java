package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsTypeT;

public interface GoodsTypeTDao {

	/**
	 * 增加商品大类（导航和非导航之分）
	 * @param transientInstance
	 * @return
	 */
	public abstract int addlcategorydisornav(GoodsTypeT transientInstance); 
	
	/**
	 * 更新商品大类（导航和非导航之分）
	 * @param transientInstance
	 * @return
	 */
	public abstract int updatelcategorydisornav(GoodsTypeT transientInstance);
	
	/**
	 * 查询所有商品大类
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsTypeT>findAlllcategory(final int currentPage,final int lineSize);
	/**
	 * 查询所有商品分类不分页（三级数据）
	 * @return
	 */
	public abstract List<GoodsTypeT>findAllcategoryWithoutSplitpage();
	/**
	 * 统计商品大类
	 * @return
	 */
	public abstract int countfindAlllcategory();
	
	/**
	 * 根据id获取商品大类信息
	 * @param id
	 * @return
	 */
	public abstract GoodsTypeT findById(String id);
	
	/**
	 * 查询所有商品大类非分页
	 * @param transientInstance
	 * @return
	 */
	public abstract List<GoodsTypeT>findAlllcategoryBynav(String nav);
	
	/**
	 * 删除所有分类
	 * @param list
	 * @return
	 */
	public abstract int Dellcategory( String []list);
	
	/**
	 * 获取大类和小类商品分类
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GoodsTypeT>findAllcategory(final int currentPage,final int lineSize);
	

	/**
	 * 更新大类中的导航名称
	 * @return
	 */
	public abstract int updatenavidforlname(GoodsTypeT t);
	
	/**
	 * 获取商品二级导航数据
	 * @param ltypeid
	 * @return
	 */
	public abstract List<GoodsTypeT> findSecondcategory(String ltypeid);

	/**
	 * 根据导航ID更新商品二级和三级菜单
	 * @param t
	 * @return
	 */
	public abstract int updateSecondandThriedwithnav(GoodsTypeT t);
	
	/**
	 * 删除导航及其对应的所有二三级分类
	 * @param navid
	 * @return
	 */
	public abstract int DelNavigation(String navid);

	/**
	 * 更新商品二级分类及其三级菜单
	 * @param t
	 * @return
	 */
	public abstract int updateSecondcategory(GoodsTypeT t);

	/**
	 * 删除二级分类名称及其所有的三级分类
	 * @param ltypeid
	 * @return
	 */
	public abstract int DelSecondcategory(String ltypeid);
	/**
	 * 获取商品三级导航数据
	 * @param stypeid
	 * @return
	 */
	public abstract List<GoodsTypeT> findThriedcategory(String stypeid);
	
	/**
	 * 更新商品三级菜单
	 * @param t
	 * @return
	 */
	public abstract int updateThriedcategory(GoodsTypeT t);
	
	/**
	 * 删除商品三级分类
	 * @param stypeid
	 * @return
	 */
	public abstract int DelThriedcategory(String stypeid);
	/**
	 * 获取商品二级数据json
	 * @param navid
	 * @return
	 */
	public abstract List<GoodsTypeT>findSecondcategoryjson(String navid);
	/**
	 * 获取商品三级数据json
	 * @param ltypeid
	 * @return
	 */
	public abstract List<GoodsTypeT>findThriedcategoryjson(String ltypeid);

	/**
	 * 获取商品左侧三级导航数据
	 * @param ltypeid
	 * @param stypeid
	 * @return
	 */
	public abstract List<GoodsTypeT>findThriedcategoryForindexleftmenu(String ltypeid);
	

}
