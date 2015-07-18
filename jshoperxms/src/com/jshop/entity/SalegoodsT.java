package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the salegoods_t database table.
 * 
 */
@Entity
@Table(name="salegoods_t")
@NamedQuery(name="SalegoodsT.findAll", query="SELECT s FROM SalegoodsT s")
public class SalegoodsT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String salegoodsid;
	private Date begingtime;
	private Date endingtime;
	private String htmlpath;
	private double lowprice;
	private String manufacturer;
	private double marketprice;
	private String newornot;
	private String place;
	private String realname;
	private String salebudget;
	private String salegoodsinformation;
	private String salegoodsmessage;
	private String salegoodsname;
	private String salegoodsnumber;
	private String salegoodspictureurl;
	private String salegoodsstate;
	private int salejoinpeople;
	private String salepeople;
	private double saleprice;
	private double salestartingprice;
	private String userid;

	public SalegoodsT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getSalegoodsid() {
		return this.salegoodsid;
	}

	public void setSalegoodsid(String salegoodsid) {
		this.salegoodsid = salegoodsid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getBegingtime() {
		return this.begingtime;
	}

	public void setBegingtime(Date begingtime) {
		this.begingtime = begingtime;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndingtime() {
		return this.endingtime;
	}

	public void setEndingtime(Date endingtime) {
		this.endingtime = endingtime;
	}


	@Column(length=45)
	public String getHtmlpath() {
		return this.htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}


	public double getLowprice() {
		return this.lowprice;
	}

	public void setLowprice(double lowprice) {
		this.lowprice = lowprice;
	}


	@Column(length=35)
	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public double getMarketprice() {
		return this.marketprice;
	}

	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}


	@Column(length=10)
	public String getNewornot() {
		return this.newornot;
	}

	public void setNewornot(String newornot) {
		this.newornot = newornot;
	}


	@Column(length=30)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}


	@Column(nullable=false, length=20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	@Column(length=200)
	public String getSalebudget() {
		return this.salebudget;
	}

	public void setSalebudget(String salebudget) {
		this.salebudget = salebudget;
	}


	@Column(length=200)
	public String getSalegoodsinformation() {
		return this.salegoodsinformation;
	}

	public void setSalegoodsinformation(String salegoodsinformation) {
		this.salegoodsinformation = salegoodsinformation;
	}


	@Column(length=50)
	public String getSalegoodsmessage() {
		return this.salegoodsmessage;
	}

	public void setSalegoodsmessage(String salegoodsmessage) {
		this.salegoodsmessage = salegoodsmessage;
	}


	@Column(nullable=false, length=20)
	public String getSalegoodsname() {
		return this.salegoodsname;
	}

	public void setSalegoodsname(String salegoodsname) {
		this.salegoodsname = salegoodsname;
	}


	@Column(nullable=false, length=50)
	public String getSalegoodsnumber() {
		return this.salegoodsnumber;
	}

	public void setSalegoodsnumber(String salegoodsnumber) {
		this.salegoodsnumber = salegoodsnumber;
	}


	@Column(nullable=false, length=225)
	public String getSalegoodspictureurl() {
		return this.salegoodspictureurl;
	}

	public void setSalegoodspictureurl(String salegoodspictureurl) {
		this.salegoodspictureurl = salegoodspictureurl;
	}


	@Column(nullable=false, length=1)
	public String getSalegoodsstate() {
		return this.salegoodsstate;
	}

	public void setSalegoodsstate(String salegoodsstate) {
		this.salegoodsstate = salegoodsstate;
	}


	@Column(nullable=false)
	public int getSalejoinpeople() {
		return this.salejoinpeople;
	}

	public void setSalejoinpeople(int salejoinpeople) {
		this.salejoinpeople = salejoinpeople;
	}


	@Column(length=20)
	public String getSalepeople() {
		return this.salepeople;
	}

	public void setSalepeople(String salepeople) {
		this.salepeople = salepeople;
	}


	@Column(nullable=false)
	public double getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}


	@Column(nullable=false)
	public double getSalestartingprice() {
		return this.salestartingprice;
	}

	public void setSalestartingprice(double salestartingprice) {
		this.salestartingprice = salestartingprice;
	}


	@Column(nullable=false, length=20)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}