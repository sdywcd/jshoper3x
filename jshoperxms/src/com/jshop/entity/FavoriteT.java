package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the favorite_t database table.
 * 
 */
@Entity
@Table(name="favorite_t")
@NamedQuery(name="FavoriteT.findAll", query="SELECT f FROM FavoriteT f")
public class FavoriteT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String favoriteid;
	private Date addtime;
	private String descript;
	private String goodsid;
	private String htmlpath;
	private String memberid;
	private String memberprice;
	private String productid;
	private int readcount;
	private String state;
	private String tag;
	private String title;

	public FavoriteT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getFavoriteid() {
		return this.favoriteid;
	}

	public void setFavoriteid(String favoriteid) {
		this.favoriteid = favoriteid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}


	@Column(length=50)
	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}


	@Column(length=20)
	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	@Column(nullable=false, length=255)
	public String getHtmlpath() {
		return this.htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}


	@Column(nullable=false, length=20)
	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	@Column(length=10)
	public String getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(String memberprice) {
		this.memberprice = memberprice;
	}


	@Column(length=20)
	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}


	public int getReadcount() {
		return this.readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(length=20)
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


	@Column(nullable=false, length=200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}