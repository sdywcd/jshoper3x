package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wexin_company_base_cp_t database table.
 * 
 */
@Entity
@Table(name="wexin_company_base_cp_t")
@NamedQuery(name="WexinCompanyBaseCpT.findAll", query="SELECT w FROM WexinCompanyBaseCpT w")
public class WexinCompanyBaseCpT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String companyname;
	private String corpid;
	private String corpsecret;
	private Date createtime;
	private String creatorid;
	private String encodingaeskey;
	private String mode;
	private String statue;
	private String token;
	private Date updatetime;
	private String url;

	public WexinCompanyBaseCpT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(nullable=false, length=100)
	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}


	@Column(nullable=false, length=45)
	public String getCorpid() {
		return this.corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}


	@Column(nullable=false, length=512)
	public String getCorpsecret() {
		return this.corpsecret;
	}

	public void setCorpsecret(String corpsecret) {
		this.corpsecret = corpsecret;
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


	@Column(nullable=false, length=45)
	public String getEncodingaeskey() {
		return this.encodingaeskey;
	}

	public void setEncodingaeskey(String encodingaeskey) {
		this.encodingaeskey = encodingaeskey;
	}


	@Column(nullable=false, length=45)
	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}


	@Column(nullable=false, length=1)
	public String getStatue() {
		return this.statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}


	@Column(nullable=false, length=32)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(nullable=false, length=256)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}