package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsBelinkedTDao;
import com.jshop.entity.GoodsBelinkedT;
import com.jshop.service.GoodsBelinkedTService;

@Service("goodsBelinkedTService")
@Scope("prototype")
public class GoodsBelinkedTServiceImpl implements GoodsBelinkedTService {
	@Resource
	private GoodsBelinkedTDao goodsBelinkedTDao;

	public GoodsBelinkedTDao getGoodsBelinkedTDao() {
		return goodsBelinkedTDao;
	}

	public void setGoodsBelinkedTDao(GoodsBelinkedTDao goodsBelinkedTDao) {
		this.goodsBelinkedTDao = goodsBelinkedTDao;
	}

	@Override
	public int addGoodsBelinkedT(GoodsBelinkedT gbel) {
		return this.getGoodsBelinkedTDao().addGoodsBelinkedT(gbel);
	}

	@Override
	public int updateGoodsBelinked(GoodsBelinkedT gbel) {
		return this.getGoodsBelinkedTDao().updateGoodsBelinked(gbel);
	}

	@Override
	public List<GoodsBelinkedT> findGoodsBelinkedBymaingoodsid(String maingoodsid) {
		return this.getGoodsBelinkedTDao().findGoodsBelinkedBymaingoodsid(maingoodsid);
	}

	@Override
	public int delGoodsBelinkedBymaingoodsid(String maingoodsid) {
		return this.getGoodsBelinkedTDao().delGoodsBelinkedBymaingoodsid(maingoodsid);
	}

	@Override
	public int delGoodsBelinkedBymaingoodsidandsxlinkedgoodsid(String maingoodsid, String sxlinkedgoodsid) {
		return this.getGoodsBelinkedTDao().delGoodsBelinkedBymaingoodsidandsxlinkedgoodsid(maingoodsid, sxlinkedgoodsid);
	}

}
