package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the weixin_base_t database table.
 * 
 */
@Entity
@Table(name="weixin_base_t")
@NamedQuery(name="WeixinBaseT.findAll", query="SELECT w FROM WeixinBaseT w")
public class WeixinBaseT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String accessToken;
	private String account;
	private String appid;
	private Date createtime;
	private String creatorid;
	private String jshoperxid;
	private String secret;
	private String serviceAccount;
	private String shopid;
	private String status;
	private String token;
	private Date updatetime;
	private String url;

	public WeixinBaseT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="ACCESS_TOKEN")
	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getAppid() {
		return this.appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
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


	public String getJshoperxid() {
		return this.jshoperxid;
	}

	public void setJshoperxid(String jshoperxid) {
		this.jshoperxid = jshoperxid;
	}


	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}


	@Column(name="SERVICE_ACCOUNT")
	public String getServiceAccount() {
		return this.serviceAccount;
	}

	public void setServiceAccount(String serviceAccount) {
		this.serviceAccount = serviceAccount;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}