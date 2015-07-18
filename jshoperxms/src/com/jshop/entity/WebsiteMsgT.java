package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the website_msg_t database table.
 * 
 */
@Entity
@Table(name="website_msg_t")
@NamedQuery(name="WebsiteMsgT.findAll", query="SELECT w FROM WebsiteMsgT w")
public class WebsiteMsgT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String msgid;
	private Date createtime;
	private String msgfromuserid;
	private String msgfromusrname;
	private String msgstate;
	private String msgtextid;
	private String msgtousername;
	private Date readtime;
	private String state;
	private String title;

	public WebsiteMsgT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getMsgid() {
		return this.msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
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
	public String getMsgfromuserid() {
		return this.msgfromuserid;
	}

	public void setMsgfromuserid(String msgfromuserid) {
		this.msgfromuserid = msgfromuserid;
	}


	@Column(nullable=false, length=50)
	public String getMsgfromusrname() {
		return this.msgfromusrname;
	}

	public void setMsgfromusrname(String msgfromusrname) {
		this.msgfromusrname = msgfromusrname;
	}


	@Column(nullable=false, length=1)
	public String getMsgstate() {
		return this.msgstate;
	}

	public void setMsgstate(String msgstate) {
		this.msgstate = msgstate;
	}


	@Column(nullable=false, length=20)
	public String getMsgtextid() {
		return this.msgtextid;
	}

	public void setMsgtextid(String msgtextid) {
		this.msgtextid = msgtextid;
	}


	@Column(nullable=false, length=50)
	public String getMsgtousername() {
		return this.msgtousername;
	}

	public void setMsgtousername(String msgtousername) {
		this.msgtousername = msgtousername;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getReadtime() {
		return this.readtime;
	}

	public void setReadtime(Date readtime) {
		this.readtime = readtime;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(nullable=false, length=50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}