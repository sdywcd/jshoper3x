package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the department_structure_t database table.
 * 
 */
@Entity
@Table(name="department_structure_t")
@NamedQuery(name="DepartmentStructureT.findAll", query="SELECT d FROM DepartmentStructureT d")
public class DepartmentStructureT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String basicsettingId;
	private String basicsettingSitename;
	private String code;
	private Date createtime;
	private String grade;
	private String logo;
	private String mobilesync;
	private String name;
	private String parentid;
	private String parentname;
	private String path;
	private int sort;
	private String status;
	private Date updatetime;
	private int versiont;
	private String wxgivenid;

	public DepartmentStructureT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="BASICSETTING_ID", length=20)
	public String getBasicsettingId() {
		return this.basicsettingId;
	}

	public void setBasicsettingId(String basicsettingId) {
		this.basicsettingId = basicsettingId;
	}


	@Column(name="BASICSETTING_SITENAME", length=45)
	public String getBasicsettingSitename() {
		return this.basicsettingSitename;
	}

	public void setBasicsettingSitename(String basicsettingSitename) {
		this.basicsettingSitename = basicsettingSitename;
	}


	@Column(length=45)
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


	@Column(nullable=false, length=1)
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	@Column(nullable=false, length=255)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}


	@Column(nullable=false, length=1)
	public String getMobilesync() {
		return this.mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}


	@Column(nullable=false, length=60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=10)
	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}


	@Column(nullable=false, length=60)
	public String getParentname() {
		return this.parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}


	@Column(nullable=false, length=200)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	@Column(nullable=false)
	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	@Column(nullable=false, length=45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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


	@Column(length=10)
	public String getWxgivenid() {
		return this.wxgivenid;
	}

	public void setWxgivenid(String wxgivenid) {
		this.wxgivenid = wxgivenid;
	}

}