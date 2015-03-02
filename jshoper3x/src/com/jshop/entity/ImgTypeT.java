package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the img_type_t database table.
 * 
 */
@Entity
@Table(name="img_type_t")
@NamedQuery(name="ImgTypeT.findAll", query="SELECT i FROM ImgTypeT i")
public class ImgTypeT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String imgTypeId;
	private Date createtime;
	private String creatorid;
	private String imgTypeName;

	public ImgTypeT() {
	}


	@Id
	@Column(name="IMG_TYPE_ID")
	public String getImgTypeId() {
		return this.imgTypeId;
	}

	public void setImgTypeId(String imgTypeId) {
		this.imgTypeId = imgTypeId;
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


	@Column(name="IMG_TYPE_NAME")
	public String getImgTypeName() {
		return this.imgTypeName;
	}

	public void setImgTypeName(String imgTypeName) {
		this.imgTypeName = imgTypeName;
	}

}