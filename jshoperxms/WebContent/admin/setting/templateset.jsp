<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>模板文件和系统内容关系设定 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">模板文件和系统内容关系设定</a>
			<a class="brand2">编辑模板文件和系统内容关系</a>
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
					<strong>你可以在这里编辑模板和系统内容关系</strong>
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
					<div id="xtsy" class="select" class="form-inline">
						<span class="label label-required">系统内容: </span> <select
							id="ssystemcontent" name="ssystemcontent">

						</select> <input type="button" id="modifysys" name="modifysys"
							value="编辑系统内容" style="display: none;" />

					</div>
					<div id="sys1" class="form-inline">
						<label class="label label-submit"></label>
					</div>

					<div id="zsys" style="display: none;" class="form-inline">
						<span class="label label-required">自定义系统内容:</span> <input
							id="zsystemcontent" name="zsystemcontent" type="text" value=""
							class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">使用的模板文件:</span> <select
							id="templateurl" name="templateurl">

						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">原标示和模板页面:</span> <input
							id="syssign" name="syssign" type="text" value="" class="large" />
					</div>
					<div class="form-inline">
						<span class="label label-required">新标示:</span> <input id="sign"
							name="sign" type="text" value="" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">静态页输出路径:</span> <input
							id="buildhtmlpath" name="buildhtmlpath" type="text"
							value="html/default/shop/" class="small" /> <span
							class="label label-info">填写规则为：html/主题/shop/页面名称.html或者是一个目录</span>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="tsid" name="tsid" value="" /> <input class="btn btn-success"
							type="button" id="submit" name="submit" value="提交" /> <input
							class="btn btn-success" type="button" id="modify" name="modify"
							value="更新" style="display: none;" />

					</div>
				</div>
			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/setting/templatesetmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>

