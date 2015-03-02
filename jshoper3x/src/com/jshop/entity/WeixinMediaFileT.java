package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the weixin_media_file_t database table.
 * 
 */
@Entity
@Table(name="weixin_media_file_t")
@NamedQuery(name="WeixinMediaFileT.findAll", query="SELECT w FROM WeixinMediaFileT w")
public class WeixinMediaFileT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String creatorid;
	private String filename;
	private String filesize;
	private String jshoperxid;
	private String mediaId;
	private String shopid;
	private String status;
	private String type;
	private Date updatetime;

	public WeixinMediaFileT() {
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


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getFilesize() {
		return this.filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}


	public String getJshoperxid() {
		return this.jshoperxid;
	}

	public void setJshoperxid(String jshoperxid) {
		this.jshoperxid = jshoperxid;
	}


	@Column(name="MEDIA_ID")
	public String getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}