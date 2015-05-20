package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	private Date createtime;
	private String creatorid;
	private String goodsTypeId;
	private String name;
	private Date updatetime;

	public GoodsTypeBrandT() {
	}


	@Id
	@Column(name="GOODS_TYPE_BRAND_TID", unique=true, nullable=false, length=20)
	public String getGoodsTypeBrandTid() {
		return this.goodsTypeBrandTid;
	}

	public void setGoodsTypeBrandTid(String goodsTypeBrandTid) {
		this.goodsTypeBrandTid = goodsTypeBrandTid;
	}


	@Column(nullable=false, length=20)
	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}


	@Column(nullable=false, length=45)
	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false, length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(name="GOODS_TYPE_ID", nullable=false, length=20)
	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}


	@Column(nullable=false, length=45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}