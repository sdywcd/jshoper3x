package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the templateset_t database table.
 * 
 */
@Entity
@Table(name="templateset_t")
@NamedQuery(name="TemplatesetT.findAll", query="SELECT t FROM TemplatesetT t")
public class TemplatesetT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tsid;
	private String buildhtmlpath;
	private Date createtime;
	private String creatorid;
	private String sign;
	private String status;
	private String systemcontent;
	private String templateurl;
	private String themeid;
	private String themename;

	public TemplatesetT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getTsid() {
		return this.tsid;
	}

	public void setTsid(String tsid) {
		this.tsid = tsid;
	}


	@Column(nullable=false, length=255)
	public String getBuildhtmlpath() {
		return this.buildhtmlpath;
	}

	public void setBuildhtmlpath(String buildhtmlpath) {
		this.buildhtmlpath = buildhtmlpath;
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
	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


	@Column(length=1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(nullable=false, length=45)
	public String getSystemcontent() {
		return this.systemcontent;
	}

	public void setSystemcontent(String systemcontent) {
		this.systemcontent = systemcontent;
	}


	@Column(nullable=false, length=255)
	public String getTemplateurl() {
		return this.templateurl;
	}

	public void setTemplateurl(String templateurl) {
		this.templateurl = templateurl;
	}


	@Column(length=20)
	public String getThemeid() {
		return this.themeid;
	}

	public void setThemeid(String themeid) {
		this.themeid = themeid;
	}


	@Column(length=45)
	public String getThemename() {
		return this.themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}

}