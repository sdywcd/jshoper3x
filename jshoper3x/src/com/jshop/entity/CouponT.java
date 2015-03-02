package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the coupon_t database table.
 * 
 */
@Entity
@Table(name="coupon_t")
@NamedQuery(name="CouponT.findAll", query="SELECT c FROM CouponT c")
public class CouponT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cid;
	private Date begintime;
	private String cimage;
	private String coupontypeid;
	private String coupontypename;
	private Date createtime;
	private String creatorid;
	private String ctitle;
	private String details;
	private Date endtime;
	private int gousersum;
	private double lat;
	private double lng;
	private Date modifytime;
	private int readcount;
	private int replycount;
	private int starsum;
	private int starusersum;
	private int zoom;

	public CouponT() {
	}


	@Id
	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}


	public String getCimage() {
		return this.cimage;
	}

	public void setCimage(String cimage) {
		this.cimage = cimage;
	}


	public String getCoupontypeid() {
		return this.coupontypeid;
	}

	public void setCoupontypeid(String coupontypeid) {
		this.coupontypeid = coupontypeid;
	}


	public String getCoupontypename() {
		return this.coupontypename;
	}

	public void setCoupontypename(String coupontypename) {
		this.coupontypename = coupontypename;
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


	public String getCtitle() {
		return this.ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}


	@Lob
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}


	public int getGousersum() {
		return this.gousersum;
	}

	public void setGousersum(int gousersum) {
		this.gousersum = gousersum;
	}


	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLng() {
		return this.lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}


	public int getReadcount() {
		return this.readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	public int getReplycount() {
		return this.replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}


	public int getStarsum() {
		return this.starsum;
	}

	public void setStarsum(int starsum) {
		this.starsum = starsum;
	}


	public int getStarusersum() {
		return this.starusersum;
	}

	public void setStarusersum(int starusersum) {
		this.starusersum = starusersum;
	}


	public int getZoom() {
		return this.zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

}