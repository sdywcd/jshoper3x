package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vouchers_t database table.
 * 
 */
@Entity
@Table(name="vouchers_t")
@NamedQuery(name="VouchersT.findAll", query="SELECT v FROM VouchersT v")
public class VouchersT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String vouchersid;
	private String begintime;
	private Date createtime;
	private String creatorid;
	private String endtime;
	private String givenmemberid;
	private double limitprice;
	private String mobilesync;
	private String state;
	private String voucherscontent;
	private String vouchersname;
	private String voucherstate;
	private String voucheruseway;

	public VouchersT() {
	}


	@Id
	public String getVouchersid() {
		return this.vouchersid;
	}

	public void setVouchersid(String vouchersid) {
		this.vouchersid = vouchersid;
	}


	public String getBegintime() {
		return this.begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	public String getGivenmemberid() {
		return this.givenmemberid;
	}

	public void setGivenmemberid(String givenmemberid) {
		this.givenmemberid = givenmemberid;
	}


	public double getLimitprice() {
		return this.limitprice;
	}

	public void setLimitprice(double limitprice) {
		this.limitprice = limitprice;
	}


	public String getMobilesync() {
		return this.mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getVoucherscontent() {
		return this.voucherscontent;
	}

	public void setVoucherscontent(String voucherscontent) {
		this.voucherscontent = voucherscontent;
	}


	public String getVouchersname() {
		return this.vouchersname;
	}

	public void setVouchersname(String vouchersname) {
		this.vouchersname = vouchersname;
	}


	public String getVoucherstate() {
		return this.voucherstate;
	}

	public void setVoucherstate(String voucherstate) {
		this.voucherstate = voucherstate;
	}


	public String getVoucheruseway() {
		return this.voucheruseway;
	}

	public void setVoucheruseway(String voucheruseway) {
		this.voucheruseway = voucheruseway;
	}

}