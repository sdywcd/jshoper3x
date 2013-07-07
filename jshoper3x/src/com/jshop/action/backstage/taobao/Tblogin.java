package com.jshop.action.backstage.taobao;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.TaobaoUserT;
import com.jshop.service.TaoBaoUsertService;
import com.jshop.service.impl.TaoBaoUsertServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class Tblogin extends ActionSupport{
	private TaoBaoUsertService taoBaoUsertService;
	
	private String taobao_user_id="";
	
	private String taobao_user_nick="";
	
	private String sessionKey="";
	
	private String redirecturl="";
	
	
	@JSON(serialize = false)
	public TaoBaoUsertService getTaoBaoUsertService() {
		return taoBaoUsertService;
	}
	public void setTaoBaoUsertService(TaoBaoUsertService taoBaoUsertService) {
		this.taoBaoUsertService = taoBaoUsertService;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public String getTaobao_user_id() {
		return taobao_user_id;
	}
	public void setTaobao_user_id(String taobaoUserId) {
		taobao_user_id = taobaoUserId;
	}
	public String getTaobao_user_nick() {
		return taobao_user_nick;
	}
	public void setTaobao_user_nick(String taobaoUserNick) {
		taobao_user_nick = taobaoUserNick;
	}
	public String getRedirecturl() {
		return redirecturl;
	}
	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}

	
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	/**
	* 使用淘宝帐号登录
	* @return
	* @throws UnsupportedEncodingException
	*/
	
	private String identifyparams() throws UnsupportedEncodingException {
		TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
		// 组装协议参数。
		apiparamsMap.put("sign_method", "md5");
		apiparamsMap.put("app_key", Util.APP_KEY);
		apiparamsMap.put("timestamp", new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss").format(new Date()));
		String sign = Util.sign(apiparamsMap, Util.APP_SERCET);
		// 组装协议参数sign
		apiparamsMap.put("sign", sign);
		StringBuilder param = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> it = apiparamsMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, String> e = it.next();
			param.append("&").append(e.getKey()).append("=").append(
			e.getValue());
		}
		return param.toString().substring(1);
	}
	/*
	* 获取app使用淘宝帐号登录URL
	*/
	public String getidentifyURL() throws UnsupportedEncodingException {
		// 组装请求URL
		StringBuilder url = new StringBuilder("http://container.api.taobao.com/container/identify?");
		url.append(identifyparams());
		return url.toString();
	}
	
	/**
	 * 第三方登录淘宝用户
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Action(value = "loginTbuser", results = { 
			@Result(name = "json",type="json")
	})
	public String loginTbuser() throws UnsupportedEncodingException{
		this.setRedirecturl(this.getidentifyURL());
		return "json";
		
	}
	/**
	 * 创建淘宝用户在本地的session
	 * @throws Exception 
	 */
	
//	public void createTaobaosession() throws Exception{
//		ActionContext.getContext().getSession().put("taobao_user_id", this.getTaobao_user_id());
//		ActionContext.getContext().getSession().put("taobao_user_nick", this.getTaobao_user_nick());
//		ActionContext.getContext().getSession().put("sessionKey", this.getSessionKey());
//		if(Validate.StrNotNull(this.getTaobao_user_id())){
//			ActionContext.getContext().getSession().put("adminid",this.getTaobao_user_id());
//			addTaobaoUsert();
//		}
//		
//	}
	/**
	 * 增加淘宝用户数据到本地数据表
	 */
//	public void addTaobaoUsert()throws Exception{
//		TaobaoUserT taobaouser =new TaobaoUserT();
//		taobaouser.setTaobaoUserid(this.getTaobao_user_id());
//		taobaouser.setTaobaoNick(this.getTaobao_user_nick());
//		this.getTaoBaoUsertServiceImpl().addTaoBaoUserT(taobaouser);
//		
//		
//	}
	
	
	
	
	
	
	
	
}
