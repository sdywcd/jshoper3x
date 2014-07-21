package com.jshop.action.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.jshop.action.app.vo.RequestMemberTMsg;
import com.jshop.action.app.vo.RequestMsg;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.GsonJson;
import com.jshop.action.backstage.utils.MD5Code;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.MemberT;
import com.jshop.entity.UserT;
import com.jshop.service.MemberTService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author Administrator
 *
 */
@Namespace("/app")
@ParentPackage("jshop")
public class MemberT4AppAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	@Resource
	private MemberTService memberTService;
	@Resource
	private Serial serial;
	private HttpServletRequest request;
    private HttpServletResponse response;
	private String loginname;
	private String loginpwd;
	private String sucflag;
	
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
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	
	/**
	 * 手机端注册
	 * @return
	 * @throws IOException
	 */
	@Action(value="register4App")
	public void register4App() throws IOException{
		RequestMsg rm=new RequestMsg();
		if(StringUtils.isNotBlank(this.getLoginname())&&StringUtils.isNotBlank(this.getLoginpwd())){
			List<MemberT>m1=memberTService.findMemberTByloginname(this.getLoginname().toLowerCase(Locale.CHINA));
			if(m1!=null&&m1.size()>0){
				rm.setMsg(StaticKey.MEMBER_EXIST);
				rm.setSucflag(false);
			}else{
				MD5Code md5 = new MD5Code();
				MemberT m=new MemberT();
				m.setId(serial.Serialid(Serial.MEMBER));
				m.setMid(md5.getMD5ofStr(m.getId()));
				m.setLoginname(this.getLoginname().trim());
				m.setLoginpwd(md5.getMD5ofStr(this.getLoginpwd().trim()));
				m.setNick(StaticKey.EMPTY);
				m.setMemberstate(StaticKey.MEMBERSTATE_ONE_NUM);
				m.setHeadpath("#");
				m.setCreatetime(BaseTools.systemtime());
				m.setVersiont(1);
				m.setIntegration(0);
				m.setUpdatetime(m.getCreatetime());
				memberTService.save(m);
				rm.setSucflag(true);
				rm.setMsg(StaticKey.MEMBER_REGISTER_SUCCESS);
				//将手机端注册的用户直接放入内存，直接可登录
				ActionContext.getContext().getSession().put(StaticKey.MEMBER_SESSION_KEY, m);
			}
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(GsonJson.parseDataToJson(rm));
		out.flush();
		out.close();
	}
	
	/**
	 * app登录
	 * @throws IOException
	 */
	@Action(value="login4App")
	public void login4App() throws IOException{
		MemberT m=(MemberT) ActionContext.getContext().getSession().get(StaticKey.MEMBER_SESSION_KEY);
		if(m!=null){
			ActionContext.getContext().getSession().remove(StaticKey.MEMBER_SESSION_KEY);
		}
		RequestMemberTMsg rm=new RequestMemberTMsg();
		MD5Code md5=new MD5Code();
		MemberT memberT=new MemberT();
		memberT.setLoginname(this.getLoginname().trim());
		memberT.setLoginpwd(md5.getMD5ofStr(this.getLoginpwd().trim()));
		memberT.setMemberstate(StaticKey.MEMBERSTATE_ONE_NUM);
		List<MemberT>mlists=memberTService.login(memberT);
		if (!mlists.isEmpty()) {
			rm.setSucflag(true);
			rm.setM(mlists.get(0));
			ActionContext.getContext().getSession().put(StaticKey.MEMBER_SESSION_KEY, mlists.get(0));
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(GsonJson.parseDataToJson(rm));
		out.flush();
		out.close();
	}
	
	
	
	
	
}
