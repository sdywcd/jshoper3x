package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the role_m database table.
 * 
 */
@Entity
@Table(name="role_m")
@NamedQuery(name="RoleM.findAll", query="SELECT r FROM RoleM r")
public class RoleM implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String note;
	private String rolename;

	public RoleM() {
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


	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}