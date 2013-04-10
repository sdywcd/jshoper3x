package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.PlaceoforiginTDao;
import com.jshop.dao.impl.PlaceoforiginTDaoImpl;
import com.jshop.entity.PlaceoforiginT;
import com.jshop.service.PlaceoforiginTService;

@Service("placeoforiginTService")
@Scope("prototype")
public class PlaceoforiginTServiceImpl implements PlaceoforiginTService {
	@Resource
	private PlaceoforiginTDao placeoforiginTDao;

	public PlaceoforiginTDao getPlaceoforiginTDao() {
		return placeoforiginTDao;
	}

	public void setPlaceoforiginTDao(PlaceoforiginTDao placeoforiginTDao) {
		this.placeoforiginTDao = placeoforiginTDao;
	}

	public int delPlaceoforigint(String[] list) {
		return this.getPlaceoforiginTDao().delPlaceoforigint(list);
	}

	public int updatePlaceoforigint(PlaceoforiginT p) {
		return this.getPlaceoforiginTDao().updatePlaceoforigint(p);
	}

	public int addPlaceoforigint(PlaceoforiginT p) {
		return this.getPlaceoforiginTDao().addPlaceoforigint(p);
	}

	public int countfindAllPlaceoforigint() {
		return this.getPlaceoforiginTDao().countfindAllPlaceoforigint();
	}

	public List<PlaceoforiginT> findAllPlaceoforigint(int currentPage, int lineSize) {
		return this.getPlaceoforiginTDao().findAllPlaceoforigint(currentPage, lineSize);
	}

	public PlaceoforiginT findPlaceoforigintById(String placeid) {
		return this.getPlaceoforiginTDao().findPlaceoforigintById(placeid);
	}

	public List<PlaceoforiginT> findAllPlaceoforigintjson() {
		return this.getPlaceoforiginTDao().findAllPlaceoforigintjson();
	}
}
