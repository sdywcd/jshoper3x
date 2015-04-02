<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://twbs.github.io/bootstrap/favicon.ico">

<title>商户登录</title>

<!-- Bootstrap core CSS -->
<link href="<%=basePath%>subadmin/ui/css/bootstrap.min.css"
	rel="stylesheet">



<style id="style-1-cropbar-clipper">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.en-markup-crop-options {
	top: 18px !important;
	left: 50% !important;
	margin-left: -100px !important;
	width: 200px !important;
	border: 2px rgba(255, 255, 255, .38) solid !important;
	border-radius: 4px !important;
}

.en-markup-crop-options div div:first-of-type {
	margin-left: 0px !important;
}
</style>
</head>

<body>

	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">掌柜管理后台</h2>
			<label for="inputAccount" class="sr-only">账号</label> <input
				type="text" id="inputEmail" class="form-control"
				placeholder="请输入账号" required="" autofocus=""> <label
				for="inputPassword" class="sr-only">密码</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="请输入密码" required="">
			<div class="checkbox">
			
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>