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
	public String getBasicinfoid() {
		return this.basicinfoid;
	}

	public void setBasicinfoid(String basicinfoid) {
		this.basicinfoid = basicinfoid;
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


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	public String getEmailservice() {
		return this.emailservice;
	}

	public void setEmailservice(String emailservice) {
		this.emailservice = emailservice;
	}


	public String getIcpnum() {
		return this.icpnum;
	}

	public void setIcpnum(String icpnum) {
		this.icpnum = icpnum;
	}


	public String getJshopname() {
		return this.jshopname;
	}

	public void setJshopname(String jshopname) {
		this.jshopname = jshopname;
	}


	public String getJshopslogan() {
		return this.jshopslogan;
	}

	public void setJshopslogan(String jshopslogan) {
		this.jshopslogan = jshopslogan;
	}


	public String getLicensed() {
		return this.licensed;
	}

	public void setLicensed(String licensed) {
		this.licensed = licensed;
	}


	@Column(name="META_DES")
	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}


	@Column(name="META_KEYWORDS")
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	public String getOpenstate() {
		return this.openstate;
	}

	public void setOpenstate(String openstate) {
		this.openstate = openstate;
	}


	public String getPhoneservice() {
		return this.phoneservice;
	}

	public void setPhoneservice(String phoneservice) {
		this.phoneservice = phoneservice;
	}


	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	public String getQqservice() {
		return this.qqservice;
	}

	public void setQqservice(String qqservice) {
		this.qqservice = qqservice;
	}


	public String getSinaweiboservice() {
		return this.sinaweiboservice;
	}

	public void setSinaweiboservice(String sinaweiboservice) {
		this.sinaweiboservice = sinaweiboservice;
	}


	public String getSiteclosenotes() {
		return this.siteclosenotes;
	}

	public void setSiteclosenotes(String siteclosenotes) {
		this.siteclosenotes = siteclosenotes;
	}


	public String getSitelogo() {
		return this.sitelogo;
	}

	public void setSitelogo(String sitelogo) {
		this.sitelogo = sitelogo;
	}


	public String getSkypeservice() {
		return this.skypeservice;
	}

	public void setSkypeservice(String skypeservice) {
		this.skypeservice = skypeservice;
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


	public String getWeixinservice() {
		return this.weixinservice;
	}

	public void setWeixinservice(String weixinservice) {
		this.weixinservice = weixinservice;
	}

}