package com.jshop.entity;

// Generated 2013-3-22 15:24:47 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JshopbasicInfoT generated by hbm2java
 */
@Entity
@Table(name = "jshopbasic_info_t", catalog = "jshoper3")
public class JshopbasicInfoT implements java.io.Serializable {

	private String basicinfoid;
	private String jshopname;
	private String jshopslogan;
	private String country;
	private String province;
	private String city;
	private String street;
	private String qqservice;
	private String taobaowwservice;
	private String skypeservice;
	private String yahooservice;
	private String msnservice;
	private String emailservice;
	private String phoneservice;
	private String openstate;
	private String siteclosenotes;
	private String sitelogo;
	private String licensed;
	private String usercenternote;
	private String jshopnotice;
	private String registerclose;
	private String icpnum;
	private String sendName;
	private String sendCountry;
	private String sendProvince;
	private String sendCity;
	private String sendDistrict;
	private String sendStreet;
	private String sendTelno;
	private String sendMobile;
	private String sendContactor;
	private String state;
	private String district;
	private String creatorid;
	private Date createtime;
	private String metaKeywords;
	private String metaDes;

	public JshopbasicInfoT() {
	}

	public JshopbasicInfoT(String basicinfoid, String jshopname, String state, String creatorid, Date createtime) {
		this.basicinfoid = basicinfoid;
		this.jshopname = jshopname;
		this.state = state;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	public JshopbasicInfoT(String basicinfoid, String jshopname, String jshopslogan, String country, String province, String city, String street, String qqservice, String taobaowwservice, String skypeservice, String yahooservice, String msnservice, String emailservice, String phoneservice, String openstate, String siteclosenotes, String sitelogo, String licensed, String usercenternote, String jshopnotice, String registerclose, String icpnum, String sendName, String sendCountry, String sendProvince, String sendCity, String sendDistrict, String sendStreet, String sendTelno, String sendMobile, String sendContactor, String state, String district, String creatorid, Date createtime, String metaKeywords, String metaDes) {
		this.basicinfoid = basicinfoid;
		this.jshopname = jshopname;
		this.jshopslogan = jshopslogan;
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.qqservice = qqservice;
		this.taobaowwservice = taobaowwservice;
		this.skypeservice = skypeservice;
		this.yahooservice = yahooservice;
		this.msnservice = msnservice;
		this.emailservice = emailservice;
		this.phoneservice = phoneservice;
		this.openstate = openstate;
		this.siteclosenotes = siteclosenotes;
		this.sitelogo = sitelogo;
		this.licensed = licensed;
		this.usercenternote = usercenternote;
		this.jshopnotice = jshopnotice;
		this.registerclose = registerclose;
		this.icpnum = icpnum;
		this.sendName = sendName;
		this.sendCountry = sendCountry;
		this.sendProvince = sendProvince;
		this.sendCity = sendCity;
		this.sendDistrict = sendDistrict;
		this.sendStreet = sendStreet;
		this.sendTelno = sendTelno;
		this.sendMobile = sendMobile;
		this.sendContactor = sendContactor;
		this.state = state;
		this.district = district;
		this.creatorid = creatorid;
		this.createtime = createtime;
		this.metaKeywords = metaKeywords;
		this.metaDes = metaDes;
	}

	@Id
	@Column(name = "BASICINFOID", unique = true, nullable = false, length = 20)
	public String getBasicinfoid() {
		return this.basicinfoid;
	}

	public void setBasicinfoid(String basicinfoid) {
		this.basicinfoid = basicinfoid;
	}

	@Column(name = "JSHOPNAME", nullable = false, length = 45)
	public String getJshopname() {
		return this.jshopname;
	}

	public void setJshopname(String jshopname) {
		this.jshopname = jshopname;
	}

	@Column(name = "JSHOPSLOGAN", length = 45)
	public String getJshopslogan() {
		return this.jshopslogan;
	}

	public void setJshopslogan(String jshopslogan) {
		this.jshopslogan = jshopslogan;
	}

	@Column(name = "COUNTRY", length = 12)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "PROVINCE", length = 12)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "CITY", length = 12)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STREET", length = 50)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "QQSERVICE", length = 100)
	public String getQqservice() {
		return this.qqservice;
	}

	public void setQqservice(String qqservice) {
		this.qqservice = qqservice;
	}

	@Column(name = "TAOBAOWWSERVICE", length = 100)
	public String getTaobaowwservice() {
		return this.taobaowwservice;
	}

	public void setTaobaowwservice(String taobaowwservice) {
		this.taobaowwservice = taobaowwservice;
	}

	@Column(name = "SKYPESERVICE", length = 100)
	public String getSkypeservice() {
		return this.skypeservice;
	}

	public void setSkypeservice(String skypeservice) {
		this.skypeservice = skypeservice;
	}

	@Column(name = "YAHOOSERVICE", length = 100)
	public String getYahooservice() {
		return this.yahooservice;
	}

	public void setYahooservice(String yahooservice) {
		this.yahooservice = yahooservice;
	}

	@Column(name = "MSNSERVICE", length = 100)
	public String getMsnservice() {
		return this.msnservice;
	}

	public void setMsnservice(String msnservice) {
		this.msnservice = msnservice;
	}

	@Column(name = "EMAILSERVICE", length = 200)
	public String getEmailservice() {
		return this.emailservice;
	}

	public void setEmailservice(String emailservice) {
		this.emailservice = emailservice;
	}

	@Column(name = "PHONESERVICE", length = 200)
	public String getPhoneservice() {
		return this.phoneservice;
	}

	public void setPhoneservice(String phoneservice) {
		this.phoneservice = phoneservice;
	}

	@Column(name = "OPENSTATE", length = 1)
	public String getOpenstate() {
		return this.openstate;
	}

	public void setOpenstate(String openstate) {
		this.openstate = openstate;
	}

	@Column(name = "SITECLOSENOTES", length = 200)
	public String getSiteclosenotes() {
		return this.siteclosenotes;
	}

	public void setSiteclosenotes(String siteclosenotes) {
		this.siteclosenotes = siteclosenotes;
	}

	@Column(name = "SITELOGO", length = 500)
	public String getSitelogo() {
		return this.sitelogo;
	}

	public void setSitelogo(String sitelogo) {
		this.sitelogo = sitelogo;
	}

	@Column(name = "LICENSED", length = 1)
	public String getLicensed() {
		return this.licensed;
	}

	public void setLicensed(String licensed) {
		this.licensed = licensed;
	}

	@Column(name = "USERCENTERNOTE", length = 500)
	public String getUsercenternote() {
		return this.usercenternote;
	}

	public void setUsercenternote(String usercenternote) {
		this.usercenternote = usercenternote;
	}

	@Column(name = "JSHOPNOTICE", length = 500)
	public String getJshopnotice() {
		return this.jshopnotice;
	}

	public void setJshopnotice(String jshopnotice) {
		this.jshopnotice = jshopnotice;
	}

	@Column(name = "REGISTERCLOSE", length = 1)
	public String getRegisterclose() {
		return this.registerclose;
	}

	public void setRegisterclose(String registerclose) {
		this.registerclose = registerclose;
	}

	@Column(name = "ICPNUM", length = 45)
	public String getIcpnum() {
		return this.icpnum;
	}

	public void setIcpnum(String icpnum) {
		this.icpnum = icpnum;
	}

	@Column(name = "SEND_NAME", length = 45)
	public String getSendName() {
		return this.sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	@Column(name = "SEND_COUNTRY", length = 12)
	public String getSendCountry() {
		return this.sendCountry;
	}

	public void setSendCountry(String sendCountry) {
		this.sendCountry = sendCountry;
	}

	@Column(name = "SEND_PROVINCE", length = 12)
	public String getSendProvince() {
		return this.sendProvince;
	}

	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}

	@Column(name = "SEND_CITY", length = 12)
	public String getSendCity() {
		return this.sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}

	@Column(name = "SEND_DISTRICT", length = 12)
	public String getSendDistrict() {
		return this.sendDistrict;
	}

	public void setSendDistrict(String sendDistrict) {
		this.sendDistrict = sendDistrict;
	}

	@Column(name = "SEND_STREET", length = 100)
	public String getSendStreet() {
		return this.sendStreet;
	}

	public void setSendStreet(String sendStreet) {
		this.sendStreet = sendStreet;
	}

	@Column(name = "SEND_TELNO", length = 20)
	public String getSendTelno() {
		return this.sendTelno;
	}

	public void setSendTelno(String sendTelno) {
		this.sendTelno = sendTelno;
	}

	@Column(name = "SEND_MOBILE", length = 20)
	public String getSendMobile() {
		return this.sendMobile;
	}

	public void setSendMobile(String sendMobile) {
		this.sendMobile = sendMobile;
	}

	@Column(name = "SEND_CONTACTOR", length = 45)
	public String getSendContactor() {
		return this.sendContactor;
	}

	public void setSendContactor(String sendContactor) {
		this.sendContactor = sendContactor;
	}

	@Column(name = "STATE", nullable = false, length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "DISTRICT", length = 12)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "CREATORID", nullable = false, length = 20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATETIME", nullable = false, length = 0)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "META_KEYWORDS")
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	@Column(name = "META_DES")
	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

}