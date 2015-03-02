package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the member_grade_t database table.
 * 
 */
@Entity
@Table(name="member_grade_t")
@NamedQuery(name="MemberGradeT.findAll", query="SELECT m FROM MemberGradeT m")
public class MemberGradeT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String creatorid;
	private double discount;
	private double end;
	private double increment;
	private double mpchangepower;
	private String mpstate;
	private double multiplypower;
	private String name;
	private double start;
	private String type;
	private Date updatetime;
	private int versiont;

	public MemberGradeT() {
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


	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public double getEnd() {
		return this.end;
	}

	public void setEnd(double end) {
		this.end = end;
	}


	public double getIncrement() {
		return this.increment;
	}

	public void setIncrement(double increment) {
		this.increment = increment;
	}


	public double getMpchangepower() {
		return this.mpchangepower;
	}

	public void setMpchangepower(double mpchangepower) {
		this.mpchangepower = mpchangepower;
	}


	public String getMpstate() {
		return this.mpstate;
	}

	public void setMpstate(String mpstate) {
		this.mpstate = mpstate;
	}


	public double getMultiplypower() {
		return this.multiplypower;
	}

	public void setMultiplypower(double multiplypower) {
		this.multiplypower = multiplypower;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getStart() {
		return this.start;
	}

	public void setStart(double start) {
		this.start = start;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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