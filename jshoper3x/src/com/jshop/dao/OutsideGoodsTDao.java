package com.jshop.dao;

import java.util.List;

import com.jshop.entity.OutsideGoodsT;

public interface OutsideGoodsTDao {
	/**
	 * 查询所有数量
	 * @param lineSize
	 * @param currentPage
	 * @return
	 */
	public List<OutsideGoodsT> findAllOutsideGoodsT(int lineSize,int currentPage);
	/**
	 * 统计所有数量
	 * @return
	 */
	public int countAllOutsideGoodsT();
	/**
	 * 添加外链商品
	 * @param ogt
	 * @return
	 */
	public int addOutsideGoodsT(OutsideGoodsT ogt);
	/**
	 * 更新外链商品
	 * @param ogt
	 * @return
	 */
	public int updateOutsideGoodsT(OutsideGoodsT ogt);
	/**
	 * 根据id 查询信息
	 * @param id
	 * @return
	 */
	public OutsideGoodsT findOutsideGoodsTById(String id);
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	public int delOutsideGoodsT(String[] id);
	

}
