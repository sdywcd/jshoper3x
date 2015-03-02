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


	public String getNewornot() {
		return this.newornot;
	}

	public void setNewornot(String newornot) {
		this.newornot = newornot;
	}


	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}


	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getSalebudget() {
		return this.salebudget;
	}

	public void setSalebudget(String salebudget) {
		this.salebudget = salebudget;
	}


	public String getSalegoodsinformation() {
		return this.salegoodsinformation;
	}

	public void setSalegoodsinformation(String salegoodsinformation) {
		this.salegoodsinformation = salegoodsinformation;
	}


	public String getSalegoodsmessage() {
		return this.salegoodsmessage;
	}

	public void setSalegoodsmessage(String salegoodsmessage) {
		this.salegoodsmessage = salegoodsmessage;
	}


	public String getSalegoodsname() {
		return this.salegoodsname;
	}

	public void setSalegoodsname(String salegoodsname) {
		this.salegoodsname = salegoodsname;
	}


	public String getSalegoodsnumber() {
		return this.salegoodsnumber;
	}

	public void setSalegoodsnumber(String salegoodsnumber) {
		this.salegoodsnumber = salegoodsnumber;
	}


	public String getSalegoodspictureurl() {
		return this.salegoodspictureurl;
	}

	public void setSalegoodspictureurl(String salegoodspictureurl) {
		this.salegoodspictureurl = salegoodspictureurl;
	}


	public String getSalegoodsstate() {
		return this.salegoodsstate;
	}

	public void setSalegoodsstate(String salegoodsstate) {
		this.salegoodsstate = salegoodsstate;
	}


	public int getSalejoinpeople() {
		return this.salejoinpeople;
	}

	public void setSalejoinpeople(int salejoinpeople) {
		this.salejoinpeople = salejoinpeople;
	}


	public String getSalepeople() {
		return this.salepeople;
	}

	public void setSalepeople(String salepeople) {
		this.salepeople = salepeople;
	}


	public double getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}


	public double getSalestartingprice() {
		return this.salestartingprice;
	}

	public void setSalestartingprice(double salestartingprice) {
		this.salestartingprice = salestartingprice;
	}


	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}