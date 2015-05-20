package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goods_twocode_rp_t database table.
 * 
 */
@Entity
@Table(name="goods_twocode_rp_t")
@NamedQuery(name="GoodsTwocodeRpT.findAll", query="SELECT g FROM GoodsTwocodeRpT g")
public class GoodsTwocodeRpT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String goodsid;
	private String productid;
	private String productname;
	private String state;
	private String twocodepath;

	public GoodsTwocodeRpT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(nullable=false, length=20)
	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	@Column(nullable=false, length=20)
	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}


	@Column(nullable=false, length=100)
	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(nullable=false, length=255)
	public String getTwocodepath() {
		return this.twocodepath;
	}

	public void setTwocodepath(String twocodepath) {
		this.twocodepath = twocodepath;
	}

}