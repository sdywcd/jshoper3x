package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the site_navigation_t database table.
 * 
 */
@Entity
@Table(name="site_navigation_t")
@NamedQuery(name="SiteNavigationT.findAll", query="SELECT s FROM SiteNavigationT s")
public class SiteNavigationT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String snid;
	private Date createtime;
	private String creatorid;
	private String htmlPath;
	private String isTargetBlank;
	private String isVisible;
	private String name;
	private String position;
	private String shopid;
	private String shopname;
	private String sign;
	private int sort;

	public SiteNavigationT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getSnid() {
		return this.snid;
	}

	public void setSnid(String snid) {
		this.snid = snid;
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


	@Column(name="HTML_PATH", nullable=false, length=255)
	public String getHtmlPath() {
		return this.htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}


	@Column(name="IS_TARGET_BLANK", nullable=false, length=1)
	public String getIsTargetBlank() {
		return this.isTargetBlank;
	}

	public void setIsTargetBlank(String isTargetBlank) {
		this.isTargetBlank = isTargetBlank;
	}


	@Column(name="IS_VISIBLE", nullable=false, length=1)
	public String getIsVisible() {
		return this.isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}


	@Column(nullable=false, length=45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=1)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
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


	@Column(nullable=false, length=45)
	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


	@Column(nullable=false)
	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}