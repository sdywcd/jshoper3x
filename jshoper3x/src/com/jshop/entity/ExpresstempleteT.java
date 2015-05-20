package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the expresstemplete_t database table.
 * 
 */
@Entity
@Table(name="expresstemplete_t")
@NamedQuery(name="ExpresstempleteT.findAll", query="SELECT e FROM ExpresstempleteT e")
public class ExpresstempleteT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String expresstempleteid;
	private String day;
	private String expressCss;
	private String expressImg;
	private String hour;
	private String kindeditorCode;
	private String logisticsid;
	private String minutes;
	private String month;
	private String notes;
	private String orderid;
	private String quantity;
	private String recipientCity;
	private String recipientContactor;
	private String recipientCountry;
	private String recipientDistrict;
	private String recipientMobile;
	private String recipientName;
	private String recipientPostcode;
	private String recipientProvince;
	private String recipientStreet;
	private String recipientTelno;
	private String rightTag;
	private String sendCity;
	private String sendContactor;
	private String sendCountry;
	private String sendDistrict;
	private String sendMobile;
	private String sendName;
	private String sendProvince;
	private String sendStreet;
	private String sendTelno;
	private String sendTime;
	private String state;
	private String year;

	public ExpresstempleteT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getExpresstempleteid() {
		return this.expresstempleteid;
	}

	public void setExpresstempleteid(String expresstempleteid) {
		this.expresstempleteid = expresstempleteid;
	}


	@Column(length=20)
	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}


	@Column(name="EXPRESS_CSS", length=500)
	public String getExpressCss() {
		return this.expressCss;
	}

	public void setExpressCss(String expressCss) {
		this.expressCss = expressCss;
	}


	@Column(name="EXPRESS_IMG", length=255)
	public String getExpressImg() {
		return this.expressImg;
	}

	public void setExpressImg(String expressImg) {
		this.expressImg = expressImg;
	}


	@Column(length=20)
	public String getHour() {
		return this.hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}


	@Lob
	@Column(name="KINDEDITOR_CODE")
	public String getKindeditorCode() {
		return this.kindeditorCode;
	}

	public void setKindeditorCode(String kindeditorCode) {
		this.kindeditorCode = kindeditorCode;
	}


	@Column(length=20)
	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	@Column(length=20)
	public String getMinutes() {
		return this.minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}


	@Column(length=20)
	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}


	@Column(length=20)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}


	@Column(length=20)
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	@Column(length=20)
	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	@Column(name="RECIPIENT_CITY", length=20)
	public String getRecipientCity() {
		return this.recipientCity;
	}

	public void setRecipientCity(String recipientCity) {
		this.recipientCity = recipientCity;
	}


	@Column(name="RECIPIENT_CONTACTOR", length=20)
	public String getRecipientContactor() {
		return this.recipientContactor;
	}

	public void setRecipientContactor(String recipientContactor) {
		this.recipientContactor = recipientContactor;
	}


	@Column(name="RECIPIENT_COUNTRY", length=20)
	public String getRecipientCountry() {
		return this.recipientCountry;
	}

	public void setRecipientCountry(String recipientCountry) {
		this.recipientCountry = recipientCountry;
	}


	@Column(name="RECIPIENT_DISTRICT", length=20)
	public String getRecipientDistrict() {
		return this.recipientDistrict;
	}

	public void setRecipientDistrict(String recipientDistrict) {
		this.recipientDistrict = recipientDistrict;
	}


	@Column(name="RECIPIENT_MOBILE", length=20)
	public String getRecipientMobile() {
		return this.recipientMobile;
	}

	public void setRecipientMobile(String recipientMobile) {
		this.recipientMobile = recipientMobile;
	}


	@Column(name="RECIPIENT_NAME", length=20)
	public String getRecipientName() {
		return this.recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}


	@Column(name="RECIPIENT_POSTCODE", length=20)
	public String getRecipientPostcode() {
		return this.recipientPostcode;
	}

	public void setRecipientPostcode(String recipientPostcode) {
		this.recipientPostcode = recipientPostcode;
	}


	@Column(name="RECIPIENT_PROVINCE", length=20)
	public String getRecipientProvince() {
		return this.recipientProvince;
	}

	public void setRecipientProvince(String recipientProvince) {
		this.recipientProvince = recipientProvince;
	}


	@Column(name="RECIPIENT_STREET", length=20)
	public String getRecipientStreet() {
		return this.recipientStreet;
	}

	public void setRecipientStreet(String recipientStreet) {
		this.recipientStreet = recipientStreet;
	}


	@Column(name="RECIPIENT_TELNO", length=20)
	public String getRecipientTelno() {
		return this.recipientTelno;
	}

	public void setRecipientTelno(String recipientTelno) {
		this.recipientTelno = recipientTelno;
	}


	@Column(name="RIGHT_TAG", length=20)
	public String getRightTag() {
		return this.rightTag;
	}

	public void setRightTag(String rightTag) {
		this.rightTag = rightTag;
	}


	@Column(name="SEND_CITY", length=20)
	public String getSendCity() {
		return this.sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}


	@Column(name="SEND_CONTACTOR", length=20)
	public String getSendContactor() {
		return this.sendContactor;
	}

	public void setSendContactor(String sendContactor) {
		this.sendContactor = sendContactor;
	}


	@Column(name="SEND_COUNTRY", length=20)
	public String getSendCountry() {
		return this.sendCountry;
	}

	public void setSendCountry(String sendCountry) {
		this.sendCountry = sendCountry;
	}


	@Column(name="SEND_DISTRICT", length=20)
	public String getSendDistrict() {
		return this.sendDistrict;
	}

	public void setSendDistrict(String sendDistrict) {
		this.sendDistrict = sendDistrict;
	}


	@Column(name="SEND_MOBILE", length=20)
	public String getSendMobile() {
		return this.sendMobile;
	}

	public void setSendMobile(String sendMobile) {
		this.sendMobile = sendMobile;
	}


	@Column(name="SEND_NAME", length=45)
	public String getSendName() {
		return this.sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}


	@Column(name="SEND_PROVINCE", length=20)
	public String getSendProvince() {
		return this.sendProvince;
	}

	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}


	@Column(name="SEND_STREET", length=20)
	public String getSendStreet() {
		return this.sendStreet;
	}

	public void setSendStreet(String sendStreet) {
		this.sendStreet = sendStreet;
	}


	@Column(name="SEND_TELNO", length=20)
	public String getSendTelno() {
		return this.sendTelno;
	}

	public void setSendTelno(String sendTelno) {
		this.sendTelno = sendTelno;
	}


	@Column(name="SEND_TIME", length=20)
	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}


	@Column(length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(length=20)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}