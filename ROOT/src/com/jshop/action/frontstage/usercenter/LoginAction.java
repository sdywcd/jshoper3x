package com.jshop.action.frontstage.usercenter;

import java.io.UnsupportedEncodingException;

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
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")
})
public class LoginAction extends ActionSupport {
	private UsertService usertService;
	private String basepath;
	private String username;
	private String password;
	private String hidurl;
	private boolean loginflag;

	
	@JSON(serialize = false)
	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}

	public boolean isLoginflag() {
		return loginflag;
	}

	public void setLoginflag(boolean loginflag) {
		this.loginflag = loginflag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		
		UserT ut = (UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(ut!=null){
			ActionContext.getContext().getSession().remove(BaseTools.USER_SESSION_KEY);
		}
		MD5Code md5 = new MD5Code();
		UserT u = new UserT();
		UserT user = new UserT();
		user.setUsername(this.getUsername().trim());
		user.setPassword(md5.getMD5ofStr(this.getPassword().trim()));
		user.setState("1");//普通用户登录一般指pc用户
		u = this.getUsertService().login(user);
		if (u != null) {
			this.setLoginflag(true);
			ActionContext.getContext().getSession().put(BaseTools.USER_SESSION_KEY, u);
			return "json";
		} else {
			//if no user when state=1,than search state=4 for mobile user
			//the purpose is mobile user account can also use in website
			user.setUsername(this.getUsername().trim());
			user.setPassword(md5.getMD5ofStr(this.getPassword().trim()));
			user.setState("4");//手机用户登录
			u = this.getUsertService().login(user);
			if (u != null) {
				this.setLoginflag(true);
				ActionContext.getContext().getSession().put(BaseTools.USER_SESSION_KEY, u);
				return "json";
			} else {
				this.setLoginflag(false);
				return "json";
			}

		}
	}
	/**
	 * 前台登出 
	 */
	@Action(value = "userLogout", results = { 
			@Result(name = "success",type="freemarker",location = "/html/default/shop/user/login.html")
	})
	public String userLogout() throws UnsupportedEncodingException {
		this.setLoginflag(false);
		ActionContext.getContext().getSession().remove(BaseTools.USER_SESSION_KEY);
		return "success";
	}
	
	@Action(value="findUsernameFromSession", results={ @Result(name="json",type="json") })
	public String findUsernameFromSession(){
		UserT usert=(UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(usert!=null){
			this.setUsername(usert.getUsername());
		}else{
			this.setUsername("");
		}
		
		return "json";
	}
	
}
