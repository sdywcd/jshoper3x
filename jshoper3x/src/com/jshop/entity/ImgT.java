package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the img_t database table.
 * 
 */
@Entity
@Table(name="img_t")
@NamedQuery(name="ImgT.findAll", query="SELECT i FROM ImgT i")
public class ImgT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String imgId;
	private Date createtime;
	private String creatorid;
	private String des;
	private String imgHref;
	private String imgName;
	private String imgType;
	private String imgTypeId;
	private String imgTypeName;
	private String state;
	private String usedGoodsid;
	private String usedGoodsname;
	private String usedPositionId;
	private String usedPositionName;
	private int versiont;

	public ImgT() {
	}


	@Id
	@Column(name="IMG_ID")
	public String getImgId() {
		return this.imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
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


	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	@Column(name="IMG_HREF")
	public String getImgHref() {
		return this.imgHref;
	}

	public void setImgHref(String imgHref) {
		this.imgHref = imgHref;
	}


	@Column(name="IMG_NAME")
	public String getImgName() {
		return this.imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	@Column(name="IMG_TYPE")
	public String getImgType() {
		return this.imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}


	@Column(name="IMG_TYPE_ID")
	public String getImgTypeId() {
		return this.imgTypeId;
	}

	public void setImgTypeId(String imgTypeId) {
		this.imgTypeId = imgTypeId;
	}


	@Column(name="IMG_TYPE_NAME")
	public String getImgTypeName() {
		return this.imgTypeName;
	}

	public void setImgTypeName(String imgTypeName) {
		this.imgTypeName = imgTypeName;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(name="USED_GOODSID")
	public String getUsedGoodsid() {
		return this.usedGoodsid;
	}

	public void setUsedGoodsid(String usedGoodsid) {
		this.usedGoodsid = usedGoodsid;
	}


	@Column(name="USED_GOODSNAME")
	public String getUsedGoodsname() {
		return this.usedGoodsname;
	}

	public void setUsedGoodsname(String usedGoodsname) {
		this.usedGoodsname = usedGoodsname;
	}


	@Column(name="USED_POSITION_ID")
	public String getUsedPositionId() {
		return this.usedPositionId;
	}

	public void setUsedPositionId(String usedPositionId) {
		this.usedPositionId = usedPositionId;
	}


	@Column(name="USED_POSITION_NAME")
	public String getUsedPositionName() {
		return this.usedPositionName;
	}

	public void setUsedPositionName(String usedPositionName) {
		this.usedPositionName = usedPositionName;
	}


	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}