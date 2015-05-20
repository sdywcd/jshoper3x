package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the jshopbasic_info_t database table.
 * 
 */
@Entity
@Table(name="jshopbasic_info_t")
@NamedQuery(name="JshopbasicInfoT.findAll", query="SELECT j FROM JshopbasicInfoT j")
public class JshopbasicInfoT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String basicinfoid;
	private String city;
	private String country;
	private Date createtime;
	private String creatorid;
	private String district;
	private String emailservice;
	private String icpnum;
	private String jshopname;
	private String jshopslogan;
	private String licensed;
	private String metaDes;
	private String metaKeywords;
	private String openstate;
	private String phoneservice;
	private String province;
	private String qqservice;
	private String sinaweiboservice;
	private String siteclosenotes;
	private String sitelogo;
	private String skypeservice;
	private String state;
	private String street;
	private String weixinservice;

	public JshopbasicInfoT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getBasicinfoid() {
		return this.basicinfoid;
	}

	public void setBasicinfoid(String basicinfoid) {
		this.basicinfoid = basicinfoid;
	}


	@Column(length=12)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(length=12)
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


	@Column(nullable=false, length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(length=12)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	@Column(length=200)
	public String getEmailservice() {
		return this.emailservice;
	}

	public void setEmailservice(String emailservice) {
		this.emailservice = emailservice;
	}


	@Column(length=45)
	public String getIcpnum() {
		return this.icpnum;
	}

	public void setIcpnum(String icpnum) {
		this.icpnum = icpnum;
	}


	@Column(nullable=false, length=45)
	public String getJshopname() {
		return this.jshopname;
	}

	public void setJshopname(String jshopname) {
		this.jshopname = jshopname;
	}


	@Column(length=45)
	public String getJshopslogan() {
		return this.jshopslogan;
	}

	public void setJshopslogan(String jshopslogan) {
		this.jshopslogan = jshopslogan;
	}


	@Column(length=1)
	public String getLicensed() {
		return this.licensed;
	}

	public void setLicensed(String licensed) {
		this.licensed = licensed;
	}


	@Column(name="META_DES", length=255)
	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}


	@Column(name="META_KEYWORDS", length=255)
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	@Column(length=1)
	public String getOpenstate() {
		return this.openstate;
	}

	public void setOpenstate(String openstate) {
		this.openstate = openstate;
	}


	@Column(length=20)
	public String getPhoneservice() {
		return this.phoneservice;
	}

	public void setPhoneservice(String phoneservice) {
		this.phoneservice = phoneservice;
	}


	@Column(length=12)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	@Column(length=100)
	public String getQqservice() {
		return this.qqservice;
	}

	public void setQqservice(String qqservice) {
		this.qqservice = qqservice;
	}


	@Column(length=100)
	public String getSinaweiboservice() {
		return this.sinaweiboservice;
	}

	public void setSinaweiboservice(String sinaweiboservice) {
		this.sinaweiboservice = sinaweiboservice;
	}


	@Column(length=200)
	public String getSiteclosenotes() {
		return this.siteclosenotes;
	}

	public void setSiteclosenotes(String siteclosenotes) {
		this.siteclosenotes = siteclosenotes;
	}


	@Column(length=255)
	public String getSitelogo() {
		return this.sitelogo;
	}

	public void setSitelogo(String sitelogo) {
		this.sitelogo = sitelogo;
	}


	@Column(length=100)
	public String getSkypeservice() {
		return this.skypeservice;
	}

	public void setSkypeservice(String skypeservice) {
		this.skypeservice = skypeservice;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(length=50)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	@Column(length=100)
	public String getWeixinservice() {
		return this.weixinservice;
	}

	public void setWeixinservice(String weixinservice) {
		this.weixinservice = weixinservice;
	}

}