<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>会员充值设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">会员充值设置 </a> <a
				class="brand2">编辑会员充值</a>
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
					<strong>说明</strong> 请根据需要编辑会员充值
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
				<!-- 开始会员分组form表单 -->
				<div class="form-actions">
					<div class="form-inline">
						<div id="selectgoodscategory" class="form-inline">
							<span class="label label-required">选择会员: </span> 
							 <input id="membername"
								name="membername" type="text" value="" class="small" />
							<button id="search" name="search" class="btn btn-primary"
								type="button">查询</button>
							<span class="label label-info">输入会员账号查询</span>
						</div>
					</div>
					
						<!-- flexigrid -->
						<div id="flexmembermanagement">
							<table id="membermanagement" style="display: none;"></table>
						</div>
					
					<div class="form-inline">
						<span class="label label-required">充值金额: </span> <input
							id="balance" name="balance" type="text" value="" class="small" />
						<span class="label label-info">请输入100的整数倍</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">操作方式:</span> <input
							type="radio" id="operatetype" name="operatetype" value="1"
							checked="checked" /> <label for="radio-1">增加金额</label> <input
							type="radio" id="operatetype" name="operatetype" value="0" /> <label
							for="radio-2">扣除金额</label>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label>
						<input type="hidden"
							id="hidmemberid" name="hidmemberid" value="" /> <input type="hidden"
							id="hidid" name="hidid" value="" /> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/member/memberrechargementjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>
