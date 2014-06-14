package com.jshop.action.wx.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.jshop.action.backstage.base.BaseTAction;
@Namespace("/wx")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})

public class WxTokenAction extends BaseTAction implements
ServletRequestAware, ServletResponseAware{
	private HttpServletRequest request;
    private HttpServletResponse response;
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
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
	
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	@Action(value="signWx")
	public void signWx() throws IOException{
		if(SignUtil.checkSignature(this.getSignature(), this.getTimestamp(), this.getNonce())){
			WxAppInfo.IsFromWX=true;
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.write(this.getEchostr());
			out.flush();
			out.close();
		}
	}
	
	
}
