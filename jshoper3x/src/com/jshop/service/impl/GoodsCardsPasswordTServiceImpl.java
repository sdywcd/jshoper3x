package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsCardsPasswordTDao;
import com.jshop.entity.GoodsCardsPasswordT;
import com.jshop.service.GoodsCardsPasswordTService;

@Service("goodsCardsPasswordTService")
@Scope("prototype")
public class GoodsCardsPasswordTServiceImpl extends BaseTServiceImpl<GoodsCardsPasswordT> implements GoodsCardsPasswordTService {
	@Resource
	private GoodsCardsPasswordTDao goodsCardsPasswordTDao;
	@Override
	public List<GoodsCardsPasswordT> findGoodsCardsPasswordByGoodsCardsId(
			int currentPage, int lineSize, String goodsCardsId) {
		return goodsCardsPasswordTDao.findGoodsCardsPasswordByGoodsCardsId(currentPage, lineSize, goodsCardsId);
	}

	@Override
	public int countfindGoodsCardsPasswordByGoodsCardsId(String goodsCardsId) {
		return goodsCardsPasswordTDao.countfindGoodsCardsPasswordByGoodsCardsId(goodsCardsId);
	}

}
