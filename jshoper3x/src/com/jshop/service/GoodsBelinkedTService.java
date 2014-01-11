package com.jshop.service;

import java.util.List;

import com.jshop.entity.GoodsBelinkedT;

public interface GoodsBelinkedTService extends BaseTService<GoodsBelinkedT>{

	/**
	 * 更新关联商品（只在单向关联时使用）
	 * 
	 * @param gbel
	 * @return
	 */
	public int updateGoodsBelinked(GoodsBelinkedT gbel);

	/**
	 * 根据主关联id获取关联商品
	 * 
	 * @param maingoodsid
	 * @return
	 */
	public List<GoodsBelinkedT> findGoodsBelinkedBymaingoodsid(
			String maingoodsid);
	/**
	 * 查询所有关联商品
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<GoodsBelinkedT>findAllGoodsBelinked(int currentPage,int lineSize);
	/**
	 * 统计所有关联商品
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public int countfindAllGoodsBelinked();
	/**
	 * 根据主商品id单向删除关联商品
	 * 
	 * @param maingoodsid
	 * @return
	 */
	public int delGoodsBelinkedBymaingoodsid(String maingoodsid);

	/**
	 * 双向删除关联 商品
	 * 
	 * @param maingoodsid
	 * @param sxlinkedgoodsid
	 * @return
	 */
	public int delGoodsBelinkedBymaingoodsidandsxlinkedgoodsid(
			String maingoodsid, String sxlinkedgoodsid);
	/**
	 * 根据主键删除关联商品记录
	 * @param strs
	 */
	public void delGoodsBelinked(String []strs);
	

}
