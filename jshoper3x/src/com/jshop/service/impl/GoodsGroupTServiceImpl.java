package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsGroupTDao;
import com.jshop.entity.GoodsGroupT;
import com.jshop.service.GoodsGroupTService;

@Service("goodsGroupTService")
@Scope("prototype")
public class GoodsGroupTServiceImpl extends BaseTServiceImpl<GoodsGroupT> implements GoodsGroupTService {
	@Resource
	public GoodsGroupTDao goodsGroupTDao;

	public GoodsGroupTDao getGoodsGroupTDao() {
		return goodsGroupTDao;
	}

	public void setGoodsGroupTDao(GoodsGroupTDao goodsGroupTDao) {
		this.goodsGroupTDao = goodsGroupTDao;
	}


	@Override
	public int updateGoodsGroupT(GoodsGroupT group) {

		return this.getGoodsGroupTDao().updateGoodsGroupT(group);
	}

	@Override
	public List<GoodsGroupT> findAllGoodsGroupT(int currentPage, int lineSize) {

		return this.getGoodsGroupTDao().findAllGoodsGroupT(currentPage, lineSize);
	}

	@Override
	public int delGoodsGroupT(String[] list) {

		return this.getGoodsGroupTDao().delGoodsGroupT(list);
	}

	@Override
	public int countAllGoodsGroupT() {

		return this.getGoodsGroupTDao().countAllGoodsGroupT();
	}

	@Override
	public List<GoodsGroupT> sortAllGoodsGroup(int currentPage, int lineSize, String queryString) {

		return this.getGoodsGroupTDao().sortAllGoodsGroup(currentPage, lineSize, queryString);
	}

	@Override
	public GoodsGroupT findGoodsGroupById(String groupid) {

		return this.getGoodsGroupTDao().findGoodsGroupById(groupid);
	}

	@Override
	public int updateState(GoodsGroupT ggt) {

		return this.getGoodsGroupTDao().updateState(ggt);
	}

	@Override
	public List<GoodsGroupT> findGoodsGroupByState(String state) {

		return this.getGoodsGroupTDao().findGoodsGroupByState(state);
	}

	@Override
	public int updateGoodsGroupHtmlPath(String htmlPath, String groupid) {

		return this.getGoodsGroupTDao().updateGoodsGroupHtmlPath(htmlPath, groupid);
	}

}
