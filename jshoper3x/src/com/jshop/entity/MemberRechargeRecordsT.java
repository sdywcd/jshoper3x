package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the member_recharge_records_t database table.
 * 
 */
@Entity
@Table(name="member_recharge_records_t")
@NamedQuery(name="MemberRechargeRecordsT.findAll", query="SELECT m FROM MemberRechargeRecordsT m")
public class MemberRechargeRecordsT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String memberid;
	private String membername;
	private double money;
	private String shopid;
	private String type;

	public MemberRechargeRecordsT() {
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


	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}


	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}