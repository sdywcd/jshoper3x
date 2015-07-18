package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goodsunit_t database table.
 * 
 */
@Entity
@Table(name="goodsunit_t")
@NamedQuery(name="GoodsunitT.findAll", query="SELECT g FROM GoodsunitT g")
public class GoodsunitT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String unitid;
	private Date createtime;
	private String creatorid;
	private String engunitname;
	private String unitname;

	public GoodsunitT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getUnitid() {
		return this.unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
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


	@Column(length=20)
	public String getEngunitname() {
		return this.engunitname;
	}

	public void setEngunitname(String engunitname) {
		this.engunitname = engunitname;
	}


	@Column(nullable=false, length=45)
	public String getUnitname() {
		return this.unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

}