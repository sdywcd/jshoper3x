package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_attribute_t database table.
 * 
 */
@Entity
@Table(name="goods_attribute_t")
@NamedQuery(name="GoodsAttributeT.findAll", query="SELECT g FROM GoodsAttributeT g")
public class GoodsAttributeT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsattributeid;
	private String attributeIndex;
	private String attributeType;
	private String attributelist;
	private Date createtime;
	private String creatorid;
	private String goodsTypeId;
	private String goodsTypeName;
	private String goodsattributename;
	private String issametolink;
	private String issearch;
	private String sort;
	private String state;

	public GoodsAttributeT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getGoodsattributeid() {
		return this.goodsattributeid;
	}

	public void setGoodsattributeid(String goodsattributeid) {
		this.goodsattributeid = goodsattributeid;
	}


	@Column(name="ATTRIBUTE_INDEX", nullable=false, length=1)
	public String getAttributeIndex() {
		return this.attributeIndex;
	}

	public void setAttributeIndex(String attributeIndex) {
		this.attributeIndex = attributeIndex;
	}


	@Column(name="ATTRIBUTE_TYPE", nullable=false, length=1)
	public String getAttributeType() {
		return this.attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}


	@Column(nullable=false, length=5000)
	public String getAttributelist() {
		return this.attributelist;
	}

	public void setAttributelist(String attributelist) {
		this.attributelist = attributelist;
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


	@Column(name="GOODS_TYPE_NAME", nullable=false, length=45)
	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}


	@Column(nullable=false, length=45)
	public String getGoodsattributename() {
		return this.goodsattributename;
	}

	public void setGoodsattributename(String goodsattributename) {
		this.goodsattributename = goodsattributename;
	}


	@Column(nullable=false, length=1)
	public String getIssametolink() {
		return this.issametolink;
	}

	public void setIssametolink(String issametolink) {
		this.issametolink = issametolink;
	}


	@Column(nullable=false, length=1)
	public String getIssearch() {
		return this.issearch;
	}

	public void setIssearch(String issearch) {
		this.issearch = issearch;
	}


	@Column(nullable=false, length=10)
	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}