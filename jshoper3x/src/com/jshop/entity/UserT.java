package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_t database table.
 * 
 */
@Entity
@Table(name="user_t")
@NamedQuery(name="UserT.findAll", query="SELECT u FROM UserT u")
public class UserT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String answer;
	private Date createtime;
	private String creatorid;
	private String credentialsalt;
	private String email;
	private String groupid;
	private String headpath;
	private String mobile;
	private String parttime1;
	private String parttime2;
	private String parttime3;
	private String password;
	private String position;
	private int postingcount;
	private String qq;
	private String question;
	private String realname;
	private String rolemid;
	private String rolemname;
	private String salt;
	private String section;
	private String shopid;
	private String shopname;
	private String sinaweibo;
	private String state;
	private String telno;
	private String uid;
	private Date updatetime;
	private String username;
	private String userstate;
	private String weixin;

	public UserT() {
	}


	@Id
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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


	public String getCredentialsalt() {
		return this.credentialsalt;
	}

	public void setCredentialsalt(String credentialsalt) {
		this.credentialsalt = credentialsalt;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}


	public String getHeadpath() {
		return this.headpath;
	}

	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}


	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getParttime1() {
		return this.parttime1;
	}

	public void setParttime1(String parttime1) {
		this.parttime1 = parttime1;
	}


	public String getParttime2() {
		return this.parttime2;
	}

	public void setParttime2(String parttime2) {
		this.parttime2 = parttime2;
	}


	public String getParttime3() {
		return this.parttime3;
	}

	public void setParttime3(String parttime3) {
		this.parttime3 = parttime3;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public int getPostingcount() {
		return this.postingcount;
	}

	public void setPostingcount(int postingcount) {
		this.postingcount = postingcount;
	}


	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getRolemid() {
		return this.rolemid;
	}

	public void setRolemid(String rolemid) {
		this.rolemid = rolemid;
	}


	public String getRolemname() {
		return this.rolemname;
	}

	public void setRolemname(String rolemname) {
		this.rolemname = rolemname;
	}


	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	public String getSinaweibo() {
		return this.sinaweibo;
	}

	public void setSinaweibo(String sinaweibo) {
		this.sinaweibo = sinaweibo;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}


	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserstate() {
		return this.userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}


	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

}