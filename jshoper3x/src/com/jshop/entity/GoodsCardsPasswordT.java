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
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(name="GOODS_CARDS_ID", nullable=false, length=20)
	public String getGoodsCardsId() {
		return this.goodsCardsId;
	}

	public void setGoodsCardsId(String goodsCardsId) {
		this.goodsCardsId = goodsCardsId;
	}


	@Column(length=20)
	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	@Column(nullable=false, length=45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(nullable=false, length=1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}