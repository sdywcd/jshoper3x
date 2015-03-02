package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the notice_t database table.
 * 
 */
@Entity
@Table(name="notice_t")
@NamedQuery(name="NoticeT.findAll", query="SELECT n FROM NoticeT n")
public class NoticeT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String noticeid;
	private String content;
	private Date createtime;
	private String creatorid;
	private String noticenlid;
	private String noticenlname;
	private String title;

	public NoticeT() {
	}


	@Id
	public String getNoticeid() {
		return this.noticeid;
	}

	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}


	@Lob
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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


	public String getNoticenlid() {
		return this.noticenlid;
	}

	public void setNoticenlid(String noticenlid) {
		this.noticenlid = noticenlid;
	}


	public String getNoticenlname() {
		return this.noticenlname;
	}

	public void setNoticenlname(String noticenlname) {
		this.noticenlname = noticenlname;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}