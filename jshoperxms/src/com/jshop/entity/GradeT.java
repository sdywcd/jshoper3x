package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the grade_t database table.
 * 
 */
@Entity
@Table(name="grade_t")
@NamedQuery(name="GradeT.findAll", query="SELECT g FROM GradeT g")
public class GradeT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String gradeid;
	private Date createtime;
	private String creatorid;
	private double discount;
	private String gradename;
	private String gradevalue;
	private double needcost;

	public GradeT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getGradeid() {
		return this.gradeid;
	}

	public void setGradeid(String gradeid) {
		this.gradeid = gradeid;
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


	@Column(nullable=false)
	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	@Column(nullable=false, length=45)
	public String getGradename() {
		return this.gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}


	@Column(length=1)
	public String getGradevalue() {
		return this.gradevalue;
	}

	public void setGradevalue(String gradevalue) {
		this.gradevalue = gradevalue;
	}


	@Column(nullable=false)
	public double getNeedcost() {
		return this.needcost;
	}

	public void setNeedcost(double needcost) {
		this.needcost = needcost;
	}

}