package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsCategoryT;

public class RedisGoodsCategoryVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<GoodsCategoryT> goodsCategorys;

	public List<GoodsCategoryT> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryT> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}
	
	
}
