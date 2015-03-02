package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the system_mail_t database table.
 * 
 */
@Entity
@Table(name="system_mail_t")
@NamedQuery(name="SystemMailT.findAll", query="SELECT s FROM SystemMailT s")
public class SystemMailT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String creatorid;
	private String creatorname;
	private String email;
	private String isdefault;
	private String isssl;
	private String port;
	private String pwd;
	private String shopid;
	private String shopname;
	private String smtp;
	private String state;
	private Date updatetime;

	public SystemMailT() {
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


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	public String getCreatorname() {
		return this.creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}


	public String getIsssl() {
		return this.isssl;
	}

	public void setIsssl(String isssl) {
		this.isssl = isssl;
	}


	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}


	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	public String getSmtp() {
		return this.smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}