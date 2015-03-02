package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_group_t database table.
 * 
 */
@Entity
@Table(name="goods_group_t")
@NamedQuery(name="GoodsGroupT.findAll", query="SELECT g FROM GoodsGroupT g")
public class GoodsGroupT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String groupid;
	private Date begintime;
	private double cashlimit;
	private String cashstate;
	private Date createtime;
	private String creatorid;
	private String detail;
	private Date endtime;
	private String goodsid;
	private String goodsname;
	private double groupprice;
	private String htmlpath;
	private int limitbuy;
	private double memberprice;
	private String pictureurl;
	private String placename;
	private String priceladder;
	private int sOrderCount;
	private int salequantity;
	private double sendpoint;
	private String state;
	private int totalOrderCount;

	public GoodsGroupT() {
	}


	@Id
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}


	public double getCashlimit() {
		return this.cashlimit;
	}

	public void setCashlimit(double cashlimit) {
		this.cashlimit = cashlimit;
	}


	public String getCashstate() {
		return this.cashstate;
	}

	public void setCashstate(String cashstate) {
		this.cashstate = cashstate;
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


	@Lob
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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


	public double getGroupprice() {
		return this.groupprice;
	}

	public void setGroupprice(double groupprice) {
		this.groupprice = groupprice;
	}


	public String getHtmlpath() {
		return this.htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}


	public int getLimitbuy() {
		return this.limitbuy;
	}

	public void setLimitbuy(int limitbuy) {
		this.limitbuy = limitbuy;
	}


	public double getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}


	public String getPictureurl() {
		return this.pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}


	public String getPlacename() {
		return this.placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}


	public String getPriceladder() {
		return this.priceladder;
	}

	public void setPriceladder(String priceladder) {
		this.priceladder = priceladder;
	}


	@Column(name="S_ORDER_COUNT")
	public int getSOrderCount() {
		return this.sOrderCount;
	}

	public void setSOrderCount(int sOrderCount) {
		this.sOrderCount = sOrderCount;
	}


	public int getSalequantity() {
		return this.salequantity;
	}

	public void setSalequantity(int salequantity) {
		this.salequantity = salequantity;
	}


	public double getSendpoint() {
		return this.sendpoint;
	}

	public void setSendpoint(double sendpoint) {
		this.sendpoint = sendpoint;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(name="TOTAL_ORDER_COUNT")
	public int getTotalOrderCount() {
		return this.totalOrderCount;
	}

	public void setTotalOrderCount(int totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}

}