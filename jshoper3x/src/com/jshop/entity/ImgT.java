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
	@Column(name="IMG_ID", unique=true, nullable=false, length=20)
	public String getImgId() {
		return this.imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false, length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(length=100)
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	@Column(name="IMG_HREF", nullable=false, length=225)
	public String getImgHref() {
		return this.imgHref;
	}

	public void setImgHref(String imgHref) {
		this.imgHref = imgHref;
	}


	@Column(name="IMG_NAME", length=45)
	public String getImgName() {
		return this.imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	@Column(name="IMG_TYPE", length=10)
	public String getImgType() {
		return this.imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}


	@Column(name="IMG_TYPE_ID", length=20)
	public String getImgTypeId() {
		return this.imgTypeId;
	}

	public void setImgTypeId(String imgTypeId) {
		this.imgTypeId = imgTypeId;
	}


	@Column(name="IMG_TYPE_NAME", length=45)
	public String getImgTypeName() {
		return this.imgTypeName;
	}

	public void setImgTypeName(String imgTypeName) {
		this.imgTypeName = imgTypeName;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(name="USED_GOODSID", length=20)
	public String getUsedGoodsid() {
		return this.usedGoodsid;
	}

	public void setUsedGoodsid(String usedGoodsid) {
		this.usedGoodsid = usedGoodsid;
	}


	@Column(name="USED_GOODSNAME", length=100)
	public String getUsedGoodsname() {
		return this.usedGoodsname;
	}

	public void setUsedGoodsname(String usedGoodsname) {
		this.usedGoodsname = usedGoodsname;
	}


	@Column(name="USED_POSITION_ID", length=20)
	public String getUsedPositionId() {
		return this.usedPositionId;
	}

	public void setUsedPositionId(String usedPositionId) {
		this.usedPositionId = usedPositionId;
	}


	@Column(name="USED_POSITION_NAME", length=45)
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