package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the merchant_goods_type_t_n database table.
 * 
 */
@Entity
@Table(name="merchant_goods_type_t_n")
@NamedQuery(name="MerchantGoodsTypeTN.findAll", query="SELECT m FROM MerchantGoodsTypeTN m")
public class MerchantGoodsTypeTN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mgoodsTypeId;
	private Date createtime;
	private String creatorid;
	private String goodsParameter;
	private String name;
	private String shopid;
	private String shopname;

	public MerchantGoodsTypeTN() {
	}


	@Id
	@Column(name="MGOODS_TYPE_ID", unique=true, nullable=false, length=20)
	public String getMgoodsTypeId() {
		return this.mgoodsTypeId;
	}

	public void setMgoodsTypeId(String mgoodsTypeId) {
		this.mgoodsTypeId = mgoodsTypeId;
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


	@Lob
	@Column(name="GOODS_PARAMETER", nullable=false)
	public String getGoodsParameter() {
		return this.goodsParameter;
	}

	public void setGoodsParameter(String goodsParameter) {
		this.goodsParameter = goodsParameter;
	}


	@Column(nullable=false, length=45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(nullable=false, length=45)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

}