package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the app_post_token_t database table.
 * 
 */
@Entity
@Table(name="app_post_token_t")
@NamedQuery(name="AppPostTokenT.findAll", query="SELECT a FROM AppPostTokenT a")
public class AppPostTokenT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aid;
	private Date createtime;
	private String memberid;
	private String uuid;

	public AppPostTokenT() {
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


	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}