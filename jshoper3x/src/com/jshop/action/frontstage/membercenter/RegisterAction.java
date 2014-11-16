package com.jshop.action.frontstage.membercenter;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.SendSystemEmail;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.MD5Code;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.MemberT;
import com.jshop.service.MemberTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("isusercanregister"),  
    @InterceptorRef("issendactivatemail"),
    @InterceptorRef("defaultStack")  
})
public class RegisterAction extends ActionSupport {
	private MemberTService memberTService;
	private Serial serial;
	private SendSystemEmail sendSystemEmail;
	private MemberT memberT;
	private String loginname;
	private String loginpwd;
	private String email;
	private String rand;
	private String mid;
	private String question;
	private String answer;
	private String nick;
	private String msg;
	private boolean sucflag;

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize = false)
	public MemberTService getMemberTService() {
		return memberTService;
	}
	public void setMemberTService(MemberTService memberTService) {
		this.memberTService = memberTService;
	}
	@JSON(serialize = false)
	public SendSystemEmail getSendSystemEmail() {
		return sendSystemEmail;
	}
	public void setSendSystemEmail(SendSystemEmail sendSystemEmail) {
		this.sendSystemEmail = sendSystemEmail;
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
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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
	
	public MemberT getMemberT() {
		return memberT;
	}
	public void setMemberT(MemberT memberT) {
		this.memberT = memberT;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
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
		if(StringUtils.isNotBlank(this.getLoginname())){
			if(this.getLoginname().length()<4){
				this.setMsg("1");
				return register;
			}else if(this.getLoginname().length()>20){
				this.setMsg("1");
				return register;
			}
		}else{
			this.setMsg("1");
			return register;
		}
		if(StringUtils.isNotBlank(this.getLoginpwd())){
			if(this.getLoginpwd().length()<7){
				this.setMsg("2");
				return register;
			}else if(this.getLoginpwd().length()>20){
				this.setMsg("2");
				return register;
			}
		}else{
			this.setMsg("2");
			return register;
		}
		
//		if(!StringUtils.isNotBlank(this.getEmail())){
//			this.setMsg("3");
//			return register;
//		}
		register=true;
		return register;
		
		
	}
	
	/**
	 * 增加新用户
	 * @return
	 */
	@Action(value = "register", results = { 
			@Result(name = "register_success",type="redirect",location = "/index.html"),
			@Result(name = "register_error",type="redirect",location = "/html/default/shop/user/register.html?msg=${msg}"),
			@Result(name = "useractivates",type="redirect",location = "/html/default/shop/user/register.html?msg=${msg}")
	})
	public String register() {
		if(registervalidation()){
			//String rand=(String) ActionContext.getContext().getSession().get("rand");
			//String userstate=(String) ActionContext.getContext().getSession().get("userstate");
//			if(rand.equals(this.getRand())){
				List<MemberT>m1=this.getMemberTService().findMemberTByloginname(this.getLoginname().toLowerCase(Locale.CHINA));
				if(m1!=null&&m1.size()>0){
					this.setMsg("4");
					return "register_error";
				}
//				List<MemberT>m2=this.getMemberTService().findMemberTByemail(this.getEmail().trim());//新增根据邮箱差信息
//				if(m2!=null&&m2.size()==0){
//					this.setMsg("7");
//					return "register_error";
//				}
				MD5Code md5 = new MD5Code();
				MemberT m=new MemberT();
				m.setId(this.getSerial().Serialid(Serial.MEMBER));
				m.setMid(md5.getMD5ofStr(m.getId()));
				m.setLoginname(this.getLoginname().toLowerCase(Locale.CHINA).trim());
				m.setLoginpwd(md5.getMD5ofStr(this.getLoginpwd().trim()));
				m.setNick(StaticKey.EMPTY);
				m.setRealname(StaticKey.EMPTY);
				m.setCity(StaticKey.EMPTY);
				m.setDistrict(StaticKey.EMPTY);
				m.setSex(StaticKey.EMPTY);
				m.setWhichsex(StaticKey.EMPTY);
				m.setMemberstate(StaticKey.MEMBERSTATE_ONE_NUM);
				m.setMerrystatus(StaticKey.EMPTY);
				m.setBirthday(StaticKey.EMPTY);
				m.setBlood(StaticKey.EMPTY);
				m.setConstellation(StaticKey.EMPTY);
				m.setDes(StaticKey.EMPTY);
				m.setEmail(StaticKey.EMPTY);
				m.setQq(StaticKey.EMPTY);
				m.setWeixin(StaticKey.EMPTY);
				m.setSinaweibo(StaticKey.EMPTY);
				m.setTag(StaticKey.EMPTY);
				m.setBelove(0);
				m.setLoveother(0);
				m.setPostingcount(0);
				m.setQuestion(StaticKey.EMPTY);
				m.setAnswer(StaticKey.EMPTY);
				m.setHeadpath("#");
				m.setCreatetime(BaseTools.systemtime());
				m.setCreatorid(StaticKey.ZERO);
				m.setMobile(StaticKey.EMPTY);
				m.setPaypassword(StaticKey.EMPTY);
				m.setMemberGroupId(StaticKey.EMPTY);
				m.setMemberGroupName(StaticKey.EMPTY);
				m.setTelno(StaticKey.EMPTY);
				m.setVersiont(1);
				m.setIntegration(0);
				m.setUpdatetime(m.getCreatetime());
				this.getMemberTService().save(m);
				return "register_success";
//			}
		}else{
			return "register_error";
		}
//		return "register_error";
	}

	
	/**
	 * 激活用户
	 */
	@Action(value = "updateMemberstate", results = { 
			@Result(name = "json",type="json")
	})
	public String updateMemberstate(){
		if(StringUtils.isBlank(this.getMid())){
			return "json";
		}
		List<MemberT>memberTs=this.getMemberTService().findMemberTymid(this.getMid());
		if(!memberTs.isEmpty()){
			memberTs.get(0).setMemberstate(StaticKey.MEMBERSTATE_ONE_NUM);
			this.getMemberTService().updateMemberT(memberTs.get(0));
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	/**
	 * 根据安全问题和答案检查用户是否存在
	 * @return
	 */
	@Action(value = "findMemberByQA", results = { 
			@Result(name = "json",type="json")
	})
	public String findMemberByQA(){
		if(StringUtils.isBlank(this.getLoginname())||StringUtils.isBlank(this.getQuestion())||StringUtils.isBlank(this.getAnswer())){
			return "json";
		}
		List<MemberT>memberTs=this.getMemberTService().findMemberByQA(this.getLoginname(), this.getQuestion(), this.getAnswer());
		if(!memberTs.isEmpty()){
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}

}
