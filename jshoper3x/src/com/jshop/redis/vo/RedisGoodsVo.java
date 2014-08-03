package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsT;

public class RedisGoodsVo implements Serializable{

	private List<GoodsT>glist;

	public List<GoodsT> getGlist() {
		return glist;
	}

	public void setGlist(List<GoodsT> glist) {
		this.glist = glist;
	}
	
}
