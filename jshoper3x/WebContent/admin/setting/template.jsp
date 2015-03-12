<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>模板 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">模板</a> <a
				class="brand2">编辑模板</a>
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
					<strong>说明</strong> 请根据需要编辑模板信息
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
						<span class="label label-required">主题选择:</span> <select
							id="templatetheme" name="templatetheme">
						</select>

					</div>
					<div class="form-inline">
						<span class="label label-required">类型:</span> <select id="type"
							name="type">
							<option value="0">---请选择---</option>
							<option value="1">页面模板</option>
							<option value="2">邮件模板</option>
							<option value="3">打印模板</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">模板名称: </span> <input id="name"
							name="name" type="text" value="" class="small" /> <span
							class="label label-info">主题名称只能由数字和字母组成</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">模板路径:</span> <input id="url"
							name="url" type="text" value="WEB-INF/theme/default/shop/"
							class="small" readonly />
					</div>
					<div class="form-inline">
						<span class="label label-required">标示:</span> <input id="sign"
							name="sign" type="text" value="" readonly /> <span
							class="label label-info">标示必须是全局唯一的，系统通过标示来寻找静态化数据和模板的关系</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">描述:</span> <input id="note"
							name="note" type="text" value="" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">模板内容:</span>
						<textarea id="tvalue" name="tvalue" cols="100" rows="80"
							style="width: 600px;"></textarea>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="tid" name="tid" value="" /> <input type="hidden" id="status"
							name="status" value="" /> <input type="hidden" id="themeid"
							name="themeid" value="" /> <input class="btn btn-success"
							type="submit" id="submit" name="submit" value="提交" /> <input
							class="btn btn-success" type="button" id="modify" name="modify"
							value="更新" style="display: none;" />

					</div>

				</div>


			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/setting/templatementjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>

