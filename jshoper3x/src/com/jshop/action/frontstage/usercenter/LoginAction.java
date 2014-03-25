package com.jshop.action.frontstage.usercenter;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.MD5Code;
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
public class LoginAction extends ActionSupport {
	private MemberTService memberTService;
	private MemberT memberT;
	private String basepath;
	private String loginname;
	private String loginpwd;
	private String hidurl;
	private boolean loginflag;


	@JSON(serialize = false)
	public MemberT getMemberT() {
		return memberT;
	}

	public void setMemberT(MemberT memberT) {
		this.memberT = memberT;
	}
	
	@JSON(serialize = false)
	public MemberTService getMemberTService() {
		return memberTService;
	}

	public void setMemberTService(MemberTService memberTService) {
		this.memberTService = memberTService;
	}

	public boolean isLoginflag() {
		return loginflag;
	}
	public void setLoginflag(boolean loginflag) {
		this.loginflag = loginflag;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 前台用户登录
	 * 
	 * @return
	 */
	@Action(value="login", results={ @Result(name="json",type="json") })
	public String login() {
		this.setBasepath(BaseTools.getBasePath());
		
		MemberT m = (MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(m!=null){
			ActionContext.getContext().getSession().remove(StaticKey.MEMBER_SESSION_KEY);
		}
		MD5Code md5 = new MD5Code();
		MemberT memberT = new MemberT();
		memberT.setLoginname(this.getLoginname().trim());
		memberT.setLoginpwd(md5.getMD5ofStr(this.getLoginpwd().trim()));
		memberT.setMemberstate(StaticKey.MEMBERSTATE_ONE_NUM);
		List<MemberT>mlists=this.getMemberTService().login(memberT);
		if (!mlists.isEmpty()) {
			this.setLoginflag(true);
			ActionContext.getContext().getSession().put(StaticKey.MEMBER_SESSION_KEY, mlists.get(0));
			return "json";
		}
		return "json";
	}
	/**
	 * 前台登出 
	 */
	@Action(value = "memberLogout", results = { 
			@Result(name = "success",type="freemarker",location = "/html/default/shop/user/login.html")
	})
	public String memberLogout() throws UnsupportedEncodingException {
		ActionContext.getContext().getSession().remove(StaticKey.MEMBER_SESSION_KEY);
		return "success";
	}
	
	@Action(value="findUsernameFromSession", results={ @Result(name="json",type="json") })
	public String findUsernameFromSession(){
		MemberT memberT=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(memberT!=null){
			this.setLoginname(memberT.getLoginname());
		}else{
			this.setLoginname("");
		}
		return "json";
	}
	
}
