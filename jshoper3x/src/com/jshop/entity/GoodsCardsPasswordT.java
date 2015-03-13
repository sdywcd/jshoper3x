package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_cards_password_t database table.
 * 
 */
@Entity
@Table(name="goods_cards_password_t")
@NamedQuery(name="GoodsCardsPasswordT.findAll", query="SELECT g FROM GoodsCardsPasswordT g")
public class GoodsCardsPasswordT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String goodsCardsId;
	private String memberid;
	private String password;
	private String status;
	private Date updatetime;

	public GoodsCardsPasswordT() {
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


	@Column(name="GOODS_CARDS_ID")
	public String getGoodsCardsId() {
		return this.goodsCardsId;
	}

	public void setGoodsCardsId(String goodsCardsId) {
		this.goodsCardsId = goodsCardsId;
	}


	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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