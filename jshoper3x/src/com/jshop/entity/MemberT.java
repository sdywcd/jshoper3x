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
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


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


	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getBlood() {
		return this.blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getConstellation() {
		return this.constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
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


	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


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


	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


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


	@Column(name="MEMBER_GROUP_ID")
	public String getMemberGroupId() {
		return this.memberGroupId;
	}

	public void setMemberGroupId(String memberGroupId) {
		this.memberGroupId = memberGroupId;
	}


	@Column(name="MEMBER_GROUP_NAME")
	public String getMemberGroupName() {
		return this.memberGroupName;
	}

	public void setMemberGroupName(String memberGroupName) {
		this.memberGroupName = memberGroupName;
	}


	public String getMemberstate() {
		return this.memberstate;
	}

	public void setMemberstate(String memberstate) {
		this.memberstate = memberstate;
	}


	public String getMerrystatus() {
		return this.merrystatus;
	}

	public void setMerrystatus(String merrystatus) {
		this.merrystatus = merrystatus;
	}


	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}


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


	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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


	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}


	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}


	public String getWhichsex() {
		return this.whichsex;
	}

	public void setWhichsex(String whichsex) {
		this.whichsex = whichsex;
	}

}