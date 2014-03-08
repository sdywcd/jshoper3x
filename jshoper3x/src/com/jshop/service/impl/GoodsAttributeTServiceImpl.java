package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsAttributeTDao;
import com.jshop.entity.GoodsAttributeT;
import com.jshop.service.GoodsAttributeTService;

@Service("goodsAttributeTService")
@Scope("prototype")
public class GoodsAttributeTServiceImpl extends BaseTServiceImpl<GoodsAttributeT>implements GoodsAttributeTService {
	@Resource
	private GoodsAttributeTDao goodsAttributeTDao;

	public GoodsAttributeTDao getGoodsAttributeTDao() {
		return goodsAttributeTDao;
	}

	public void setGoodsAttributeTDao(GoodsAttributeTDao goodsAttributeTDao) {
		this.goodsAttributeTDao = goodsAttributeTDao;
	}

	public int updateGoodsAttributeT(GoodsAttributeT gat) {
		return this.getGoodsAttributeTDao().updateGoodsAttributeT(gat);
	}

	public GoodsAttributeT findGoodsAttributeTBygoodstypeId(String goodstypeid) {
		return this.getGoodsAttributeTDao().findGoodsAttributeTBygoodstypeId(goodstypeid);
	}

	public int countfindAllGoodsAttributeT() {
		return this.getGoodsAttributeTDao().countfindAllGoodsAttributeT();
	}

	public List<GoodsAttributeT> findAllGoodsAttributeT(int currentPage, int lineSize) {
		return this.getGoodsAttributeTDao().findAllGoodsAttributeT(currentPage, lineSize);
	}

	public int delGoodsAttributeT(String[] list) {
		return this.getGoodsAttributeTDao().delGoodsAttributeT(list);
	}

	public List<GoodsAttributeT> findGoodsAttributeTByGoodsTypeName(String goodsTypeName) {
		return this.getGoodsAttributeTDao().findGoodsAttributeTByGoodsTypeName(goodsTypeName);
	}

	public List<GoodsAttributeT> findGoodsAttributeTBygoodsTypeId(String goodsTypeId) {
		return this.getGoodsAttributeTDao().findGoodsAttributeTBygoodsTypeId(goodsTypeId);
	}

	public List<GoodsAttributeT> sortAllGoodsAttributeT(int currentPage, int lineSize, String queryString) {

		return this.getGoodsAttributeTDao().sortAllGoodsAttributeT(currentPage, lineSize, queryString);
	}

	public int updateGoodsAttributeTgoodsTypeName(String goodsTypeName, String goodsTypeId) {
		return this.getGoodsAttributeTDao().updateGoodsAttributeTgoodsTypeName(goodsTypeName, goodsTypeId);
	}

	public int updateGoodsAttributeissametolinkBygoodsattributeid(String[] goodsattributeid, String issametolink) {
		return this.getGoodsAttributeTDao().updateGoodsAttributeissametolinkBygoodsattributeid(goodsattributeid, issametolink);
	}

	public int updateGoodsAttributeissearchBygoodsattributeid(String[] goodsattributeid, String issearch) {
		return this.getGoodsAttributeTDao().updateGoodsAttributeissearchBygoodsattributeid(goodsattributeid, issearch);
	}

	@Override
	public int countsortAllGoodsAttributeT(String queryString) {
		return this.getGoodsAttributeTDao().countsortAllGoodsAttributeT(queryString);
	}

}
