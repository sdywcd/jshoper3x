<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<% 

//商户号
String partner = "";

//密钥
String key = "";

//交易完成后跳转的URL
String return_url=basePath+"pay/tenpay/payReturnUrl.jsp";

//接收财付通通知的URL
String notify_url = basePath+"pay/tenpay/payNotifyUrl.jsp";

%>
