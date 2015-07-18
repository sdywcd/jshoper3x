<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("intro") != null ? request.getParameter("intro") : "";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>导航设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">导航设置 </a> <a
				class="brand2">编辑导航 </a>
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
					<strong>说明</strong> 请根据需要编辑导航
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div class="line-dotted"></div>
				<div class="btn-group">
					<button id="btnback" type="button" class="btn btn-success">返回</button>
				</div>
				<!-- 开始显示商品类型form表单 -->
				<div class="form-actions">
					<div class="form-inline">
						<span class="label label-required">导航名称: </span> <input
							id="name" name="name" type="text" value=""
							class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">选择系统内容: </span>
						<select id="syscontent" name="syscontent">

						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">显示位置:</span> 
						<select id="position" name="position">
							<option value="1">
								页面上部
							</option>
							<option value="2">
								页面中部
							</option>
							<option value="3">
								页面下部
							</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">链接地址: </span>
						<input id="htmlPath" name="htmlPath" type="text" value="" class="medium" />
					</div>
					<div class="form-inline">
						<span class="label label-required">新窗口打开:</span> <input type="radio"
							id="isTargetBlank" name="isTargetBlank" value="1" checked="checked" />
						<label for="radio-1">是 </label> <input type="radio"
							id="isTargetBlank" name="isTargetBlank" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">显示:</span> <input type="radio"
							id="isVisible" name="isVisible" value="1" checked="checked" />
						<label for="radio-1">是 </label> <input type="radio"
							id="isVisible" name="isVisible" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">标示: </span>
						<input id="sign" name="sign" type="text" value="" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">排序: </span>
						<input id="sort" name="sort" type="text" value="" class="small" />
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> 
						<input type="hidden" id="hidsnid" name="hidsnid" value="" />
						<input class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/pagecontent/sitenavigationmentjs.js"></script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>



