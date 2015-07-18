<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>店铺信息列表 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">基本信息</a> <a
				class="brand2">基本信息浏览</a>
		</div>

	</div>
	<div class="container-fluid containerb">

		<div class="row-fluid">

			<div class="span2">
				<!-- 引入左侧导航 -->
				<%@include file="/admin/left.jsp"%>
			</div>

			<div class="span10">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>你可以在这查看平台中所有的店铺信息资料</strong>
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>

				<div class="line-dotted"></div>
				<!-- flexigrid -->
				<div id="flexshopmanagement">
					<table id="shopmanagement" style="display: none;"></table>
				</div>
				<div class="line-dotted"></div>
				<!-- 提示框 -->
				<div id="defaultmodal" class="modal hide fade">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h3><span id="modaltitle">绑定店铺掌柜</span></h3>
					</div>
					<div class="modal-body">
						<p id="contentp">One fine body…</p>
					</div>
					<div class="modal-footer">
						<a href="#" id="defaultcancel" class="btn">取消</a> <a href="#"
							id="defaultsubmit" class="btn btn-primary">提交</a>
					</div>
				</div>
			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/shop/shopmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>

