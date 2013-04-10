package com.jshop.service;

import java.util.List;

import com.jshop.entity.FavoriteT;

public interface FavoriteTService {

	/**
	 * 向收藏夹增加商品
	 * @param f
	 * @return
	 */
	public abstract int addFavorite(FavoriteT f);
	/**
	 * 删除收藏品
	 * @param list
	 * @return
	 */
	public abstract int delFavorite(String[]list);
	/**
	 * 获取用户的收藏夹集合
	 * @param userid
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<FavoriteT>findAllFavoriteByUserid(final String userid,final int currentPage,final int lineSize);
	/**
	 * 统计获取用户的收藏夹集合
	 * @param userid
	 * @return
	 */
	public abstract int countfindAllFavoriteByUserid(String userid);


}
