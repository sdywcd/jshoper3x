package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.vo.GoodsCategoryPathVo;

public class RedisGoodsTypeBrandVo implements Serializable{
	
	
	private List<GoodsTypeBrandT>gtbrand;
	

	
	public List<GoodsTypeBrandT> getGtbrand() {
		return gtbrand;
	}

	public void setGtbrand(List<GoodsTypeBrandT> gtbrand) {
		this.gtbrand = gtbrand;
	}

	
	
}
