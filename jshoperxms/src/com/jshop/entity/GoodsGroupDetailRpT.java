package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goods_group_detail_rp_t database table.
 * 
 */
@Entity
@Table(name="goods_group_detail_rp_t")
@NamedQuery(name="GoodsGroupDetailRpT.findAll", query="SELECT g FROM GoodsGroupDetailRpT g")
public class GoodsGroupDetailRpT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String detail;
	private String groupid;

	public GoodsGroupDetailRpT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Lob
	@Column(nullable=false)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Column(nullable=false, length=20)
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

}