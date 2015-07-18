package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.vo.GoodsCategoryPathVo;

public class RedisHotsaleGoodsVo implements Serializable {

	private List<GoodsT>hotsaleGoodsTs;

	public List<GoodsT> getHotsaleGoodsTs() {
		return hotsaleGoodsTs;
	}

	public void setHotsaleGoodsTs(List<GoodsT> hotsaleGoodsTs) {
		this.hotsaleGoodsTs = hotsaleGoodsTs;
	}
	
	

	
}
