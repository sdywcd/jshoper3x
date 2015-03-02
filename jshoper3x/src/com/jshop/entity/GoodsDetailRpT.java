package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goods_detail_rp_t database table.
 * 
 */
@Entity
@Table(name="goods_detail_rp_t")
@NamedQuery(name="GoodsDetailRpT.findAll", query="SELECT g FROM GoodsDetailRpT g")
public class GoodsDetailRpT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String detail;
	private String goodsid;

	public GoodsDetailRpT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Lob
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

}