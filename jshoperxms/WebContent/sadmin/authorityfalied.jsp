<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>权限异常 &middot; jshoper</title>

<!-- Le styles -->
<link href="<%=basePath%>admin/ui/assets/css/bootstrap.css"
	rel="stylesheet">
<style type="text/css">
html {
	height: 100%;
}

.view-login {
	padding-top: 0;
	background-color: #142849;
	background-image: -webkit-gradient(radial, center center, 0, center center, 460, from(#165387
		), to(#142849));
	background-image: -webkit-radial-gradient(circle, #165387, #142849);
	background-image: -moz-radial-gradient(circle, #165387, #142849);
	background-image: -o-radial-gradient(circle, #165387, #142849);
	background-repeat: no-repeat;
}

.view-login .container {
	width: 300px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: 106px;
	margin-left: -150px;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0px auto;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 20px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link href="<%=basePath%>admin/ui/assets/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/docs.css" rel="stylesheet">
<link
	href="<%=basePath%>admin/ui/assets/js/google-code-prettify/prettify.css"
	rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/base.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="shortcut icon"
	href="<%=basePath%>admin/ui/assets/ico/favicon.ico" />
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar"
	class="view-login">

	<div class="container">


		<form class="form-signin" action="user/adminlogin.action"
			method="post">
			<h2 class="form-signin-heading">
				<img src="<%=basePath%>admin/ui/assets/img/logo.png" width="280"
					height="48">
			</h2>

			<div class="messages">
				<div  id="message-error"
					class="message message-error">
					<div class="image">
						<img
							src="<%=basePath%>admin/ui/assets/img/header/icon-48-alert.png"
							alt="Error" height="32" /> <span>权限异常</span>
					</div>
				</div>
			</div>
			<hr />
			<button id="gotologin" name="gotologin" class="btn btn-large btn-primary" type="button">
				<i class="icon-user icon-white"></i> 重新登录
			</button>
		</form>
		<!-- /form -->


	</div>
	
	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=basePath%>admin/ui/assets/js/jquery.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-transition.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-alert.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-modal.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-dropdown.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-scrollspy.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-tab.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-tooltip.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-popover.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-button.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-collapse.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-carousel.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-typeahead.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/jquery.query.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#gotologin").click(function(){
				top.location.href="login.jsp";
			});
		});
	</script>
</body>
</html>