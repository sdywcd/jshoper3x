package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the payment_m database table.
 * 
 */
@Entity
@Table(name="payment_m")
@NamedQuery(name="PaymentM.findAll", query="SELECT p FROM PaymentM p")
public class PaymentM implements Serializable {
	private static final long serialVersionUID = 1L;
	private String paymentid;
	private String account;
	private String des;
	private String isFast;
	private String partnerid;
	private String paymentCode;
	private String paymentFree;
	private String paymentInterface;
	private String paymentname;
	private String safecode;
	private String shopid;
	private String shopname;
	private String state;

	public PaymentM() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getPaymentid() {
		return this.paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}


	@Column(length=100)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	@Column(length=200)
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	@Column(name="IS_FAST", length=1)
	public String getIsFast() {
		return this.isFast;
	}

	public void setIsFast(String isFast) {
		this.isFast = isFast;
	}


	@Column(length=128)
	public String getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}


	@Column(name="PAYMENT_CODE", length=20)
	public String getPaymentCode() {
		return this.paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}


	@Column(name="PAYMENT_FREE", length=20)
	public String getPaymentFree() {
		return this.paymentFree;
	}

	public void setPaymentFree(String paymentFree) {
		this.paymentFree = paymentFree;
	}


	@Column(name="PAYMENT_INTERFACE", length=1)
	public String getPaymentInterface() {
		return this.paymentInterface;
	}

	public void setPaymentInterface(String paymentInterface) {
		this.paymentInterface = paymentInterface;
	}


	@Column(length=45)
	public String getPaymentname() {
		return this.paymentname;
	}

	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}


	@Column(length=128)
	public String getSafecode() {
		return this.safecode;
	}

	public void setSafecode(String safecode) {
		this.safecode = safecode;
	}


	@Column(length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(length=45)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}