package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.vo.GoodsCategoryPathVo;

public class RedisGoodsCategoryPathVo implements Serializable {

	private List<GoodsCategoryPathVo> gcpath;

	public List<GoodsCategoryPathVo> getGcpath() {
		return gcpath;
	}

	public void setGcpath(List<GoodsCategoryPathVo> gcpath) {
		this.gcpath = gcpath;
	}

}
