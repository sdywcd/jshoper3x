package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sale_goodsrecord_t database table.
 * 
 */
@Entity
@Table(name="sale_goodsrecord_t")
@NamedQuery(name="SaleGoodsrecordT.findAll", query="SELECT s FROM SaleGoodsrecordT s")
public class SaleGoodsrecordT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String salerecordid;
	private Date begingtime;
	private String email;
	private Date endingtime;
	private double hiprice;
	private String htmlpath;
	private int joinnumber;
	private double lowprice;
	private String manufacturer;
	private double marketprice;
	private String mobile;
	private String place;
	private String points;
	private String realname;
	private String salegoodsid;
	private String salegoodsinformation;
	private String salegoodsmessage;
	private String salegoodsname;
	private String salegoodsnumber;
	private String salegoodspictureurl;
	private String salepeople;
	private double saleprice;
	private double salestartingprice;
	private Date saletradetime;
	private String sex;
	private String telno;
	private String username;

	public SaleGoodsrecordT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=200)
	public String getSalerecordid() {
		return this.salerecordid;
	}

	public void setSalerecordid(String salerecordid) {
		this.salerecordid = salerecordid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getBegingtime() {
		return this.begingtime;
	}

	public void setBegingtime(Date begingtime) {
		this.begingtime = begingtime;
	}


	@Column(length=30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndingtime() {
		return this.endingtime;
	}

	public void setEndingtime(Date endingtime) {
		this.endingtime = endingtime;
	}


	public double getHiprice() {
		return this.hiprice;
	}

	public void setHiprice(double hiprice) {
		this.hiprice = hiprice;
	}


	@Column(length=50)
	public String getHtmlpath() {
		return this.htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}


	public int getJoinnumber() {
		return this.joinnumber;
	}

	public void setJoinnumber(int joinnumber) {
		this.joinnumber = joinnumber;
	}


	public double getLowprice() {
		return this.lowprice;
	}

	public void setLowprice(double lowprice) {
		this.lowprice = lowprice;
	}


	@Column(length=30)
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


	@Column(length=30)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Column(length=30)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}


	@Column(length=200)
	public String getPoints() {
		return this.points;
	}

	public void setPoints(String points) {
		this.points = points;
	}


	@Column(length=20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	@Column(length=20)
	public String getSalegoodsid() {
		return this.salegoodsid;
	}

	public void setSalegoodsid(String salegoodsid) {
		this.salegoodsid = salegoodsid;
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


	@Column(length=45)
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


	@Column(length=225)
	public String getSalegoodspictureurl() {
		return this.salegoodspictureurl;
	}

	public void setSalegoodspictureurl(String salegoodspictureurl) {
		this.salegoodspictureurl = salegoodspictureurl;
	}


	@Column(length=20)
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


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getSaletradetime() {
		return this.saletradetime;
	}

	public void setSaletradetime(Date saletradetime) {
		this.saletradetime = saletradetime;
	}


	@Column(length=1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	@Column(length=30)
	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}


	@Column(length=20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}