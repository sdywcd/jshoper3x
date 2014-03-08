package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.FavoriteTDao;
import com.jshop.dao.impl.FavoriteTDaoImpl;
import com.jshop.entity.FavoriteT;
import com.jshop.service.FavoriteTService;

@Service("favoriteTService")
@Scope("prototype")
public class FavoriteTServiceImpl extends BaseTServiceImpl<FavoriteT>implements FavoriteTService {
	@Resource
	private FavoriteTDao favoriteTDao;

	public FavoriteTDao getFavoriteTDao() {
		return favoriteTDao;
	}

	public void setFavoriteTDao(FavoriteTDao favoriteTDao) {
		this.favoriteTDao = favoriteTDao;
	}

	public int delFavorite(String[] list) {
		return this.getFavoriteTDao().delFavorite(list);
	}

	public int countfindAllFavoriteByUserid(String userid) {
		return this.getFavoriteTDao().countfindAllFavoriteByUserid(userid);
	}

	public List<FavoriteT> findAllFavoriteByUserid(String userid, int currentPage, int lineSize) {
		return this.getFavoriteTDao().findAllFavoriteByUserid(userid, currentPage, lineSize);
	}
}
