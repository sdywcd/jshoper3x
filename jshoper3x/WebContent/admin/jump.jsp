<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript" src="<%=basePath%>admin/js/jquery.js"></script>
<title>jump</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		var pathnamearray=window.location.pathname.split("/");
		var pathname=pathnamearray[1]+"/";
		if(pathname=="jshop/"){
			pathname="";
		}
		window.location.href="http://"+window.location.host+"/"+pathname+"admin/login.jsp";
	});
</script>
<body>
	<div id="hidjumptologin">正在跳转请稍后...</div>
	
</body>
</html>
