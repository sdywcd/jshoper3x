package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsTypeBrandTDao;
import com.jshop.dao.impl.GoodsTypeBrandTDaoImpl;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.service.GoodsTypeBrandTService;

@Service("goodsTypeBrandTService")
@Scope("prototype")
public class GoodsTypeBrandTServiceImpl extends
		BaseTServiceImpl<GoodsTypeBrandT> implements GoodsTypeBrandTService {
	@Resource
	private GoodsTypeBrandTDao goodsTypeBrandTDao;

	public GoodsTypeBrandTDao getGoodsTypeBrandTDao() {
		return goodsTypeBrandTDao;
	}

	public void setGoodsTypeBrandTDao(GoodsTypeBrandTDao goodsTypeBrandTDao) {
		this.goodsTypeBrandTDao = goodsTypeBrandTDao;
	}

	public int delGoodsTypeBrand(String[] list) {
		return this.getGoodsTypeBrandTDao().delGoodsTypeBrand(list);
	}

	public List<GoodsTypeBrandT> findAllGoodsTypeBrand(int currentPage,
			int lineSize) {
		return this.getGoodsTypeBrandTDao().findAllGoodsTypeBrand(currentPage,
				lineSize);
	}

	public int countfindAllGoodsTypeBrand() {
		return this.getGoodsTypeBrandTDao().countfindAllGoodsTypeBrand();
	}

	public GoodsTypeBrandT findGoodsTypeBrandByBrandid(String brandid,
			String goodsTypeId) {
		return this.getGoodsTypeBrandTDao().findGoodsTypeBrandByBrandid(
				brandid, goodsTypeId);
	}

	public List<GoodsTypeBrandT> sortAllGoodsTypeBrand(int currentPage,
			int lineSize, String queryString) {

		return this.getGoodsTypeBrandTDao().sortAllGoodsTypeBrand(currentPage,
				lineSize, queryString);
	}

	public int updateGoodsTypeBrandTname(String name, String goodsTypeId) {

		return this.getGoodsTypeBrandTDao().updateGoodsTypeBrandTname(name,
				goodsTypeId);
	}

	public List<GoodsTypeBrandT> findBrandBygoodsTypeId(String goodsTypeId) {
		return this.getGoodsTypeBrandTDao().findBrandBygoodsTypeId(goodsTypeId);
	}

	@Override
	public GoodsTypeBrandT findGoodsTypeIdByBrandid(String brandid) {
		return this.getGoodsTypeBrandTDao().findGoodsTypeIdByBrandid(brandid);
	}

}
