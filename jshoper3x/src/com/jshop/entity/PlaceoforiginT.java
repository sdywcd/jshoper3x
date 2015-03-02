package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the placeoforigin_t database table.
 * 
 */
@Entity
@Table(name="placeoforigin_t")
@NamedQuery(name="PlaceoforiginT.findAll", query="SELECT p FROM PlaceoforiginT p")
public class PlaceoforiginT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String placeid;
	private Date createtime;
	private String creatorid;
	private String grade;
	private String parentId;
	private String parentName;
	private String placename;
	private int sort;
	private Date updatetime;
	private int versiont;

	public PlaceoforiginT() {
	}


	@Id
	public String getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(String placeid) {
		this.placeid = placeid;
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


	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	@Column(name="PARENT_ID")
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	@Column(name="PARENT_NAME")
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getPlacename() {
		return this.placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
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