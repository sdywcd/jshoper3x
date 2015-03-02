package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the outside_goods_t database table.
 * 
 */
@Entity
@Table(name="outside_goods_t")
@NamedQuery(name="OutsideGoodsT.findAll", query="SELECT o FROM OutsideGoodsT o")
public class OutsideGoodsT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String creatorid;
	private String fname;
	private String goodsname;
	private String linkUrl;
	private String lname;
	private String ltypeid;
	private String navid;
	private String nname;
	private String pictureurl;
	private String salestate;
	private String sname;
	private int sort;
	private String stypeid;
	private Date updatetime;
	private int versiont;

	public OutsideGoodsT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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


	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	@Column(name="LINK_URL")
	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}


	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getLtypeid() {
		return this.ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}


	public String getNavid() {
		return this.navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}


	public String getNname() {
		return this.nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}


	public String getPictureurl() {
		return this.pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}


	public String getSalestate() {
		return this.salestate;
	}

	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}


	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getStypeid() {
		return this.stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}