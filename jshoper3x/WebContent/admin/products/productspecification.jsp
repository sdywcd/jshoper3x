<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>商品规格设置 &middot; jshoper</title>

</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">商品规格设置 </a> <a
				class="brand2">编辑商品规格 </a>
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
					<strong>说明</strong> 请根据需要编辑商品规格
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
						<span class="label label-required">选择商品类型: </span> <select
							id="goodstypetn" name="goodstypetn">

						</select> <span class="label label-info">请选择一个商品类型并增加其属性</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">选择规格类型: </span> <select
							id="specificationsType" name="specificationsType">
							<option value="1">文字类型</option>
							<option value="2">图片类型</option>
							<option value="3">颜色类型</option>
						</select> <span class="label label-info">请选择一个规格类型,文字类型适合于尺寸，尺码等文字可表述的规格，图片类型适合颜色及图片表示的规格，颜色类型系统提供了取色器帮助精细化色彩</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">规格名称:</span> <input type="text"
							id="name" name="name" class="small" /> <span
							class="label label-info">例如 颜色，尺码，重量</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">排序:</span> <input type="text"
							id="sort" name="sort" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">备注:</span> <input type="text"
							id="note" name="note" class="medium" />
					</div>
					<div class="form-inline">
						<div id="selectcolordiv">
							<div id="selectcolor" style="color: red; font-size: 1.4em"></div>
							<form action="" style="width: 500px; height: 200px;">
								<div id="picker" style="float: right;"></div>
								<div class="form-item">
									<input type="text" id="color1" name="color1" class="colorwell"
										value="#123456" />
								</div>
								<div class="form-item">
									<input type="text" id="color2" name="color2" class="colorwell"
										value="#123456" />
								</div>
								<div class="form-item">
									<input type="text" id="color3" name="color3" class="colorwell"
										value="#123456" />
								</div>

							</form>
						</div>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="addparam"
							name="addparam" value="增加规格" />
					</div>
				</div>
				<div id="specarea" class="form-actions">
					<div class="table">
						<table>
							<thead>
								<tr>
									<th id="specname" class="center">规格值名称</th>
									<th id="specvalue">规格值参数</th>
									<th id="specpc">图片</th>

									<th id="specsort">排序</th>
									<th>操作</th>
								</tr>

							</thead>
							<tbody>

							</tbody>
						</table>
					</div>

					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidspecificationsid" name="hidspecificationsid" value="" />
						<input class="btn btn-success" type="button" id="submit"
							name="submit" value="提交" /> <input class="btn btn-success"
							type="button" id="update" name="update" value="更新"
							style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>


	<script type="text/javascript"
		src="<%=basePath%>admin/js/products/productspecificationmentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/farbtastic/farbtastic.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>



