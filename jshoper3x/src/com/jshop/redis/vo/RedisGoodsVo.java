package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.vo.GoodsCategoryPathVo;

public class RedisGoodsVo implements Serializable{
	
	private List<GoodsCategoryPathVo> gcpath;

	private List<GoodsT>glist;
	
	private List<GoodsTypeBrandT>gtbrand;
	

	
	public List<GoodsTypeBrandT> getGtbrand() {
		return gtbrand;
	}

	public void setGtbrand(List<GoodsTypeBrandT> gtbrand) {
		this.gtbrand = gtbrand;
	}

	public List<GoodsCategoryPathVo> getGcpath() {
		return gcpath;
	}

	public void setGcpath(List<GoodsCategoryPathVo> gcpath) {
		this.gcpath = gcpath;
	}

	public List<GoodsT> getGlist() {
		return glist;
	}

	public void setGlist(List<GoodsT> glist) {
		this.glist = glist;
	}
	
}
