package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the templatetheme_t database table.
 * 
 */
@Entity
@Table(name="templatetheme_t")
@NamedQuery(name="TemplatethemeT.findAll", query="SELECT t FROM TemplatethemeT t")
public class TemplatethemeT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ttid;
	private Date createtime;
	private String creatorid;
	private String note;
	private String sign;
	private String status;
	private String themename;

	public TemplatethemeT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getTtid() {
		return this.ttid;
	}

	public void setTtid(String ttid) {
		this.ttid = ttid;
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
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	@Column(nullable=false, length=100)
	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


	@Column(nullable=false, length=1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(nullable=false, length=45)
	public String getThemename() {
		return this.themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}

}