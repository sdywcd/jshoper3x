package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.vo.GoodsCategoryPathVo;

public class RedisFirstGoodsCateogryTVo implements Serializable {

	private GoodsCategoryT goodsCategoryTs;

	public GoodsCategoryT getGoodsCategoryTs() {
		return goodsCategoryTs;
	}

	public void setGoodsCategoryTs(GoodsCategoryT goodsCategoryTs) {
		this.goodsCategoryTs = goodsCategoryTs;
	}

	

	
}
