package com.jshop.service;

import java.util.List;

import com.jshop.entity.GoodsBelinkedT;

public interface GoodsBelinkedTService {

	/**
	 * 增加关联商品
	 * @param gbel
	 * @return
	 */
	public abstract int addGoodsBelinkedT(GoodsBelinkedT gbel);
	
	/**
	 * 更新关联商品（只在单向关联时使用）
	 * @param gbel
	 * @return
	 */
	public abstract int updateGoodsBelinked(GoodsBelinkedT gbel);
	/**
	 * 根据主关联id获取关联商品
	 * @param maingoodsid
	 * @return
	 */
	public abstract List<GoodsBelinkedT>findGoodsBelinkedBymaingoodsid(String maingoodsid);
	/**
	 * 根据主商品id单向删除关联商品
	 * @param maingoodsid
	 * @return
	 */
	public abstract int delGoodsBelinkedBymaingoodsid(String maingoodsid);
	/**
	 * 双向删除关联 商品
	 * @param maingoodsid
	 * @param sxlinkedgoodsid
	 * @return
	 */
	public abstract int delGoodsBelinkedBymaingoodsidandsxlinkedgoodsid(String maingoodsid,String sxlinkedgoodsid);
	


}
