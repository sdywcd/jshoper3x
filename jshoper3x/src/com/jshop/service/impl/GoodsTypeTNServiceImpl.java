package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsTypeTNDao;
import com.jshop.entity.GoodsTypeTN;
import com.jshop.service.GoodsTypeTNService;

@Service("goodsTypeTNService")
@Scope("prototype")
public class GoodsTypeTNServiceImpl extends BaseTServiceImpl<GoodsTypeTN> implements GoodsTypeTNService {
	@Resource
	private GoodsTypeTNDao goodsTypeTNDao;

	public GoodsTypeTNDao getGoodsTypeTNDao() {
		return goodsTypeTNDao;
	}

	public void setGoodsTypeTNDao(GoodsTypeTNDao goodsTypeTNDao) {
		this.goodsTypeTNDao = goodsTypeTNDao;
	}

	public int updateGoodsTypeTN(GoodsTypeTN gtn) {
		return this.getGoodsTypeTNDao().updateGoodsTypeTN(gtn);
	}

	public int countfindAllGoodsTypeTN() {
		return this.getGoodsTypeTNDao().countfindAllGoodsTypeTN();
	}

	public List<GoodsTypeTN> findAllGoodsTypeTN(int currentPage, int lineSize) {
		return this.getGoodsTypeTNDao().findAllGoodsTypeTN(currentPage, lineSize);
	}

	public List<GoodsTypeTN> findGoodsTypeTNById(String goodsTypeId) {
		return this.getGoodsTypeTNDao().findGoodsTypeTNById(goodsTypeId);
	}

	public int delGoodsTypeTN(String[] list) {
		return this.getGoodsTypeTNDao().delGoodsTypeTN(list);
	}

	public List<GoodsTypeTN> findAllGoodsTypeTNNopage() {
		return this.getGoodsTypeTNDao().findAllGoodsTypeTNNopage();
	}

	public List<GoodsTypeTN> sortAllGoodsTypeTN(int currentPage, int lineSize, String queryString) {

		return this.getGoodsTypeTNDao().sortAllGoodsTypeTN(currentPage, lineSize, queryString);
	}

	@Override
	public List<GoodsTypeTN> findGoodsTypeTNByName(String name) {
		return this.getGoodsTypeTNDao().findGoodsTypeTNByName(name);
	}

	@Override
	public int countsortAllGoodsTypeTN(String queryString) {
		return this.getGoodsTypeTNDao().countsortAllGoodsTypeTN(queryString);
	}
}
