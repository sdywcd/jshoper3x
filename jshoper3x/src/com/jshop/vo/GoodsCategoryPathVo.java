package com.jshop.vo;

import java.io.Serializable;

/**
 * 商品分类递归路径
 * 
 * @author sdywcd
 * 
 */
public class GoodsCategoryPathVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4395258175126073759L;
	private String name;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
