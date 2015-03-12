package com.jshop.vo;

import java.io.Serializable;
/**
 * 商品参数vo
 * @author sdywcd
 *
 */
public class GoodsParameterInGoodsTypeTnVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String sortList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortList() {
		return sortList;
	}

	public void setSortList(String sortList) {
		this.sortList = sortList;
	}

}
