package com.jshop.redis.vo;

import java.io.Serializable;
import java.util.List;

import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.vo.GoodsCategoryPathVo;

public class RedisGoodsInFirstCateogryTVo implements Serializable {

	private List<GoodsT> glist;

	public List<GoodsT> getGlist() {
		return glist;
	}

	public void setGlist(List<GoodsT> glist) {
		this.glist = glist;
	}

}
