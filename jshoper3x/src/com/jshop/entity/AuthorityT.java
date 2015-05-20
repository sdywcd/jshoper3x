package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the authority_t database table.
 * 
 */
@Entity
@Table(name="authority_t")
@NamedQuery(name="AuthorityT.findAll", query="SELECT a FROM AuthorityT a")
public class AuthorityT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String autid;
	private String chpagename;
	private Date createtime;
	private String enpagename;
	private String operate;
	private String roleid;

	public AuthorityT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getAutid() {
		return this.autid;
	}

	public void setAutid(String autid) {
		this.autid = autid;
	}


	@Column(nullable=false, length=45)
	public String getChpagename() {
		return this.chpagename;
	}

	public void setChpagename(String chpagename) {
		this.chpagename = chpagename;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false, length=100)
	public String getEnpagename() {
		return this.enpagename;
	}

	public void setEnpagename(String enpagename) {
		this.enpagename = enpagename;
	}


	@Column(nullable=false, length=1)
	public String getOperate() {
		return this.operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}


	@Column(length=20)
	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}