package com.jshop.action.backstage.androidclient;

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

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.MD5Code;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class AndroidUserRegisterAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	@Resource
	private UsertService usertService;
	@Resource
	private Serial serial;
	public static final String USER_SESSION_KEY="user";
	private HttpServletRequest request;
    private HttpServletResponse response;
	private String username;
	private String password;
	private String email;
	private String sucflag;
	
	@JSON(serialize = false)
	public UsertService getUsertService() {
		return usertService;
	}
	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSucflag() {
		return sucflag;
	}
	public void setSucflag(String sucflag) {
		this.sucflag = sucflag;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;

	}
	

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	
	/**
	 * 手机端注册系统
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	@Action(value="findAllGoodsByismobileplatformgoodsforAndroid" ,results = { 
			@Result(name = "success",type="dispatcher")
	})
	public String registerforAndroid() throws IOException{
		MD5Code md5 = new MD5Code();
		UserT u=new UserT();
		u.setUsername(this.getUsername().trim());
		u.setEmail(this.getEmail().trim());
		u=this.getUsertService().checkUserByUsername(u);
		if(u!=null){
			this.setSucflag("0");//user has in
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.write(this.getSucflag());
			out.flush();
			out.close();
			return SUCCESS;
		}else{
			u=new UserT();
			u.setUsername(this.getUsername().trim());
			u.setEmail(this.getEmail().trim());
			u=this.getUsertService().checkUserByEmail(u);
			if(u!=null){
				this.setSucflag("4");//user mail has
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.write(this.getSucflag());
				out.flush();
				out.close();
				return SUCCESS;
			}
			UserT user=new UserT();
			user.setUserid(this.getSerial().Serialid(Serial.USER));
			user.setUsername(this.getUsername().trim());
			user.setRealname(null);
			user.setEmail(this.getEmail().trim());
			user.setTelno(null);
			user.setMobile(null);
			user.setQuestion(null);
			user.setAnswer(null);
			user.setPassword(md5.getMD5ofStr(this.getPassword().trim()));
			user.setUserstate("1");
			user.setSection(null);
			user.setPosition(null);
			user.setGroupid(null);
			user.setParttime1(null);
			user.setParttime2(null);
			user.setParttime3(null);
			user.setQq(null);
			user.setState("4");//register from mobile
			if(this.getUsertService().save(user)>0){
				this.setSucflag("1");//表示注册成功
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.write(this.getSucflag());
				out.flush();
				out.close();
				return SUCCESS;
			}else{
				this.setSucflag("2");//标示注册失败
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.write(this.getSucflag());
				out.flush();
				out.close();
				return SUCCESS;
			}
		}
	}
	
	
	
	
}
