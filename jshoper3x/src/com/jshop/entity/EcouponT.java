package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ecoupon_t database table.
 * 
 */
@Entity
@Table(name="ecoupon_t")
@NamedQuery(name="EcouponT.findAll", query="SELECT e FROM EcouponT e")
public class EcouponT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String eid;
	private Date begintime;
	private String ecouponstate;
	private Date endtime;
	private double favourableprices;
	private String goodsid;
	private String goodsname;
	private String note;
	private double pricededuction;
	private String state;

	public EcouponT() {
	}


	@Id
	public String getEid() {
		return this.eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}


	public String getEcouponstate() {
		return this.ecouponstate;
	}

	public void setEcouponstate(String ecouponstate) {
		this.ecouponstate = ecouponstate;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}


	public double getFavourableprices() {
		return this.favourableprices;
	}

	public void setFavourableprices(double favourableprices) {
		this.favourableprices = favourableprices;
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


	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public double getPricededuction() {
		return this.pricededuction;
	}

	public void setPricededuction(double pricededuction) {
		this.pricededuction = pricededuction;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}