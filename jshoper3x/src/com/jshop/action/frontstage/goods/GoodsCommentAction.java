package com.jshop.action.frontstage.goods;


import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsCommentT;
import com.jshop.entity.UserT;
import com.jshop.service.GoodsCommentTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class GoodsCommentAction extends ActionSupport {
	private GoodsCommentTService goodsCommentTService;
	private Serial serial;
	private String commentid;
	private String goodsid;
	private String goodsname;
	private String replyorcommentusername;
	private Date posttime;
	private String commentcontent;
	private Integer score;
	private String state;
	private String replyorcomment;
	private String replyid;
	private String replyorcommentuserid;
	private String emailable;
	private String userid;
	private boolean slogin;
	private boolean sucflag;

	@JSON(serialize = false)
	public GoodsCommentTService getGoodsCommentTService() {
		return goodsCommentTService;
	}
	public void setGoodsCommentTService(GoodsCommentTService goodsCommentTService) {
		this.goodsCommentTService = goodsCommentTService;
	}
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getReplyorcommentusername() {
		return replyorcommentusername;
	}
	public void setReplyorcommentusername(String replyorcommentusername) {
		this.replyorcommentusername = replyorcommentusername;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getReplyorcomment() {
		return replyorcomment;
	}
	public void setReplyorcomment(String replyorcomment) {
		this.replyorcomment = replyorcomment;
	}
	public String getReplyid() {
		return replyid;
	}
	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}
	public String getReplyorcommentuserid() {
		return replyorcommentuserid;
	}
	public void setReplyorcommentuserid(String replyorcommentuserid) {
		this.replyorcommentuserid = replyorcommentuserid;
	}
	public String getEmailable() {
		return emailable;
	}
	public void setEmailable(String emailable) {
		this.emailable = emailable;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	/**
	 * 去除查询所有商品类别的错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}

	

	/**
	 * 增加用户评论商品
	 * @return
	 */
	@Action(value = "addGoodsComment", results = { 
			@Result(name = "json",type="json")
	})
	public String addGoodsComment(){
		UserT user=(UserT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(user!=null){
			GoodsCommentT gct=new GoodsCommentT();
			gct.setCommentid(this.getSerial().Serialid(Serial.GOODSCOMMENT));
			gct.setGoodsid(this.getGoodsid().trim());
			gct.setGoodsname(this.getGoodsname());
			gct.setReplyorcommentusername(user.getUsername());
			gct.setReplyorcommentuserid(user.getUserid());
			gct.setPosttime(BaseTools.systemtime());
			gct.setCommentcontent(this.getCommentcontent());
			gct.setScore(0);
			gct.setState("1");//显示
			gct.setReplyorcomment("1");//评论
			gct.setReplyid("0");//回复的评论id
			gct.setEmailable("0");//不进行邮件提醒
			gct.setVirtualadd("0");
			this.getGoodsCommentTService().save(gct);
			this.setSucflag(true);
			return "json";
			
		}
		this.setSucflag(false);
		return "json";
	}
	
	
	
	
	
}
