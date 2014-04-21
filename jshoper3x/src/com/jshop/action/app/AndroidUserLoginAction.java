package com.jshop.action.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.utils.MD5Code;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class AndroidUserLoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	@Resource
	private UsertService usertService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String username;
	private String password;
	private String loginflag;

	@JSON(serialize = false)
	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	public String getLoginflag() {
		return loginflag;
	}

	public void setLoginflag(String loginflag) {
		this.loginflag = loginflag;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 手机端用户登录
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action(value="loginforAndroid" ,results = { 
			@Result(name = "success",type="dispatcher")
			})
	public String loginforAndroid() throws IOException {
		MD5Code md5 = new MD5Code();
		UserT user = new UserT();
		user.setUsername(this.getUsername().trim());
		user.setPassword(md5.getMD5ofStr(this.getPassword().trim()));
		user.setState("4");//手机用户
		user = this.getUsertService().login(user);
		if (user != null) {
			this.setLoginflag("1");//标示成功登陆
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write(this.getLoginflag());
			out.flush();
			out.close();
			return SUCCESS;
		} else {
			this.setLoginflag("0");//标示失败登陆
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write(this.getLoginflag());
			out.flush();
			out.close();
			return SUCCESS;
		}
	}

}
