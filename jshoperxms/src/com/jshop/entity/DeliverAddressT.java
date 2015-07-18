package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the deliver_address_t database table.
 * 
 */
@Entity
@Table(name="deliver_address_t")
@NamedQuery(name="DeliverAddressT.findAll", query="SELECT d FROM DeliverAddressT d")
public class DeliverAddressT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String addressid;
	private String city;
	private String country;
	private Date createtime;
	private String district;
	private String email;
	private String memberid;
	private String mobile;
	private String postcode;
	private String province;
	private String shippingusername;
	private String state;
	private String street;
	private String telno;

	public DeliverAddressT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getAddressid() {
		return this.addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}


	@Column(nullable=false, length=12)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(nullable=false, length=20)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false, length=12)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	@Column(length=100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(nullable=false, length=20)
	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	@Column(nullable=false, length=20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Column(nullable=false, length=10)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	@Column(nullable=false, length=12)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	@Column(nullable=false, length=45)
	public String getShippingusername() {
		return this.shippingusername;
	}

	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(nullable=false, length=100)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	@Column(length=20)
	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

}