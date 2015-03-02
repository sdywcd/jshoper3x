package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product_specifications_t database table.
 * 
 */
@Entity
@Table(name="product_specifications_t")
@NamedQuery(name="ProductSpecificationsT.findAll", query="SELECT p FROM ProductSpecificationsT p")
public class ProductSpecificationsT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String specificationsid;
	private Date createtime;
	private String creatorid;
	private String goodsTypeId;
	private String goodsTypeName;
	private String name;
	private String note;
	private String shopid;
	private String sort;
	private String specificationsType;
	private String specificationsValue;
	private String state;

	public ProductSpecificationsT() {
	}


	@Id
	public String getSpecificationsid() {
		return this.specificationsid;
	}

	public void setSpecificationsid(String specificationsid) {
		this.specificationsid = specificationsid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(name="GOODS_TYPE_ID")
	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}


	@Column(name="GOODS_TYPE_NAME")
	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}


	@Column(name="SPECIFICATIONS_TYPE")
	public String getSpecificationsType() {
		return this.specificationsType;
	}

	public void setSpecificationsType(String specificationsType) {
		this.specificationsType = specificationsType;
	}


	@Column(name="SPECIFICATIONS_VALUE")
	public String getSpecificationsValue() {
		return this.specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}