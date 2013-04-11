package com.jshop.action.backstage.taobao;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class Tblogout extends ActionSupport {

	/**
	* 退出TOP登陆（清除top cookie）
	* @return
	* @throws UnsupportedEncodingException
	*/
	private String logoffopenid() throws UnsupportedEncodingException {
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
	* 获取app退出URL
	*/
	public String getlogoffURL() throws UnsupportedEncodingException {
		// 组装请求URL
		StringBuilder url = new StringBuilder(Util.logoff_URL + "?");
		url.append(logoffopenid());
		return url.toString();
	}
	 
}
