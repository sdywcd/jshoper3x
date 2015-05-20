package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goods_group_attribute_rp_t database table.
 * 
 */
@Entity
@Table(name="goods_group_attribute_rp_t")
@NamedQuery(name="GoodsGroupAttributeRpT.findAll", query="SELECT g FROM GoodsGroupAttributeRpT g")
public class GoodsGroupAttributeRpT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String attrval;
	private String groupid;

	public GoodsGroupAttributeRpT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(nullable=false, length=45)
	public String getAttrval() {
		return this.attrval;
	}

	public void setAttrval(String attrval) {
		this.attrval = attrval;
	}


	@Column(nullable=false, length=20)
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

}