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
	public String getPaymentid() {
		return this.paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}


	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	@Column(name="IS_FAST")
	public String getIsFast() {
		return this.isFast;
	}

	public void setIsFast(String isFast) {
		this.isFast = isFast;
	}


	public String getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}


	@Column(name="PAYMENT_CODE")
	public String getPaymentCode() {
		return this.paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}


	@Column(name="PAYMENT_FREE")
	public String getPaymentFree() {
		return this.paymentFree;
	}

	public void setPaymentFree(String paymentFree) {
		this.paymentFree = paymentFree;
	}


	@Column(name="PAYMENT_INTERFACE")
	public String getPaymentInterface() {
		return this.paymentInterface;
	}

	public void setPaymentInterface(String paymentInterface) {
		this.paymentInterface = paymentInterface;
	}


	public String getPaymentname() {
		return this.paymentname;
	}

	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}


	public String getSafecode() {
		return this.safecode;
	}

	public void setSafecode(String safecode) {
		this.safecode = safecode;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}