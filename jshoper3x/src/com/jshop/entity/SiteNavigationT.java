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
	public String getSnid() {
		return this.snid;
	}

	public void setSnid(String snid) {
		this.snid = snid;
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


	@Column(name="HTML_PATH")
	public String getHtmlPath() {
		return this.htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}


	@Column(name="IS_TARGET_BLANK")
	public String getIsTargetBlank() {
		return this.isTargetBlank;
	}

	public void setIsTargetBlank(String isTargetBlank) {
		this.isTargetBlank = isTargetBlank;
	}


	@Column(name="IS_VISIBLE")
	public String getIsVisible() {
		return this.isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

}