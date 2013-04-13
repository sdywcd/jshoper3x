package com.jshop.action.frontstage.usercenter;

import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.base.SendSystemEmail;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.MD5Code;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.TemplateException;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("isusercanregister"),  
    @InterceptorRef("issendactivatemail"),
    @InterceptorRef("defaultStack")  
})
public class RegisterAction extends ActionSupport {
	private UsertService usertService;
	private Serial serial;
	private SendSystemEmail sendSystemEmail;
	private UserT user;
	private String username;
	private String password;
	private String email;
	private String rand;
	private String userid;
	private String uid;
	private String question;
	private String answer;
	private String msg;
	private boolean sucflag;
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
	@JSON(serialize = false)
	public SendSystemEmail getSendSystemEmail() {
		return sendSystemEmail;
	}
	public void setSendSystemEmail(SendSystemEmail sendSystemEmail) {
		this.sendSystemEmail = sendSystemEmail;
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
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}	
	public UserT getUser() {
		return user;
	}
	public void setUser(UserT user) {
		this.user = user;
	}
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String questoin) {
		this.question = questoin;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	/**
	 * 注册验证
	 * @return
	 */
	public boolean registervalidation(){
		boolean register=false;
		this.setMsg("");
		if(Validate.StrNotNull(this.getUsername())){
			if(this.getUsername().length()<6){
				this.setMsg("1");
				return register;
			}else if(this.getUsername().length()>20){
				this.setMsg("1");
				return register;
			}
		}else{
			this.setMsg("1");
			return register;
		}
		if(Validate.StrNotNull(this.getPassword())){
			if(this.getPassword().length()<6){
				this.setMsg("2");
				return register;
			}else if(this.getPassword().length()>20){
				this.setMsg("2");
				return register;
			}
		}else{
			this.setMsg("2");
			return register;
		}
		
		if(!Validate.StrNotNull(this.getEmail())){
			this.setMsg("3");
			return register;
		}
		register=true;
		return register;
		
		
	}
	
	/**
	 * 增加新用户
	 * @return
	 * @throws EmailException 
	 * @throws TemplateException 
	 * @throws IOException 
	 * @throws MessagingException 
	 */
	
	@Action(value = "register", results = { 
			@Result(name = "register_success",type="redirect",location = "/index.html"),
			@Result(name = "register_error",type="redirect",location = "/html/default/shop/user/register.html?msg=${msg}"),
			@Result(name = "useractivates",type="redirect",location = "/html/default/shop/user/register.html?msg=${msg}")
	})

	public String register() throws EmailException, MessagingException, IOException, TemplateException{
		if(registervalidation()){
			String rand=(String) ActionContext.getContext().getSession().get("rand");
			String userstate=(String) ActionContext.getContext().getSession().get("userstate");
			if(rand.equals(this.getRand())){
				MD5Code md5 = new MD5Code();
				UserT u=new UserT();
				u.setUsername(this.getUsername().trim());
				u.setEmail(this.getEmail().trim());
				u=this.getUsertService().checkUserByUsername(u);
				if(u!=null){
					this.setMsg("4");
					return "register_error";
				}else{
					u=new UserT();
					u.setUsername(this.getUsername().trim());
					u.setEmail(this.getEmail().trim());
					u=this.getUsertService().checkUserByEmail(u);
					if(u!=null){
						this.setMsg("7");
						return "register_error";
					}
					UserT user=new UserT();
					user.setUserid(this.getSerial().Serialid(Serial.USER));
					user.setUid(md5.getMD5ofStr(user.getUserid()));
					user.setUsername(this.getUsername().trim());
					user.setRealname(null);
					user.setEmail(this.getEmail().trim());
					user.setTelno(null);
					user.setMobile(null);
					user.setQuestion(null);
					user.setAnswer(null);
					user.setPassword(md5.getMD5ofStr(this.getPassword().trim()));
					user.setUserstate(userstate);//用户激活取决于用户是否开启了激活邮件设置
					user.setPoints(0.0);
					user.setPostingcount(0);
					user.setSex(null);//未设定性别
					user.setRegisttime(BaseTools.systemtime());
					user.setDisablebegin(null);
					user.setDisableend(null);
					user.setSection(null);
					user.setPosition(null);
					user.setGroupid(null);
					user.setParttime1(null);
					user.setParttime2(null);
					user.setParttime3(null);
					user.setParttime4(null);
					user.setParttime5(null);
					user.setParttime6(null);
					user.setHobby(null);
					user.setQq(null);
					user.setMsn(null);
					user.setOthercontract(null);
					user.setAddress(null);
					user.setPostcode(null);
					user.setBirthday(null);
					user.setGrade(null);
					user.setGradetime(null);
					user.setState("1");
					user.setRolemid("0");
					user.setRolemname("");
					user.setHeadpath("#");
					if(this.getUsertService().save(user)>0){
						//会员注册成功自动发送邮件
						if(user.getUserstate().equals("0")){
							this.getSendSystemEmail().sendTextMail(user);
							this.setMsg("6");
							return "useractivates";
						}
						return "register_success";
					}
					return "register_error";
				}
			}else{
				this.setMsg("5");
				return "register_error";
			}
		}else{
			return "register_error";
		}
	}

	
	/**
	 * 激活用户
	 */
	@Action(value = "updateUserstate", results = { 
			@Result(name = "json",type="json")
	})
	public String updateUserstate(){
		if(Validate.StrNotNull(this.getUid())){
			UserT user=new UserT();
			user=this.getUsertService().finduserByuid(this.getUid());
			if(user!=null){
				if(user.getUserstate().equals("0")){
					user.setUserstate("1");
					this.getUsertService().updateUserstate(user);
					
					this.setSucflag(true);
					return "json";
				}else{
					this.setSucflag(false);
					return "json";
				}
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	/**
	 * 
	 * @return
	 */
	@Action(value = "checkUserByAnswer", results = { 
			@Result(name = "json",type="json")
	})
	public String checkUserByAnswer(){
		if(Validate.StrNotNull(this.getUsername())&&Validate.StrNotNull(this.getQuestion())&&Validate.StrNotNull(this.getAnswer())){
					UserT user=new UserT();
					user=this.getUsertService().checkUserByAnswer(this.getUsername().trim(), this.getQuestion(), this.getAnswer());
					if(user!=null){
						this.setSucflag(true);
						return "json";
					}else{
						this.setSucflag(false);
						return "json";
					}		
		}
		return "json";
	}

}
