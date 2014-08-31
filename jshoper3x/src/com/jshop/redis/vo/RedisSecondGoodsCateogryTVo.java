package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.vo.GoodsCategoryPathVo;

public class RedisSecondGoodsCateogryTVo implements Serializable {

	private List<GoodsCategoryT> goodsCategoryTs;

	public List<GoodsCategoryT> getGoodsCategoryTs() {
		return goodsCategoryTs;
	}

	public void setGoodsCategoryTs(List<GoodsCategoryT> goodsCategoryTs) {
		this.goodsCategoryTs = goodsCategoryTs;
	}

	
}
