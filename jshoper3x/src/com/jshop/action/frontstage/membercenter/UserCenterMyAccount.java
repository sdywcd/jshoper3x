package com.jshop.action.frontstage.membercenter;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.staticspage.FreeMarkervariable;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.MemberT;
import com.jshop.entity.UserT;
import com.jshop.service.MemberTService;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class UserCenterMyAccount extends ActionSupport {
	private MemberTService memberTService;
	private DataCollectionTAction dataCollectionTAction;
	private String userid;
	private String username;
	private String question;
	private String answer;
	private String password;
	private String oldanswer;//原始答案
	private boolean sucflag;
	@JSON(serialize=false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize=false)
	public MemberTService getMemberTService() {
		return memberTService;
	}

	public void setMemberTService(MemberTService memberTService) {
		this.memberTService = memberTService;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getOldanswer() {
		return oldanswer;
	}

	public void setOldanswer(String oldanswer) {
		this.oldanswer = oldanswer;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 设置密码保护
	 * @return
	 */
	@Action(value = "updateUserPasswordProtection", results = { 
			@Result(name = "json",type="json")
	})
	public String updateUserPasswordProtection() {
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			//先验证原始的密码保护问题是否正确
			if(StringUtils.isNotBlank(memberT.getQuestion())){
				//验证输入的原始答案
				if(memberT.getAnswer().equals(this.getOldanswer().trim())){
					if (StringUtils.isNotBlank(this.getQuestion())&&StringUtils.isNotBlank(this.getAnswer())) {
						this.getMemberTService().updateMemberPwdProctection(memberT.getId(), this.getQuestion(), this.getAnswer());
						this.setSucflag(true);
						return "json";
					}
					this.setSucflag(false);
					return "json";
				}
			}else{
				if (StringUtils.isNotBlank(this.getQuestion())&&StringUtils.isNotBlank(this.getAnswer())) {
					this.getMemberTService().updateMemberPwdProctection(memberT.getId(), this.getQuestion(), this.getAnswer());
					this.setSucflag(true);
					return "json";
				}
				this.setSucflag(false);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}
	
	/**
	 * 初始化用户密码保护页面
	 * @return
	 */
	@Action(value = "initMyAccountProtection", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/passwordprotection.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String InitMyAccountProtection(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation(StaticKey.SiteNavigationState.SHOW.getVisible()));
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo(StaticKey.DataShowState.SHOW.getState(),StaticKey.JshopOpenState.OPEN.getOpenstate()));
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT(StaticKey.DataGrade.FIRST.getState(),StaticKey.DataUsingState.USING.getState()));
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle(StaticKey.DataShowState.SHOW.getState()));
			return SUCCESS;
		}
		return INPUT;
	}
	

}
