
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>商品类型及参数设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">商品类型及参数设置 </a> <a
				class="brand2">编辑商品类型及参数 </a>
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
					<strong>说明</strong> 请根据需要编辑商品类型及参数
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
						<span class="label label-required">商品类型名称: </span> <input
							id="name" name="name" type="text" value="" class="small" /> <span
							class="label label-info">给你销售的商品定义一个类型，例如手机</span>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" /> <input
							type="hidden" id="goodsTypeId" name="goodsTypeId" value="" />
					</div>

				</div>
				<!-- 开始显示商品类型参数区域 -->
				<div id="goodstypetnparamsarea" class="form-actions">
					<div class="alert alert-success">
						<button type="button" class="close" data-dismiss="alert">×</button>
						<strong>说明</strong> 请根据需要编辑参数列表
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="addparam"
							name="addparam" value="增加参数" />
					</div>
					<div class="table">
						<table>
							<thead>
								<tr>
									<th class="center">参数名称</th>
									<th>排序</th>
									<th>操作</th>
								</tr>

							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="submitparam"
							name="submitparam" value="提交" /> <input class="btn btn-success"
							type="button" id="updateparam" name="updateparam" value="更新"
							style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/goods/goodstypetnmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>



