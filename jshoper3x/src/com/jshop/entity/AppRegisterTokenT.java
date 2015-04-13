package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the app_register_token_t database table.
 * 
 */
@Entity
@Table(name="app_register_token_t")
@NamedQuery(name="AppRegisterTokenT.findAll", query="SELECT a FROM AppRegisterTokenT a")
public class AppRegisterTokenT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aid;
	private Date createtime;
	private String memberid;
	private String token;
	private String uuid;

	public AppRegisterTokenT() {
	}


	@Id
	public String getAid() {
		return this.aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}