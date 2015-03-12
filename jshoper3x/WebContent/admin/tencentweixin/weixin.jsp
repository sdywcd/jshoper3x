
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>微信账号设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">微信账号设置 </a> <a
				class="brand2">编辑微信账号 </a>
		</div>

	</div>
	<div class="container-fluid containerb">

		<div class="row-fluid">

			<div class="span2">
				<!-- 引入左侧导航 -->
				<%@include file="/admin/left.jsp"%>
			</div>

			<div id="mainlogic" class="span10">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>说明</strong> 请根据需要编辑邮箱
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div class="line-dotted"></div>
				<div class="btn-group">
					<button id="btnback" type="button" class="btn btn-success">返回</button>
				</div>
				<!-- 开始显示form表单 -->
				<div class="form-actions">
					<div class="form-inline">
						<span class="label label-required">邮箱账号: </span> <input id="email"
							name="email" type="text" value="" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">邮箱密码: </span> <input id="pwd"
							name="pwd" type="text" value="" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">SMTP: </span> <input id="smtp"
							name="smtp" type="text" value="" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">端口: </span> <input id="port"
							name="port" type="text" value="21" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">加密传输：</span> <input
							type="radio" id="isssl" name="isssl" value="1" /> <label
							for="radio-1">是 </label> <input type="radio" id="isssl"
							name="isssl" value="0" checked /> <label for="radio-2">否
						</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">默认：</span> <input type="radio"
							id="isdefault" name="isdefault" value="1" /> <label
							for="radio-1">是 </label> <input type="radio" id="isdefault"
							name="isdefault" value="0" checked /> <label for="radio-2">否
						</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">状态：</span> <input type="radio"
							id="state" name="state" value="1" checked /> <label
							for="radio-1">开启 </label> <input type="radio" id="state"
							name="state" value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidid" name="hidid" value="" /> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />

					</div>

				</div>


			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/setting/emailmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>



