package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsAttributeT;

public class RedisGoodsAttrsVo implements Serializable {

	private List<GoodsAttributeT> goodsAttributeT;

	public List<GoodsAttributeT> getGoodsAttributeT() {
		return goodsAttributeT;
	}

	public void setGoodsAttributeT(List<GoodsAttributeT> goodsAttributeT) {
		this.goodsAttributeT = goodsAttributeT;
	}

	
}
