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
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getThemeid() {
		return this.themeid;
	}

	public void setThemeid(String themeid) {
		this.themeid = themeid;
	}


	public String getThemename() {
		return this.themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}


	@Lob
	public String getTvalue() {
		return this.tvalue;
	}

	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}