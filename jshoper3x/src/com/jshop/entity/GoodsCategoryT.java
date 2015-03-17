package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_category_t database table.
 * 
 */
@Entity
@Table(name="goods_category_t")
@NamedQuery(name="GoodsCategoryT.findAll", query="SELECT g FROM GoodsCategoryT g")
public class GoodsCategoryT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsCategoryTid;
	private Date createtime;
	private String creatorid;
	private String goodsTypeId;
	private String grade;
	private String htmlpath;
	private String logo;
	private String metaDes;
	private String metaKeywords;
	private String mobilesync;
	private String name;
	private String parentId;
	private String parentName;
	private String path;
	private String shopid;
	private String shopname;
	private String sign;
	private int sort;
	private String state;
	private Date updatetime;
	private int versiont;

	public GoodsCategoryT() {
	}


	@Id
	@Column(name="GOODS_CATEGORY_TID")
	public String getGoodsCategoryTid() {
		return this.goodsCategoryTid;
	}

	public void setGoodsCategoryTid(String goodsCategoryTid) {
		this.goodsCategoryTid = goodsCategoryTid;
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


	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getHtmlpath() {
		return this.htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}


	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}


	@Column(name="META_DES")
	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}


	@Column(name="META_KEYWORDS")
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	public String getMobilesync() {
		return this.mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="PARENT_ID")
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	@Column(name="PARENT_NAME")
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}