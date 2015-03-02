package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goods_type_brand_t database table.
 * 
 */
@Entity
@Table(name="goods_type_brand_t")
@NamedQuery(name="GoodsTypeBrandT.findAll", query="SELECT g FROM GoodsTypeBrandT g")
public class GoodsTypeBrandT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsTypeBrandTid;
	private String brandid;
	private String brandname;
	private String goodsTypeId;
	private String name;

	public GoodsTypeBrandT() {
	}


	@Id
	@Column(name="GOODS_TYPE_BRAND_TID")
	public String getGoodsTypeBrandTid() {
		return this.goodsTypeBrandTid;
	}

	public void setGoodsTypeBrandTid(String goodsTypeBrandTid) {
		this.goodsTypeBrandTid = goodsTypeBrandTid;
	}


	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}


	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	@Column(name="GOODS_TYPE_ID")
	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}