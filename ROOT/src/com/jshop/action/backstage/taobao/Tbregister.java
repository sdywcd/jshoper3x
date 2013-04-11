package com.jshop.action.backstage.taobao;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class Tbregister extends ActionSupport {

	private String redirecturl;
	
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
	* 注册帐号
	* @return
	* @throws UnsupportedEncodingException
	*/
	private String registerparams() throws UnsupportedEncodingException {
		TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
		// 组装协议参数。
		apiparamsMap.put("sign_method", "md5");
		apiparamsMap.put("app_key", Util.APP_KEY);
		apiparamsMap.put("timestamp", new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss").format(new Date()));
		// 生成签名
		String sign = Util.sign(apiparamsMap, Util.APP_SERCET);
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
	* 获取注册帐号URL
	*/
	public String getURL() throws UnsupportedEncodingException {
		// 组装请求URL
		StringBuilder url = new StringBuilder("http://container.api.taobao.com/container/register?");
		url.append(registerparams());
		return url.toString();
	}
	
	/**
	 * 第三方注册淘宝用户
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Action(value = "registerTbuser", results = { 
			@Result(name = "json",type="json")
	})
	public String registerTbuser() throws UnsupportedEncodingException{
		this.setRedirecturl(this.getURL());
		return "json";
		
	}
	
	
	
	
}
