package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location_t database table.
 * 
 */
@Entity
@Table(name="location_t")
@NamedQuery(name="LocationT.findAll", query="SELECT l FROM LocationT l")
public class LocationT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String lid;
	private double lat;
	private double lng;
	private String userid;
	private String username;
	private int versiont;
	private int zoom;

	public LocationT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getLid() {
		return this.lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
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
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Column(nullable=false, length=50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Column(nullable=false)
	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}


	@Column(nullable=false)
	public int getZoom() {
		return this.zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

}