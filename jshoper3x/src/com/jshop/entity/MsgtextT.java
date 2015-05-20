package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the msgtext_t database table.
 * 
 */
@Entity
@Table(name="msgtext_t")
@NamedQuery(name="MsgtextT.findAll", query="SELECT m FROM MsgtextT m")
public class MsgtextT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String msgtextid;
	private Date sendtime;
	private String text;

	public MsgtextT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getMsgtextid() {
		return this.msgtextid;
	}

	public void setMsgtextid(String msgtextid) {
		this.msgtextid = msgtextid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}


	@Column(nullable=false, length=2000)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}