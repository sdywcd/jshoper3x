package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goodsstar_comment_t database table.
 * 
 */
@Entity
@Table(name="goodsstar_comment_t")
@NamedQuery(name="GoodsstarCommentT.findAll", query="SELECT g FROM GoodsstarCommentT g")
public class GoodsstarCommentT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String starcommentid;
	private Date createtime;
	private String goodsid;
	private String memberid;
	private int starnum;

	public GoodsstarCommentT() {
	}


	@Id
	public String getStarcommentid() {
		return this.starcommentid;
	}

	public void setStarcommentid(String starcommentid) {
		this.starcommentid = starcommentid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	public int getStarnum() {
		return this.starnum;
	}

	public void setStarnum(int starnum) {
		this.starnum = starnum;
	}

}