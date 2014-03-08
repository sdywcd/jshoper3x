package com.jshop.dao;

import java.util.List;

import com.jshop.entity.FavoriteT;

public interface FavoriteTDao extends BaseTDao<FavoriteT>{

	/**
	 * 删除收藏品
	 * 
	 * @param list
	 * @return
	 */
	public int delFavorite(String[] list);

	/**
	 * 获取用户的收藏夹集合
	 * 
	 * @param userid
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<FavoriteT> findAllFavoriteByUserid(final String userid,
			final int currentPage, final int lineSize);

	/**
	 * 统计获取用户的收藏夹集合
	 * 
	 * @param userid
	 * @return
	 */
	public int countfindAllFavoriteByUserid(String userid);

}
