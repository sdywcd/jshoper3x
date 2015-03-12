package com.jshop.vo;

import java.io.Serializable;

/**
 * 商品参数vo
 * 
 * @author sdywcd
 * 
 */
public class GoodsParameterInGoodsTVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
