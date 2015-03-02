package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the shipping_address_t database table.
 * 
 */
@Entity
@Table(name="shipping_address_t")
@NamedQuery(name="ShippingAddressT.findAll", query="SELECT s FROM ShippingAddressT s")
public class ShippingAddressT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String shippingaddressid;
	private String city;
	private String country;
	private Date createtime;
	private String deliveraddressid;
	private String district;
	private String email;
	private String issend;
	private String memberid;
	private String mobile;
	private String orderid;
	private String postcode;
	private String province;
	private String shippingusername;
	private String shopid;
	private String state;
	private String street;
	private String telno;

	public ShippingAddressT() {
	}


	@Id
	public String getShippingaddressid() {
		return this.shippingaddressid;
	}

	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
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


	public String getDeliveraddressid() {
		return this.deliveraddressid;
	}

	public void setDeliveraddressid(String deliveraddressid) {
		this.deliveraddressid = deliveraddressid;
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


	public String getIssend() {
		return this.issend;
	}

	public void setIssend(String issend) {
		this.issend = issend;
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


	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
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


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
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