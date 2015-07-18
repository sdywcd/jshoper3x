package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the virtual_shipping_address_t database table.
 * 
 */
@Entity
@Table(name="virtual_shipping_address_t")
@NamedQuery(name="VirtualShippingAddressT.findAll", query="SELECT v FROM VirtualShippingAddressT v")
public class VirtualShippingAddressT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String virtualshippingaddressid;
	private Date createtime;
	private String email;
	private String issend;
	private String mobile;
	private String orderid;
	private Date sendtime;
	private String state;
	private Date updatetime;
	private String userid;
	private String username;

	public VirtualShippingAddressT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=45)
	public String getVirtualshippingaddressid() {
		return this.virtualshippingaddressid;
	}

	public void setVirtualshippingaddressid(String virtualshippingaddressid) {
		this.virtualshippingaddressid = virtualshippingaddressid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false, length=100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(nullable=false, length=1)
	public String getIssend() {
		return this.issend;
	}

	public void setIssend(String issend) {
		this.issend = issend;
	}


	@Column(nullable=false, length=20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Column(nullable=false, length=20)
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(nullable=false, length=20)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Column(nullable=false, length=50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}