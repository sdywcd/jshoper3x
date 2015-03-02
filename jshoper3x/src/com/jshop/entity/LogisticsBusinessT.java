package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the logistics_business_t database table.
 * 
 */
@Entity
@Table(name="logistics_business_t")
@NamedQuery(name="LogisticsBusinessT.findAll", query="SELECT l FROM LogisticsBusinessT l")
public class LogisticsBusinessT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String logisticsid;
	private String address;
	private String bankaccount;
	private String bankaddress;
	private String city;
	private String contractor;
	private Date createtime;
	private String creatorid;
	private String des;
	private String email;
	private String faxno;
	private String insure;
	private String isCod;
	private String logisticsname;
	private String mobile;
	private String receiver;
	private String sendrange;
	private String state;
	private String telno;
	private String visible;
	private String website;

	public LogisticsBusinessT() {
	}


	@Id
	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getBankaccount() {
		return this.bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}


	public String getBankaddress() {
		return this.bankaddress;
	}

	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getContractor() {
		return this.contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
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


	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFaxno() {
		return this.faxno;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}


	public String getInsure() {
		return this.insure;
	}

	public void setInsure(String insure) {
		this.insure = insure;
	}


	@Column(name="IS_COD")
	public String getIsCod() {
		return this.isCod;
	}

	public void setIsCod(String isCod) {
		this.isCod = isCod;
	}


	public String getLogisticsname() {
		return this.logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}


	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getSendrange() {
		return this.sendrange;
	}

	public void setSendrange(String sendrange) {
		this.sendrange = sendrange;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}


	public String getVisible() {
		return this.visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}


	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}