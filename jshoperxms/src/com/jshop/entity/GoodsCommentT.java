package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_comment_t database table.
 * 
 */
@Entity
@Table(name="goods_comment_t")
@NamedQuery(name="GoodsCommentT.findAll", query="SELECT g FROM GoodsCommentT g")
public class GoodsCommentT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String commentid;
	private String commentcontent;
	private String emailable;
	private String goodsid;
	private String goodsname;
	private Date posttime;
	private String replyid;
	private String replyorcomment;
	private String replyorcommentuserid;
	private String replyorcommentusername;
	private int score;
	private String shopid;
	private String state;
	private String title;
	private String virtualadd;

	public GoodsCommentT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getCommentid() {
		return this.commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}


	@Column(nullable=false, length=500)
	public String getCommentcontent() {
		return this.commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}


	@Column(length=1)
	public String getEmailable() {
		return this.emailable;
	}

	public void setEmailable(String emailable) {
		this.emailable = emailable;
	}


	@Column(nullable=false, length=20)
	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	@Column(nullable=false, length=100)
	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getPosttime() {
		return this.posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}


	@Column(length=20)
	public String getReplyid() {
		return this.replyid;
	}

	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}


	@Column(nullable=false, length=1)
	public String getReplyorcomment() {
		return this.replyorcomment;
	}

	public void setReplyorcomment(String replyorcomment) {
		this.replyorcomment = replyorcomment;
	}


	@Column(nullable=false, length=20)
	public String getReplyorcommentuserid() {
		return this.replyorcommentuserid;
	}

	public void setReplyorcommentuserid(String replyorcommentuserid) {
		this.replyorcommentuserid = replyorcommentuserid;
	}


	@Column(nullable=false, length=50)
	public String getReplyorcommentusername() {
		return this.replyorcommentusername;
	}

	public void setReplyorcommentusername(String replyorcommentusername) {
		this.replyorcommentusername = replyorcommentusername;
	}


	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	@Column(length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(nullable=false, length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(length=45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Column(length=1)
	public String getVirtualadd() {
		return this.virtualadd;
	}

	public void setVirtualadd(String virtualadd) {
		this.virtualadd = virtualadd;
	}

}