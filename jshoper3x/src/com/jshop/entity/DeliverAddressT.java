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
	public String getAddressid() {
		return this.addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	public String getShippingusername() {
		return this.shippingusername;
	}

	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

}