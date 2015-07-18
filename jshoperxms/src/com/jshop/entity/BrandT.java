package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the brand_t database table.
 * 
 */
@Entity
@Table(name="brand_t")
@NamedQuery(name="BrandT.findAll", query="SELECT b FROM BrandT b")
public class BrandT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String brandid;
	private String brandname;
	private Date createtime;
	private String creatorid;
	private String intro;
	private String logoPath;
	private String remark;
	private String shopid;
	private String shopname;
	private String smallLogoPath;
	private int sort;
	private String url;
	private String username;

	public BrandT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}


	@Column(nullable=false, length=50)
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


	@Lob
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}


	@Column(name="LOGO_PATH", nullable=false, length=255)
	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}


	@Column(nullable=false, length=100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Column(length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(length=45)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(name="SMALL_LOGO_PATH", nullable=false, length=255)
	public String getSmallLogoPath() {
		return this.smallLogoPath;
	}

	public void setSmallLogoPath(String smallLogoPath) {
		this.smallLogoPath = smallLogoPath;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	@Column(length=255)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	@Column(length=50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}