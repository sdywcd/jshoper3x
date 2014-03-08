package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsunitTDao;
import com.jshop.dao.impl.GoodsunitTDaoImpl;
import com.jshop.entity.GoodsunitT;
import com.jshop.service.GoodsunitTService;

@Service("goodsunitTService")
@Scope("prototype")
public class GoodsunitTServiceImpl extends BaseTServiceImpl<GoodsunitT>implements GoodsunitTService {
	@Resource
	private GoodsunitTDao goodsunitTDao;

	public GoodsunitTDao getGoodsunitTDao() {
		return goodsunitTDao;
	}

	public void setGoodsunitTDao(GoodsunitTDao goodsunitTDao) {
		this.goodsunitTDao = goodsunitTDao;
	}

	public int delGoodsunit(String[] list) {
		return this.getGoodsunitTDao().delGoodsunit(list);
	}

	public int updateGoodsunit(GoodsunitT u) {
		return this.getGoodsunitTDao().updateGoodsunit(u);
	}


	public int countfindAllGoodsunit() {
		return this.getGoodsunitTDao().countfindAllGoodsunit();
	}

	public List<GoodsunitT> findAllGoodsunit(int currentPage, int lineSize) {
		return this.getGoodsunitTDao().findAllGoodsunit(currentPage, lineSize);
	}

	public GoodsunitT findGoodsunitById(String unitid) {
		return this.getGoodsunitTDao().findGoodsunitById(unitid);
	}

	public List<GoodsunitT> findAllGoodsunitjson() {
		return this.getGoodsunitTDao().findAllGoodsunitjson();
	}

	public List<GoodsunitT> sortAllGoodsunit(int currentPage, int lineSize, String queryString) {

		return this.getGoodsunitTDao().sortAllGoodsunit(currentPage, lineSize, queryString);
	}
}
