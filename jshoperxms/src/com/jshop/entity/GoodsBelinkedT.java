package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_belinked_t database table.
 * 
 */
@Entity
@Table(name="goods_belinked_t")
@NamedQuery(name="GoodsBelinkedT.findAll", query="SELECT g FROM GoodsBelinkedT g")
public class GoodsBelinkedT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String belinkedproductinfo;
	private Date createtime;
	private String creatorid;
	private String maingoodsid;
	private String maingoodsname;
	private String mainproductid;
	private String mode;
	private String shopid;
	private String state;
	private String sxlinkedgoodsid;
	private Date updatetime;
	private int versiont;

	public GoodsBelinkedT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(nullable=false, length=5000)
	public String getBelinkedproductinfo() {
		return this.belinkedproductinfo;
	}

	public void setBelinkedproductinfo(String belinkedproductinfo) {
		this.belinkedproductinfo = belinkedproductinfo;
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


	@Column(nullable=false, length=20)
	public String getMaingoodsid() {
		return this.maingoodsid;
	}

	public void setMaingoodsid(String maingoodsid) {
		this.maingoodsid = maingoodsid;
	}


	@Column(nullable=false, length=200)
	public String getMaingoodsname() {
		return this.maingoodsname;
	}

	public void setMaingoodsname(String maingoodsname) {
		this.maingoodsname = maingoodsname;
	}


	@Column(length=20)
	public String getMainproductid() {
		return this.mainproductid;
	}

	public void setMainproductid(String mainproductid) {
		this.mainproductid = mainproductid;
	}


	@Column(nullable=false, length=1)
	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}


	@Column(length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(nullable=false, length=20)
	public String getSxlinkedgoodsid() {
		return this.sxlinkedgoodsid;
	}

	public void setSxlinkedgoodsid(String sxlinkedgoodsid) {
		this.sxlinkedgoodsid = sxlinkedgoodsid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(nullable=false)
	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}