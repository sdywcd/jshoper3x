package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the member_location_t database table.
 * 
 */
@Entity
@Table(name="member_location_t")
@NamedQuery(name="MemberLocationT.findAll", query="SELECT m FROM MemberLocationT m")
public class MemberLocationT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String lid;
	private String address;
	private Date createtime;
	private double lat;
	private double lng;
	private String memberid;
	private Date updatetime;
	private int versiont;

	public MemberLocationT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getLid() {
		return this.lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}


	@Column(nullable=false, length=255)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false)
	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}


	@Column(nullable=false)
	public double getLng() {
		return this.lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}


	@Column(nullable=false, length=20)
	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
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