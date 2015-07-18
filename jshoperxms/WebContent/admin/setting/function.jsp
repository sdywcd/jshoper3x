<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>系统模块功能 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">模块功能 </a> <a
				class="brand2">编辑模块功能 </a>
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
					<strong>说明</strong> 请根据需要编辑模块功能
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
						<span class="label label-required">功能系统模块: </span> <select
							id="moduleid" name="moduleid"></select>
					</div>
					<div class="form-inline">
						<span class="label label-required">功能名称: </span> <input
							id="functionname" name="functionname" type="text" value=""
							class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">可访问路径: </span> <input
							id="visiturl" name="visiturl" type="text" value="" class="medium" />
					</div>
					<div class="form-inline">
						<span class="label label-required">可访问方法: </span> <input
							id="visitmethodname" name="visitmethodname" type="text" value=""
							class="medium" />
					</div>
					<div class="form-inline">
						<span class="label label-required">独立权限元素: </span> <input
							id="visitmethodname" name="visitmethodname" type="text" value=""
							class="medium" /> <span class="label label-info">当表单页需要控制元素访问权限时，请输入表单元素的id名称，以告诉系统需要对此页面的form做进一步的权限判定</span>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidid" name="hidid" value="" /> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="modify" name="modify" value="更新" style="display: none;" />

					</div>

				</div>


			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/setting/functionmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>

