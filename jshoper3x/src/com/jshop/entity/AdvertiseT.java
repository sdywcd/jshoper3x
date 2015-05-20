package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the advertise_t database table.
 * 
 */
@Entity
@Table(name="advertise_t")
@NamedQuery(name="AdvertiseT.findAll", query="SELECT a FROM AdvertiseT a")
public class AdvertiseT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String advPath;
	private String alt;
	private Date begintime;
	private String code;
	private Date createtime;
	private String creatorid;
	private Date endtime;
	private int height;
	private String showTag;
	private String showWhere;
	private int sort;
	private String state;
	private String type;
	private int versiont;
	private int width;

	public AdvertiseT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="ADV_PATH", nullable=false, length=255)
	public String getAdvPath() {
		return this.advPath;
	}

	public void setAdvPath(String advPath) {
		this.advPath = advPath;
	}


	@Column(nullable=false, length=100)
	public String getAlt() {
		return this.alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}


	@Column(length=10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}


	@Column(nullable=false)
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	@Column(name="SHOW_TAG", nullable=false, length=20)
	public String getShowTag() {
		return this.showTag;
	}

	public void setShowTag(String showTag) {
		this.showTag = showTag;
	}


	@Column(name="SHOW_WHERE", nullable=false, length=1)
	public String getShowWhere() {
		return this.showWhere;
	}

	public void setShowWhere(String showWhere) {
		this.showWhere = showWhere;
	}


	@Column(nullable=false)
	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(nullable=false, length=1)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Column(nullable=false)
	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}


	@Column(nullable=false)
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}