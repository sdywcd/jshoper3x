package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the member_t database table.
 * 
 */
@Entity
@Table(name="member_t")
@NamedQuery(name="MemberT.findAll", query="SELECT m FROM MemberT m")
public class MemberT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String answer;
	private int belove;
	private String birthday;
	private String blood;
	private String city;
	private String constellation;
	private Date createtime;
	private String creatorid;
	private String des;
	private String district;
	private String email;
	private String headpath;
	private int integration;
	private String loginname;
	private String loginpwd;
	private int loveother;
	private String memberGroupId;
	private String memberGroupName;
	private String memberstate;
	private String merrystatus;
	private String mid;
	private String mobile;
	private String nick;
	private String paypassword;
	private int postingcount;
	private String qq;
	private String question;
	private String realname;
	private String sex;
	private String shopid;
	private String shopname;
	private String sinaweibo;
	private String tag;
	private String telno;
	private Date updatetime;
	private int versiont;
	private String weixin;
	private String whichsex;

	public MemberT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(length=45)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getBelove() {
		return this.belove;
	}

	public void setBelove(int belove) {
		this.belove = belove;
	}


	@Column(length=45)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	@Column(length=20)
	public String getBlood() {
		return this.blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}


	@Column(length=45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(length=20)
	public String getConstellation() {
		return this.constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(length=500)
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	@Column(length=45)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	@Column(length=100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(length=255)
	public String getHeadpath() {
		return this.headpath;
	}

	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}


	public int getIntegration() {
		return this.integration;
	}

	public void setIntegration(int integration) {
		this.integration = integration;
	}


	@Column(nullable=false, length=100)
	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	@Column(nullable=false, length=32)
	public String getLoginpwd() {
		return this.loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}


	public int getLoveother() {
		return this.loveother;
	}

	public void setLoveother(int loveother) {
		this.loveother = loveother;
	}


	@Column(name="MEMBER_GROUP_ID", length=20)
	public String getMemberGroupId() {
		return this.memberGroupId;
	}

	public void setMemberGroupId(String memberGroupId) {
		this.memberGroupId = memberGroupId;
	}


	@Column(name="MEMBER_GROUP_NAME", length=45)
	public String getMemberGroupName() {
		return this.memberGroupName;
	}

	public void setMemberGroupName(String memberGroupName) {
		this.memberGroupName = memberGroupName;
	}


	@Column(length=1)
	public String getMemberstate() {
		return this.memberstate;
	}

	public void setMemberstate(String memberstate) {
		this.memberstate = memberstate;
	}


	@Column(length=1)
	public String getMerrystatus() {
		return this.merrystatus;
	}

	public void setMerrystatus(String merrystatus) {
		this.merrystatus = merrystatus;
	}


	@Column(length=32)
	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}


	@Column(length=20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Column(length=45)
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}


	@Column(length=32)
	public String getPaypassword() {
		return this.paypassword;
	}

	public void setPaypassword(String paypassword) {
		this.paypassword = paypassword;
	}


	public int getPostingcount() {
		return this.postingcount;
	}

	public void setPostingcount(int postingcount) {
		this.postingcount = postingcount;
	}


	@Column(length=100)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}


	@Column(length=45)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	@Column(length=45)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	@Column(length=1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	@Column(length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(length=45)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(length=100)
	public String getSinaweibo() {
		return this.sinaweibo;
	}

	public void setSinaweibo(String sinaweibo) {
		this.sinaweibo = sinaweibo;
	}


	@Column(length=100)
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


	@Column(length=20)
	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(nullable=false)
	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}


	@Column(length=100)
	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}


	@Column(length=1)
	public String getWhichsex() {
		return this.whichsex;
	}

	public void setWhichsex(String whichsex) {
		this.whichsex = whichsex;
	}

}