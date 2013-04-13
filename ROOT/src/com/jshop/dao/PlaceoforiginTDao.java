package com.jshop.dao;

import java.util.List;

import com.jshop.entity.PlaceoforiginT;

public interface PlaceoforiginTDao {

	/**
	 * 增加商品产地
	 * @param p
	 * @return
	 */
	public abstract int addPlaceoforigint(PlaceoforiginT p);
	
	/**
	 * 删除商品产地
	 * @param list
	 * @return
	 */
	public abstract int delPlaceoforigint(String[] list);
	
	/**
	 * 更新商品产地
	 * @param p
	 * @return
	 */
	public abstract int updatePlaceoforigint(PlaceoforiginT p);
	
	/**
	 * 查询所有商品产地
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<PlaceoforiginT>findAllPlaceoforigint(final int currentPage,final int lineSize);

	/**
	 * 统计所有商品产地
	 * @return
	 */
	public abstract int countfindAllPlaceoforigint();
	
	/**
	 * 根据id获取商品产地
	 * @param placeid
	 * @return
	 */
	public abstract PlaceoforiginT findPlaceoforigintById(String placeid);
	/**
	 * 查询所有商品产地json方式
	 * @return
	 */
	public abstract List<PlaceoforiginT>findAllPlaceoforigintjson();


}
