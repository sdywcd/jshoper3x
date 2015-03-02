package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the role_t database table.
 * 
 */
@Entity
@Table(name="role_t")
@NamedQuery(name="RoleT.findAll", query="SELECT r FROM RoleT r")
public class RoleT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String roleid;
	private Date createtime;
	private String creatorid;
	private String note;
	private String rolename;

	public RoleT() {
	}


	@Id
	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
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