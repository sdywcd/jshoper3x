package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goods_twocode_relationship_t database table.
 * 
 */
@Entity
@Table(name="goods_twocode_relationship_t")
@NamedQuery(name="GoodsTwocodeRelationshipT.findAll", query="SELECT g FROM GoodsTwocodeRelationshipT g")
public class GoodsTwocodeRelationshipT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String goodsid;
	private String goodsname;
	private String state;
	private String twocodepath;

	public GoodsTwocodeRelationshipT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getTwocodepath() {
		return this.twocodepath;
	}

	public void setTwocodepath(String twocodepath) {
		this.twocodepath = twocodepath;
	}

}