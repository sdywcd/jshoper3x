package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the article_category_t database table.
 * 
 */
@Entity
@Table(name="article_category_t")
@NamedQuery(name="ArticleCategoryT.findAll", query="SELECT a FROM ArticleCategoryT a")
public class ArticleCategoryT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String articleCategoryTid;
	private Date createtime;
	private String creatorid;
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
	private String position;
	private String shopid;
	private String shopname;
	private String sign;
	private int sort;
	private String status;
	private Date updatetime;
	private int versiont;

	public ArticleCategoryT() {
	}


	@Id
	@Column(name="ARTICLE_CATEGORY_TID")
	public String getArticleCategoryTid() {
		return this.articleCategoryTid;
	}

	public void setArticleCategoryTid(String articleCategoryTid) {
		this.articleCategoryTid = articleCategoryTid;
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


	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
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


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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