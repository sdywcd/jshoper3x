
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>微信企业号设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">微信企业号设置 </a> <a
				class="brand2">编辑微信企业号 </a>
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
					<strong>说明</strong> 请根据需要编辑微信企业号
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
						<span class="label label-required">公司名称: </span> <input id="companyname"
							name="companyname" type="text" value="" class="small" />
						<span class="label label-info">请输入你的公司名称</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">corpid: </span> <input id="corpid"
							name="corpid" type="text" value="" class="small" />
							<span class="label label-info">corpid是微信提供给您的企业号ID，请通过微信官方后台获取</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">CORPSECRET: </span> <input id="corpsecret"
							name="corpsecret" type="text" value="" class="small" />
							<span class="label label-info">corpsecret是微信提供给您的企业号管理组密钥，请通过微信官方后台获取</span>
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
		src="<%=basePath%>admin/js/tencentweixin/company/bindcompanyjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>



