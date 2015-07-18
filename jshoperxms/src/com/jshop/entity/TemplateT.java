package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the template_t database table.
 * 
 */
@Entity
@Table(name="template_t")
@NamedQuery(name="TemplateT.findAll", query="SELECT t FROM TemplateT t")
public class TemplateT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tid;
	private Date createtime;
	private String creatorid;
	private String name;
	private String note;
	private String sign;
	private String status;
	private String themeid;
	private String themename;
	private String tvalue;
	private String type;
	private String url;

	public TemplateT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=100)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	@Column(length=100)
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


	@Lob
	@Column(nullable=false)
	public String getTvalue() {
		return this.tvalue;
	}

	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}


	@Column(length=1)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Column(nullable=false, length=255)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}