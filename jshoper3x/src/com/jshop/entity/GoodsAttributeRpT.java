package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goods_attribute_rp_t database table.
 * 
 */
@Entity
@Table(name="goods_attribute_rp_t")
@NamedQuery(name="GoodsAttributeRpT.findAll", query="SELECT g FROM GoodsAttributeRpT g")
public class GoodsAttributeRpT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String attrval;
	private String goodsid;

	public GoodsAttributeRpT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getAttrval() {
		return this.attrval;
	}

	public void setAttrval(String attrval) {
		this.attrval = attrval;
	}


	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

}