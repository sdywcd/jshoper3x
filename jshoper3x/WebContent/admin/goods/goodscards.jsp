<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>购物卡管理 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">购物卡信息管理 </a> <a
				id="dttitle" class="brand2">编辑购物卡信息 </a>
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
					<strong>说明</strong> 请根据需要编辑购物卡信息
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
					<div class="well">
						<h4>选择需生成购物卡的商品</h4>
					</div>
					<!-- flexigrid -->
					<div id="flexgoodsmanagement">
						<table id="goodsmanagement" style="display: none;"></table>
					</div>
					<div class="line-dotted"></div>
					<div class="form-inline">
						<span class="label label-required">生成的商品:</span> <input
							type="text" id="goodsname" name="goodsname" class="large" />
					</div>
					<div class="form-inline">
						<span class="label label-required">卡名:</span> <input
							type="text" id="cardname" name="cardname" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">生成数量:</span> <input
							type="text" id="amount" name="amount" class="small" />
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidid" name="hidid" value="">
							  <input type="hidden" id="hidgoodsid" name="hidgoodsid" value="">
							   <input type="hidden" id="hidgoodsname" name="hidgoodsname" value="">
							  <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>

			</div>

		</div>


	<script type="text/javascript"
		src="<%=basePath%>admin/js/goods/goodscardsmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>
</body>
</html>

