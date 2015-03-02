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
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="BASICSETTING_ID")
	public String getBasicsettingId() {
		return this.basicsettingId;
	}

	public void setBasicsettingId(String basicsettingId) {
		this.basicsettingId = basicsettingId;
	}


	@Column(name="BASICSETTING_SITENAME")
	public String getBasicsettingSitename() {
		return this.basicsettingSitename;
	}

	public void setBasicsettingSitename(String basicsettingSitename) {
		this.basicsettingSitename = basicsettingSitename;
	}


	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}


	public String getMobilesync() {
		return this.mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}


	public String getParentname() {
		return this.parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}


	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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


	public String getWxgivenid() {
		return this.wxgivenid;
	}

	public void setWxgivenid(String wxgivenid) {
		this.wxgivenid = wxgivenid;
	}

}