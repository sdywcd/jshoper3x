package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the logistics_business_shop_rp_t database table.
 * 
 */
@Entity
@Table(name="logistics_business_shop_rp_t")
@NamedQuery(name="LogisticsBusinessShopRpT.findAll", query="SELECT l FROM LogisticsBusinessShopRpT l")
public class LogisticsBusinessShopRpT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String logisticsid;
	private String logisticsname;
	private String shopid;
	private String shopname;
	private String status;
	private Date updatetime;

	public LogisticsBusinessShopRpT() {
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


	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}


	public String getLogisticsname() {
		return this.logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
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


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}